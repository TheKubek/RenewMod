package net.kubek.renew.entity.client;

import net.kubek.renew.Renew;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class OrbOfDominanceRenderer extends EyesFeatureRenderer {
    private static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(Renew.MOD_ID,"textures/entity/orb_of_dominance.png"));

    public OrbOfDominanceRenderer(FeatureRendererContext featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
