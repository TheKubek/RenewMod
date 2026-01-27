package net.kubek.renew.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class DancerSwordItem extends SwordItem {
    public DancerSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!target.isDead()) attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,40));
        else attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,200,2));
        return super.postHit(stack, target, attacker);
    }
}
