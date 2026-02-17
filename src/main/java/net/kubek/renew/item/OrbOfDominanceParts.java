package net.kubek.renew.item;

import net.kubek.renew.Renew;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.List;

public class OrbOfDominanceParts{

    public static final Item ORB_OF_DOMINANCE_PART_ONE = registerPart("orb_of_dominance_part_one",StatusEffects.HEALTH_BOOST,0);
    public static final Item ORB_OF_DOMINANCE_PART_TWO = registerPart("orb_of_dominance_part_two",StatusEffects.SATURATION,1);
    public static final Item ORB_OF_DOMINANCE_PART_THREE = registerPart("orb_of_dominance_part_three",StatusEffects.BLINDNESS,0);
    public static final Item ORB_OF_DOMINANCE_PART_FOUR = registerPart("orb_of_dominance_part_four",StatusEffects.SPEED,1);
    public static final Item ORB_OF_DOMINANCE_PART_FIVE = registerPart("orb_of_dominance_part_five",StatusEffects.DARKNESS,0);
    public static final Item ORB_OF_DOMINANCE_PART_SIX = registerPart("orb_of_dominance_part_six",StatusEffects.CONDUIT_POWER,0);
    public static final Item ORB_OF_DOMINANCE_PART_SEVEN = registerPart("orb_of_dominance_part_seven",StatusEffects.STRENGTH,1);
    public static final Item ORB_OF_DOMINANCE_PART_EIGHT = registerPart("orb_of_dominance_part_eight",StatusEffects.RESISTANCE,0);
    public static final Item ORB_OF_DOMINANCE_PART_NINE = registerPart("orb_of_dominance_part_nine",StatusEffects.FIRE_RESISTANCE,0);


    private static Item registerPart(String name, RegistryEntry<StatusEffect> statusEffect, int amplifier){
        return Registry.register(Registries.ITEM, Identifier.of(Renew.MOD_ID,name),new Item(new Item.Settings().maxCount(1).fireproof().rarity(Rarity.EPIC)){
            @Override
            public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
                if(entity instanceof PlayerEntity player)
                {
                    player.addStatusEffect(new StatusEffectInstance(statusEffect,200,amplifier));
                }
                super.inventoryTick(stack, world, entity, slot, false);
            }

            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("tooltip.renew.orb_of_dominance_part"));
                super.appendTooltip(stack, context, tooltip, type);
            }

        });
    }

    public static void registerOrbOfDominanceParts(){}
}
