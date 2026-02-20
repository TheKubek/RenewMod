package net.kubek.renew.entity.ai;

import net.kubek.renew.entity.custom.EnchanterEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;

import java.util.Random;

public class EnchanterAttackGoal extends MeleeAttackGoal {
    private final Random random = new Random();
    private final EnchanterEntity entity;
    private int attackDelay = 20;
    private int ticksUntilNextAttack=20;
    private boolean shouldCountTillNextAttack = false;

    public EnchanterAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = (EnchanterEntity) mob;
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        ticksUntilNextAttack = 20;
    }
    @Override
    protected void attack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        return this.entity.distanceTo(pEnemy) <= 15f;
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        if(this.entity.distanceTo(pEnemy)<=6f){
            this.mob.tryAttack(pEnemy.getEntityWorld().getServer().getWorld(pEnemy.getEntityWorld().getRegistryKey()),pEnemy);
            attackDelay = 20;
        }
        else{
            int chance = (random.nextInt(10) + 1);
            if(chance<=6){
                EvokerFangsEntity evokerFangs = new EvokerFangsEntity(EntityType.EVOKER_FANGS,pEnemy.getEntityWorld());
                evokerFangs.setPosition(pEnemy.getTrackedPosition().getPos());
                pEnemy.getEntityWorld().spawnEntity(evokerFangs);
            }
            else if(chance<=8){
                PillagerEntity entity1 = new PillagerEntity(EntityType.PILLAGER,pEnemy.getEntityWorld());
                entity1.setPosition(pEnemy.getX()-5,pEnemy.getY(),pEnemy.getZ());
                entity1.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.CROSSBOW));
                pEnemy.getEntityWorld().spawnEntity(entity1);
                PillagerEntity entity2 = new PillagerEntity(EntityType.PILLAGER,pEnemy.getEntityWorld());
                entity2.setPosition(pEnemy.getX()+5,pEnemy.getY(),pEnemy.getZ());
                entity2.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.CROSSBOW));
                pEnemy.getEntityWorld().spawnEntity(entity2);
            }
            else{
                VindicatorEntity entity1 = new VindicatorEntity(EntityType.VINDICATOR,pEnemy.getEntityWorld());
                entity1.setPosition(pEnemy.getX()-5,pEnemy.getY(),pEnemy.getZ());
                entity1.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.DIAMOND_AXE));
                pEnemy.getEntityWorld().spawnEntity(entity1);
                VindicatorEntity entity2 = new VindicatorEntity(EntityType.VINDICATOR,pEnemy.getEntityWorld());
                entity2.setPosition(pEnemy.getX()+5,pEnemy.getY(),pEnemy.getZ());
                entity2.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.DIAMOND_AXE));
                pEnemy.getEntityWorld().spawnEntity(entity2);
            }

            attackDelay = 60;
        }
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
    }
    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack){
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1,0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
