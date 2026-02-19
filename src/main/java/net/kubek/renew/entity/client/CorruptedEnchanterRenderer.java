package net.kubek.renew.entity.client;

import net.kubek.renew.Renew;
import net.kubek.renew.entity.custom.CorruptedEnchanterEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CorruptedEnchanterRenderer extends MobEntityRenderer<CorruptedEnchanterEntity,CorruptedEnchanterRenderState,CorruptedEnchanterModel> {
    public CorruptedEnchanterRenderer(EntityRendererFactory.Context context) {
        super(context, new CorruptedEnchanterModel(context.getPart(ModEntityModelLayers.CORRUPTED_ENCHANTER)),0.6F);
        this.addFeature(new CorruptedEnchanterEyesFeatureRender(this));
        this.addFeature(new OrbOfDominanceRenderer(this));
    }

    @Override
    public CorruptedEnchanterRenderState createRenderState() {
        return new CorruptedEnchanterRenderState();
    }

    @Override
    public Identifier getTexture(CorruptedEnchanterRenderState state) {
        return Identifier.of(Renew.MOD_ID, "textures/entity/corrupted_enchanter.png");
    }

    @Override
    public void updateRenderState(CorruptedEnchanterEntity livingEntity, CorruptedEnchanterRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.attackAnimationState.copyFrom(livingEntity.attackAnimationState);
    }
}
