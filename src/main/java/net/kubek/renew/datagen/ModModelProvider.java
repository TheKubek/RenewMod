package net.kubek.renew.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.kubek.renew.item.ModArmorMaterials;
import net.kubek.renew.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    itemModelGenerator.register(ModItems.WOODEN_CUTLASS, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STONE_CUTLASS, Models.HANDHELD);
    itemModelGenerator.register(ModItems.COPPER_CUTLASS, Models.HANDHELD);
    itemModelGenerator.register(ModItems.IRON_CUTLASS, Models.HANDHELD);
    itemModelGenerator.register(ModItems.GOLDEN_CUTLASS, Models.HANDHELD);
    itemModelGenerator.register(ModItems.DIAMOND_CUTLASS, Models.HANDHELD);
    itemModelGenerator.register(ModItems.NETHERITE_CUTLASS, Models.HANDHELD);
    itemModelGenerator.register(ModItems.WOODEN_SCYTHE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STONE_SCYTHE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.COPPER_SCYTHE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.IRON_SCYTHE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.GOLDEN_SCYTHE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.DIAMOND_SCYTHE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.NETHERITE_SCYTHE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.ENCHANTER_SCYTHE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.GLACIER_SCYTHE, Models.HANDHELD);

    itemModelGenerator.registerArmor(( ModItems.ORB_OF_DOMINANCE_HELMET), ModArmorMaterials.ORB_OF_DOMINANCE_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX,false);
    itemModelGenerator.registerArmor(( ModItems.ORB_OF_DOMINANCE_CHESTPLATE), ModArmorMaterials.ORB_OF_DOMINANCE_KEY,ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX,false);
    itemModelGenerator.registerArmor(( ModItems.ORB_OF_DOMINANCE_LEGGINGS), ModArmorMaterials.ORB_OF_DOMINANCE_KEY,ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX,false);
    itemModelGenerator.registerArmor(( ModItems.ORB_OF_DOMINANCE_BOOTS), ModArmorMaterials.ORB_OF_DOMINANCE_KEY,ItemModelGenerator.BOOTS_TRIM_ID_PREFIX,false);


    }
}
