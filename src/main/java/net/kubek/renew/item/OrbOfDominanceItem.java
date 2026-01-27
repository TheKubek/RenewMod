package net.kubek.renew.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class OrbOfDominanceItem extends Item {
    public OrbOfDominanceItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity player)
        {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,200,2));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,200,1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,200,2));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,200,4));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER,200,2));


        }
        super.inventoryTick(stack, world, entity, slot, false);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.renew.orb_of_dominance"));
        super.appendTooltip(stack, context, tooltip, type);
    }


}
