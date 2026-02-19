package net.kubek.renew.entity.client;

import net.kubek.renew.Renew;
import net.kubek.renew.entity.custom.EnchanterEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.EndermanEyesFeatureRenderer;
import net.minecraft.util.Identifier;

public class EnchanterRenderer extends MobEntityRenderer<EnchanterEntity,EnchanterRenderState,EnchanterModel> {
    public EnchanterRenderer(EntityRendererFactory.Context context) {
        super(context, new EnchanterModel(context.getPart(ModEntityModelLayers.ENCHANTER)),0.6f);
        this.addFeature(new OrbOfDominanceRenderer(this));
    }

    @Override
    public EnchanterRenderState createRenderState() {
        return new EnchanterRenderState();
    }

    @Override
    public Identifier getTexture(EnchanterRenderState state) {
        return Identifier.of(Renew.MOD_ID,"textures/entity/enchanter.png");
    }

    @Override
    public void updateRenderState(EnchanterEntity livingEntity, EnchanterRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.attackAnimationState.copyFrom(livingEntity.attackAnimationState);
    }
}
