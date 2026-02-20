package net.kubek.renew.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DancerSwordItem extends Item {

    public DancerSwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.sword(material,attackDamage,attackSpeed));
    }



    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!target.isDead()) attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,40));
        else attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,200,2));
        super.postHit(stack, target, attacker);
    }
}
