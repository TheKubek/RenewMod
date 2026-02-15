package net.kubek.renew.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kubek.renew.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_ORB_OF_DOMINANCE_TOOL)
                .forceAddTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ORB_OF_DOMINANCE_TOOl)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
