package net.kubek.renew;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kubek.renew.components.ModDataComponentTypes;
import net.kubek.renew.entity.ModEntities;
import net.kubek.renew.entity.client.*;
import net.kubek.renew.item.ModItems;
import net.kubek.renew.item.ModItemsGroup;
import net.kubek.renew.item.OrbOfDominanceParts;
import net.kubek.renew.item.OrbOfDominanceTools;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenewClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ENCHANTER, EnchanterModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ENCHANTER, EnchanterRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.CORRUPTED_ENCHANTER, CorruptedEnchanterModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CORRUPTED_ENCHANTER, CorruptedEnchanterRenderer::new);
    }
}