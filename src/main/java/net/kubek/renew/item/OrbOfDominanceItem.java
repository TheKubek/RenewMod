package net.kubek.renew.item;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class OrbOfDominanceItem extends Item {
    public OrbOfDominanceItem(Settings settings) {
        super(settings);
    }


    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if(entity instanceof PlayerEntity player)
        {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,200,2));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,200,1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,200,2));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,200,4));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER,200,2));


        }
        super.inventoryTick(stack, world, entity, slot);
    }



    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("tooltip.renew.orb_of_dominance"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }


}
