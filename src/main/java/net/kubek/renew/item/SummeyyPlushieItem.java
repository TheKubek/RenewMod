package net.kubek.renew.item;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;

public class SummeyyPlushieItem extends PlushieItem {
    public SummeyyPlushieItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_BAT_AMBIENT, SoundCategory.PLAYERS, 10f, 1f);
        if(!world.isClient&&user.getUuidAsString()=="86a471bf-b691-4d7e-9bf1-23563b5a201a") {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,200,1));
            user.addExperience(4);
            user.giveItemStack(new ItemStack(Items.CAKE,1));
        }

        return ActionResult.SUCCESS;

    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.literal("Wszystkiego najlepszego Summeyy"));
        textConsumer.accept(Text.literal("24.12.2025 01:24 - §oTheKubek"));
        textConsumer.accept(Text.literal(""));
        textConsumer.accept(Text.literal(""));
        textConsumer.accept(Text.literal("--§5DEV ITEM§r--"));


        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}
