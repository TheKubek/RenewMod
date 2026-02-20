package net.kubek.renew.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

public class OrbOfDominanceTools {
    public static final Item ORB_OF_DOMINANCE_SWORD = ModItems.registerItem("orb_of_dominance_sword",settings -> new OrbOfDominanceSwordItem(ModToolMaterials.ORB_OF_DOMINANCE, 3, -2.4f, settings.rarity(Rarity.EPIC).fireproof()));

    public static final Item ORB_OF_DOMINANCE_AXE = ModItems.registerItem("orb_of_dominance_axe",settings -> new AxeItem(ModToolMaterials.ORB_OF_DOMINANCE, 6, -3.2f, settings.rarity(Rarity.EPIC).fireproof()) {
        @Override
        public ActionResult use(World world, PlayerEntity user, Hand hand) {
            if (!world.isClient()) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 100, 0));
            }
            return ActionResult.SUCCESS;
        }
    });
    public static final Item ORB_OF_DOMINANCE_PICKAXE = ModItems.registerItem("orb_of_dominance_pickaxe",settings -> new Item( settings.pickaxe(ModToolMaterials.ORB_OF_DOMINANCE, 1.5f, -2.8f).rarity(Rarity.EPIC).fireproof()) {
        @Override
        public ActionResult use(World world, PlayerEntity user, Hand hand) {
            if (!world.isClient()) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 100, 0));
            }
            return ActionResult.SUCCESS;
        }
    });
    public static final Item ORB_OF_DOMINANCE_SHOVEL = ModItems.registerItem("orb_of_dominance_shovel",settings -> new ShovelItem(ModToolMaterials.ORB_OF_DOMINANCE, 3, -3f, settings.rarity(Rarity.EPIC).fireproof()) {
        @Override
        public ActionResult use(World world, PlayerEntity user, Hand hand) {
            if (!world.isClient()) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 0));
            }
            return ActionResult.SUCCESS;
        }
    });
    public static final Item ORB_OF_DOMINANCE_HOE = ModItems.registerItem("orb_of_dominance_hoe",settings -> new HoeItem(ModToolMaterials.ORB_OF_DOMINANCE, 0, -3f, settings.rarity(Rarity.EPIC).fireproof()) {
        @Override
        public ActionResult use(World world, PlayerEntity user, Hand hand) {
            if (!world.isClient()) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0));
            }
            return ActionResult.SUCCESS;
        }
    });
    public static final Item ORB_OF_DOMINANCE_SPEAR = ModItems.registerItem("orb_of_dominance_spear",settings -> new Item(settings.spear(ModToolMaterials.ORB_OF_DOMINANCE, 1.0F, 1.4F, 0.4F, 2.5F, 7.0F, 5.5F, 5.1F, 8.75F, 4.6F).fireproof().rarity(Rarity.EPIC)));
    public static final Item ORB_OF_DOMINANCE_CUTLASS = ModItems.registerItem("orb_of_dominance_cutlass",settings -> new OrbOfDominanceSwordItem(ModToolMaterials.ORB_OF_DOMINANCE, 1, -1f, settings.rarity(Rarity.EPIC).fireproof()));
    public static final Item ORB_OF_DOMINANCE_SCYTHE = ModItems.registerItem("orb_of_dominance_scythe",settings -> new ScytheItem(ModToolMaterials.ORB_OF_DOMINANCE, 1f, -3f, settings.rarity(Rarity.EPIC).fireproof()));


    public static void registerOrbOfDominanceTools() {
    }
}

