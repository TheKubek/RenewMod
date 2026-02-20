package net.kubek.renew.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kubek.renew.item.ModItems;
import net.kubek.renew.item.OrbOfDominanceParts;
import net.kubek.renew.item.OrbOfDominanceTools;
import net.kubek.renew.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.CUTLASSES)
                .add(ModItems.WOODEN_CUTLASS)
                .add(ModItems.STONE_CUTLASS)
                .add(ModItems.COPPER_CUTLASS)
                .add(ModItems.IRON_CUTLASS)
                .add(ModItems.GOLDEN_CUTLASS)
                .add(ModItems.DIAMOND_CUTLASS)
                .add(ModItems.NETHERITE_CUTLASS)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_CUTLASS)
                .add(ModItems.DANCER_SWORD);
        valueLookupBuilder(ItemTags.SWORDS)
                .addTag(ModTags.Items.CUTLASSES);
        valueLookupBuilder(ModTags.Items.SCYTHES)
                .add(ModItems.WOODEN_SCYTHE)
                .add(ModItems.STONE_SCYTHE)
                .add(ModItems.COPPER_SCYTHE)
                .add(ModItems.IRON_SCYTHE)
                .add(ModItems.GOLDEN_SCYTHE)
                .add(ModItems.DIAMOND_SCYTHE)
                .add(ModItems.NETHERITE_SCYTHE)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_SCYTHE)
                .add(ModItems.ENCHANTER_SCYTHE)
                .add(ModItems.GLACIER_SCYTHE);
        valueLookupBuilder(ItemTags.HOES)
                .addTag(ModTags.Items.SCYTHES)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_HOE);
        valueLookupBuilder(ItemTags.SWORDS)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_SWORD);
        valueLookupBuilder(ItemTags.AXES)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_AXE);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_SHOVEL);
        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.ORB_OF_DOMINANCE_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.ORB_OF_DOMINANCE_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.ORB_OF_DOMINANCE_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.ORB_OF_DOMINANCE_BOOTS);
        valueLookupBuilder(ModTags.Items.ORB_OF_DOMINANCE)
                .add(ModItems.ORB_OF_DOMINANCE)
                .add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE)
                .add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_TWO)
                .add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_THREE)
                .add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FOUR)
                .add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FIVE)
                .add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SIX)
                .add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SEVEN)
                .add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_EIGHT)
                .add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_NINE);
    }
}
