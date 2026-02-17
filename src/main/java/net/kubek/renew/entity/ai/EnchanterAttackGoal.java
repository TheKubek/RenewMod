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
            this.mob.tryAttack(pEnemy);
            attackDelay = 20;
        }
        else{
            int chance = (random.nextInt(10) + 1);
            if(chance<=5){
                EvokerFangsEntity evokerFangs = new EvokerFangsEntity(EntityType.EVOKER_FANGS,pEnemy.getWorld());
                evokerFangs.setPosition(pEnemy.getPos());
                pEnemy.getWorld().spawnEntity(evokerFangs);
            }
            else if(chance<=7){
                PillagerEntity entity1 = new PillagerEntity(EntityType.PILLAGER,pEnemy.getWorld());
                entity1.setPosition(pEnemy.getX()-5,pEnemy.getY(),pEnemy.getZ());
                entity1.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.CROSSBOW));
                pEnemy.getWorld().spawnEntity(entity1);
                PillagerEntity entity2 = new PillagerEntity(EntityType.PILLAGER,pEnemy.getWorld());
                entity2.setPosition(pEnemy.getX()+5,pEnemy.getY(),pEnemy.getZ());
                entity2.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.CROSSBOW));
                pEnemy.getWorld().spawnEntity(entity2);
            }
            else if (chance<=9){
                VindicatorEntity entity1 = new VindicatorEntity(EntityType.VINDICATOR,pEnemy.getWorld());
                entity1.setPosition(pEnemy.getX()-5,pEnemy.getY(),pEnemy.getZ());
                entity1.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.DIAMOND_AXE));
                pEnemy.getWorld().spawnEntity(entity1);
                VindicatorEntity entity2 = new VindicatorEntity(EntityType.VINDICATOR,pEnemy.getWorld());
                entity2.setPosition(pEnemy.getX()+5,pEnemy.getY(),pEnemy.getZ());
                entity2.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.DIAMOND_AXE));
                pEnemy.getWorld().spawnEntity(entity2);
            }
            else {
                VexEntity entity1 = new VexEntity(EntityType.VEX,pEnemy.getWorld());
                entity1.setPosition(pEnemy.getX()-5,pEnemy.getY(),pEnemy.getZ());
                entity1.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.DIAMOND_SWORD));
                pEnemy.getWorld().spawnEntity(entity1);
                VexEntity entity2 = new VexEntity(EntityType.VEX,pEnemy.getWorld());
                entity2.setPosition(pEnemy.getX()+5,pEnemy.getY(),pEnemy.getZ());
                entity2.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.DIAMOND_SWORD));
                pEnemy.getWorld().spawnEntity(entity2);
                VexEntity entity3 = new VexEntity(EntityType.VEX,pEnemy.getWorld());
                entity3.setPosition(pEnemy.getX(),pEnemy.getY(),pEnemy.getZ()-5);
                entity3.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.DIAMOND_SWORD));
                pEnemy.getWorld().spawnEntity(entity3);
                VexEntity entity4 = new VexEntity(EntityType.VEX,pEnemy.getWorld());
                entity4.setPosition(pEnemy.getX(),pEnemy.getY(),pEnemy.getZ()+5);
                entity4.setStackInHand(Hand.MAIN_HAND,new ItemStack(Items.DIAMOND_SWORD));
                pEnemy.getWorld().spawnEntity(entity4);

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
