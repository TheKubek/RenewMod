package net.kubek.renew.entity.client;

import net.kubek.renew.Renew;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

public class OrbOfDominanceRenderer extends EyesFeatureRenderer {
    private static final RenderLayer SKIN = RenderLayers.eyes(Identifier.of(Renew.MOD_ID,"textures/entity/orb_of_dominance.png"));

    public OrbOfDominanceRenderer(FeatureRendererContext featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
