package net.kubek.renew.entity.client;

import net.kubek.renew.Renew;
import net.kubek.renew.entity.custom.CorruptedEnchanterEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CorruptedEnchanterRenderer extends MobEntityRenderer<CorruptedEnchanterEntity,CorruptedEnchanterModel<CorruptedEnchanterEntity>> {
    public CorruptedEnchanterRenderer(EntityRendererFactory.Context context) {
        super(context, new CorruptedEnchanterModel(context.getPart(ModEntityModelLayers.CORRUPTED_ENCHANTER)),0.6F);
        this.addFeature(new CorruptedEnchanterEyesFeatureRender(this));
        this.addFeature(new OrbOfDominanceRenderer(this));
    }

    @Override
    public Identifier getTexture(CorruptedEnchanterEntity entity) {
        return Identifier.of(Renew.MOD_ID, "textures/entity/corrupted_enchanter.png");
    }

    @Override
    public void render(CorruptedEnchanterEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
