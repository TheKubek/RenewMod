package net.kubek.renew.entity.custom;

import net.kubek.renew.entity.ai.CorruptedEnchanterAttackGoal;
import net.kubek.renew.entity.ai.EnchanterAttackGoal;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.function.Predicate;

public class CorruptedEnchanterEntity extends IllagerEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(CorruptedEnchanterEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public final AnimationState idleAnimationState= new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    protected final Random random = Random.create();

    private final ServerBossBar bossBar = (ServerBossBar)new ServerBossBar(this.getDisplayName(), BossBar.Color.RED, BossBar.Style.PROGRESS).setDragonMusic(true).setThickenFog(true).setDarkenSky(true);
    public CorruptedEnchanterEntity(EntityType<? extends IllagerEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createCorruptedEnchanterAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 4000f)
                .add(EntityAttributes.MOVEMENT_SPEED,0.4f)
                .add(EntityAttributes.ATTACK_DAMAGE,20f)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE,2f)
                .add(EntityAttributes.ARMOR,4f);

    }
    static final Predicate<Difficulty> DIFFICULTY_ALLOWS_DOOR_BREAKING_PREDICATE = difficulty -> difficulty == Difficulty.NORMAL || difficulty == Difficulty.HARD;

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new CorruptedEnchanterEntity.BreakDoorGoal(this));
        this.goalSelector.add(2, new LongDoorInteractGoal(this));
        this.goalSelector.add(3, new PatrolApproachGoal(this, 10.0F));
        this.goalSelector.add(4, new CorruptedEnchanterAttackGoal(this, 1.0, true));
        this.targetSelector.add(1, new RevengeGoal(this, RaiderEntity.class).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, MerchantEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, IronGolemEntity.class, true));
        this.targetSelector.add(4, new CorruptedEnchanterEntity.TargetGoal(this));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0F));
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
        if(this.getEntityWorld().isClient()){
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

    static class BreakDoorGoal extends net.minecraft.entity.ai.goal.BreakDoorGoal {
        public BreakDoorGoal(MobEntity mobEntity) {
            super(mobEntity, 6, CorruptedEnchanterEntity.DIFFICULTY_ALLOWS_DOOR_BREAKING_PREDICATE);
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean shouldContinue() {
            VindicatorEntity vindicatorEntity = (VindicatorEntity)this.mob;
            return vindicatorEntity.hasActiveRaid() && super.shouldContinue();
        }

        @Override
        public boolean canStart() {
            CorruptedEnchanterEntity enchanter = (CorruptedEnchanterEntity) this.mob;
            return enchanter.hasActiveRaid() && enchanter.random.nextInt(toGoalTicks(10)) == 0 && super.canStart();
        }

        @Override
        public void start() {
            super.start();
            this.mob.setDespawnCounter(0);
        }
    }
    static class TargetGoal extends ActiveTargetGoal<LivingEntity> {
        public TargetGoal(CorruptedEnchanterEntity enchanter) {
            super(enchanter, LivingEntity.class, 0, true, true, (target, world) -> target.isMobOrPlayer());
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
    public boolean cannotDespawn() {
        return true;
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
    protected void mobTick(ServerWorld world) {
        super.mobTick(world);
        this.bossBar.setPercent(this.getHealth()/this.getMaxHealth());
    }


    @Override
    public void onDamaged(DamageSource damageSource) {
        int r = random.nextInt(random.nextInt(100) + 1);
        if(r<=70){

        }
        else if(r<=90){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,100,0));
        }
        else if (r<=95) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,100,0));
        }
        else{
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,80,255));
        }
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ENDERMAN_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ENDERMAN_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ELDER_GUARDIAN_HURT;
    }


}
