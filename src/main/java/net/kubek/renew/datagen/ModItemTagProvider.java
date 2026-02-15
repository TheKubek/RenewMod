package net.kubek.renew.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kubek.renew.item.ModItems;
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
        getOrCreateTagBuilder(ModTags.Items.CUTLASSES)
                .add(ModItems.WOODEN_CUTLASS)
                .add(ModItems.STONE_CUTLASS)
                .add(ModItems.IRON_CUTLASS)
                .add(ModItems.GOLDEN_CUTLASS)
                .add(ModItems.DIAMOND_CUTLASS)
                .add(ModItems.NETHERITE_CUTLASS)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_CUTLASS)
                .add(ModItems.DANCER_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .addTag(ModTags.Items.CUTLASSES);
        getOrCreateTagBuilder(ModTags.Items.SCYTHES)
                .add(ModItems.WOODEN_SCYTHE)
                .add(ModItems.STONE_SCYTHE)
                .add(ModItems.IRON_SCYTHE)
                .add(ModItems.GOLDEN_SCYTHE)
                .add(ModItems.DIAMOND_SCYTHE)
                .add(ModItems.NETHERITE_SCYTHE)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_SCYTHE)
                .add(ModItems.ENCHANTER_SCYTHE)
                .add(ModItems.GLACIER_SCYTHE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .addTag(ModTags.Items.SCYTHES)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_HOE);
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(OrbOfDominanceTools.ORB_OF_DOMINANCE_SHOVEL);


    }
}
