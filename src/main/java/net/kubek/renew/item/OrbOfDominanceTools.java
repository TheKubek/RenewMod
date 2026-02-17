package net.kubek.renew.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class OrbOfDominanceTools {
    public static final Item ORB_OF_DOMINANCE_SWORD = ModItems.registerItem("orb_of_dominance_sword", new OrbOfDominanceSwordItem(ModToolMaterials.ORB_OF_DOMINANCE, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ORB_OF_DOMINANCE, 3, -2.4f))));

    public static final Item ORB_OF_DOMINANCE_AXE = ModItems.registerItem("orb_of_dominance_axe", new AxeItem(ModToolMaterials.ORB_OF_DOMINANCE, new Item.Settings().fireproof().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ORB_OF_DOMINANCE, 6, -3.2f))) {
        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            if (!world.isClient) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 100, 0));
            }
            return TypedActionResult.success(user.getStackInHand(hand), true);
        }
    });
    public static final Item ORB_OF_DOMINANCE_PICKAXE = ModItems.registerItem("orb_of_dominance_pickaxe", new PickaxeItem(ModToolMaterials.ORB_OF_DOMINANCE, new Item.Settings().fireproof().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ORB_OF_DOMINANCE, 1.5f, -2.8f))) {
        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            if (!world.isClient) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 100, 0));
            }
            return TypedActionResult.success(user.getStackInHand(hand), true);
        }
    });
    public static final Item ORB_OF_DOMINANCE_SHOVEL = ModItems.registerItem("orb_of_dominance_shovel", new ShovelItem(ModToolMaterials.ORB_OF_DOMINANCE, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ORB_OF_DOMINANCE, 3, -3f))) {
        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            if (!world.isClient) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 0));
            }
            return TypedActionResult.success(user.getStackInHand(hand), true);
        }
    });
    public static final Item ORB_OF_DOMINANCE_HOE = ModItems.registerItem("orb_of_dominance_hoe", new HoeItem(ModToolMaterials.ORB_OF_DOMINANCE, new Item.Settings().fireproof().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ORB_OF_DOMINANCE, 0, -3f))) {
        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            if (!world.isClient) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0));
            }
            return TypedActionResult.success(user.getStackInHand(hand), true);
        }
    });
    public static final Item ORB_OF_DOMINANCE_CUTLASS = ModItems.registerItem("orb_of_dominance_cutlass", new SwordItem(ModToolMaterials.ORB_OF_DOMINANCE, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ORB_OF_DOMINANCE, 1, -1f))));
    public static final Item ORB_OF_DOMINANCE_SCYTHE = ModItems.registerItem("orb_of_dominance_scythe", new ScytheItem(ModToolMaterials.ORB_OF_DOMINANCE, new Item.Settings().fireproof().attributeModifiers(ScytheItem.createAttributeModifiers(ModToolMaterials.ORB_OF_DOMINANCE, 1f, -3f))));


    public static void registerOrbOfDominanceTools() {
    }
}

