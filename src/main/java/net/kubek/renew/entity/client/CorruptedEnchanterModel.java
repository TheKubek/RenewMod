package net.kubek.renew.entity.client;

import net.kubek.renew.entity.client.animation.CorruptedEnchanterAnimation;
import net.kubek.renew.entity.custom.CorruptedEnchanterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class CorruptedEnchanterModel extends EntityModel<CorruptedEnchanterRenderState> {
    private final ModelPart enchanter;
    private final ModelPart legs;
    private final ModelPart left;
    private final ModelPart right;
    private final ModelPart body;
    private final ModelPart hands;
    private final ModelPart right2;
    private final ModelPart left2;
    private final ModelPart head;
    private final ModelPart orb;
    public CorruptedEnchanterModel(ModelPart root) {
        super(root);
        this.enchanter = root.getChild("enchanter");
        this.legs = this.enchanter.getChild("legs");
        this.left = this.legs.getChild("left");
        this.right = this.legs.getChild("right");
        this.body = this.enchanter.getChild("body");
        this.hands = this.enchanter.getChild("hands");
        this.right2 = this.hands.getChild("right2");
        this.left2 = this.hands.getChild("left2");
        this.head = this.enchanter.getChild("head");
        this.orb = this.enchanter.getChild("orb");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData enchanter = modelPartData.addChild("enchanter", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F,0F,0F,0F));

        ModelPartData legs = enchanter.addChild("legs", ModelPartBuilder.create(), ModelTransform.of(0.0F, -9.0F, 0.0F,0F,0F,0F));

        ModelPartData left = legs.addChild("left", ModelPartBuilder.create().uv(0, 58).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -9.0F, 0.0F,0F,0F,0F));

        ModelPartData right = legs.addChild("right", ModelPartBuilder.create().uv(54, 52).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -9.0F, 0.0F,0F,0F,0F));

        ModelPartData body = enchanter.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(1.0F, -36.0F, -4.0F, 7.0F, 18.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 6).cuboid(-8.0F, -36.0F, -4.0F, 9.0F, 18.0F, 8.0F, new Dilation(0.0F))
                .uv(58, 6).cuboid(-8.0F, -18.0F, -4.0F, 16.0F, 3.0F, 0.0F, new Dilation(0.0F))
                .uv(58, 9).cuboid(-8.0F, -18.0F, 4.0F, 16.0F, 3.0F, 0.0F, new Dilation(0.0F))
                .uv(58, 12).cuboid(8.0F, -18.0F, -4.0F, 0.0F, 3.0F, 8.0F, new Dilation(0.0F))
                .uv(62, 23).cuboid(-8.0F, -18.0F, -4.0F, 0.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F,0F,0F,0F));

        ModelPartData hands = enchanter.addChild("hands", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F,0F,0F,0F));

        ModelPartData right2 = hands.addChild("right2", ModelPartBuilder.create(), ModelTransform.of(-10.0104F, -32.5727F, 0.1364F,0F,0F,0F));

        ModelPartData cube_r1 = right2.addChild("cube_r1", ModelPartBuilder.create().uv(30, 52).cuboid(-5.5F, -1.8326F, -2.7075F, 5.0F, 18.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(2.5104F, -1.1524F, -0.3762F, -0.1745F, 0.0F, 0.0F));

        ModelPartData left2 = hands.addChild("left2", ModelPartBuilder.create().uv(34, 6).cuboid(-0.5F, -2.0F, -3.5F, 5.0F, 18.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(8.5F, -33.5577F, 0.5528F,0F,0F,0F));

        ModelPartData head = enchanter.addChild("head", ModelPartBuilder.create().uv(30, 32).cuboid(-5.25F, -14.5F, -0.75F, 10.0F, 14.0F, 6.0F, new Dilation(0.0F))
                .uv(74, 12).cuboid(-1.75F, -8.5F, -3.75F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -35.5F, -2.25F,0F,0F,0F));

        ModelPartData orb = enchanter.addChild("orb", ModelPartBuilder.create(), ModelTransform.of(0.0F, -30.6969F, -3.1605F,0F,0F,0F));

        ModelPartData cube_r2 = orb.addChild("cube_r2", ModelPartBuilder.create().uv(62, 34).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.7512F, -0.6785F, -0.4921F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(CorruptedEnchanterRenderState state) {
        super.setAngles(state);
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngle(state.relativeHeadYaw,state.pitch);

        this.animateWalking(CorruptedEnchanterAnimation.walk,state.limbSwingAnimationProgress,state.limbSwingAmplitude,4f,2.5f);
        this.animate(state.idleAnimationState,CorruptedEnchanterAnimation.idle,state.age,1f);
        this.animate(state.attackAnimationState,CorruptedEnchanterAnimation.attack,state.age,1f);

    }
    private void setHeadAngle(float headYaw, float headPitch){
        headYaw = MathHelper.clamp(headYaw,-30.0f,30.f);
        headPitch = MathHelper.clamp(headPitch,-25.0f,45.f);
        this.head.yaw=headYaw*0.017453292F;
        this.head.pitch=headPitch*0.017453292F;
    }
    public ModelPart getPart() {
        return enchanter;
    }



}
