package net.kubek.renew.entity.custom;

import net.kubek.renew.entity.ModEntities;
import net.kubek.renew.entity.ai.EnchanterAttackGoal;
import net.kubek.renew.entity.client.animation.EnchanterAnimations;
import net.kubek.renew.item.ModItems;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.function.Predicate;

public class EnchanterEntity extends IllagerEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(EnchanterEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public final AnimationState idleAnimationState= new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    protected final Random random = Random.create();

    private final ServerBossBar bossBar = (ServerBossBar)new ServerBossBar(this.getDisplayName(), BossBar.Color.YELLOW, BossBar.Style.PROGRESS).setDragonMusic(true).setThickenFog(true);
    public EnchanterEntity(EntityType<? extends IllagerEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createEnchanterAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 2000f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.33f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,8f);

    }
    static final Predicate<Difficulty> DIFFICULTY_ALLOWS_DOOR_BREAKING_PREDICATE = difficulty -> difficulty == Difficulty.NORMAL || difficulty == Difficulty.HARD;

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EnchanterEntity.BreakDoorGoal(this));
        this.goalSelector.add(2, new IllagerEntity.LongDoorInteractGoal(this));
        this.goalSelector.add(3, new RaiderEntity.PatrolApproachGoal(this, 10.0F));
        this.goalSelector.add(4, new EnchanterAttackGoal(this, 1.0, true));
        this.targetSelector.add(1, new RevengeGoal(this, RaiderEntity.class).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, MerchantEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, IronGolemEntity.class, true));
        this.targetSelector.add(4, new EnchanterEntity.TargetGoal(this));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 0.6));
        this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 20.0F, 1.0F));
        this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 2.0F));
    }
    private void setupAnimationsStates(){
        if(this.idleAnimationTimeout<=0){
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);
        }else {
            --this.idleAnimationTimeout;
        }
        if(this.isAttacking()&&attackAnimationTimeout<=0){
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.age);
        }
        else {
            --this.attackAnimationTimeout;
        }
        if(!this.isAttacking()){
            attackAnimationState.stop();
        }

    }
    public void setAttacking(boolean attacking){
        this.dataTracker.set(ATTACKING,attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ATTACKING,false);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient){
            this.setupAnimationsStates();
        }
    }

    @Override
    public void addBonusForWave(ServerWorld world, int wave, boolean unused) {

    }

    @Override
    public SoundEvent getCelebratingSound() {
        return null;
    }
    @Override
    public boolean cannotDespawn() {
        return true;
    }
    static class BreakDoorGoal extends net.minecraft.entity.ai.goal.BreakDoorGoal {
        public BreakDoorGoal(MobEntity mobEntity) {
            super(mobEntity, 6, EnchanterEntity.DIFFICULTY_ALLOWS_DOOR_BREAKING_PREDICATE);
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        @Override
        public boolean shouldContinue() {
            VindicatorEntity vindicatorEntity = (VindicatorEntity)this.mob;
            return vindicatorEntity.hasActiveRaid() && super.shouldContinue();
        }

        @Override
        public boolean canStart() {
            EnchanterEntity enchanter = (EnchanterEntity) this.mob;
            return enchanter.hasActiveRaid() && enchanter.random.nextInt(toGoalTicks(10)) == 0 && super.canStart();
        }

        @Override
        public void start() {
            super.start();
            this.mob.setDespawnCounter(0);
        }
    }
    static class TargetGoal extends ActiveTargetGoal<LivingEntity> {
        public TargetGoal(EnchanterEntity enchanter) {
            super(enchanter, LivingEntity.class, 0, true, true, LivingEntity::isMobOrPlayer);
        }

        @Override
        public boolean canStart() {
            return super.canStart();
        }

        @Override
        public void start() {
            super.start();
            this.mob.setDespawnCounter(0);
        }
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        this.bossBar.setPercent(this.getHealth()/this.getMaxHealth());
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_EVOKER_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_EVOKER_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_EVOKER_HURT;
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        assert damageSource.getAttacker() != null;
        World world = damageSource.getAttacker().getWorld();
        CorruptedEnchanterEntity corruptedEnchanterEntity = new CorruptedEnchanterEntity(ModEntities.CORRUPTED_ENCHANTER, world);
        corruptedEnchanterEntity.setPosition(this.getPos());
        world.spawnEntity(corruptedEnchanterEntity);
    }
}
