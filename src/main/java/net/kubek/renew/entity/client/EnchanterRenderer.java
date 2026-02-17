package net.kubek.renew.entity.client;

import net.kubek.renew.Renew;
import net.kubek.renew.entity.custom.EnchanterEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class EnchanterRenderer extends MobEntityRenderer<EnchanterEntity,EnchanterModel> {
    public EnchanterRenderer(EntityRendererFactory.Context context) {
        super(context, new EnchanterModel(context.getPart(ModEntityModelLayers.ENCHANTER)),0.6f);
    }

    @Override
    public Identifier getTexture(EnchanterEntity entity) {
        return Identifier.of(Renew.MOD_ID,"textures/entity/enchanter.png");
    }


}
