package net.kubek.renew.entity.client;

import net.kubek.renew.entity.client.animation.EnchanterAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class EnchanterModel extends EntityModel<EnchanterRenderState> {
    private final ModelPart enchanter;
    private final ModelPart legs;
    private final ModelPart left;
    private final ModelPart right;
    private final ModelPart body;
    private final ModelPart hands;
    private final ModelPart right2;
    private final ModelPart wand;
    private final ModelPart orb;
    private final ModelPart left2;
    private final ModelPart head;
    public EnchanterModel(ModelPart root) {
        super(root);
        this.enchanter = root.getChild("enchanter");
        this.legs = this.enchanter.getChild("legs");
        this.left = this.legs.getChild("left");
        this.right = this.legs.getChild("right");
        this.body = this.enchanter.getChild("body");
        this.hands = this.enchanter.getChild("hands");
        this.right2 = this.hands.getChild("right2");
        this.wand = this.right2.getChild("wand");
        this.orb = this.wand.getChild("orb");
        this.left2 = this.hands.getChild("left2");
        this.head = this.enchanter.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData enchanter = modelPartData.addChild("enchanter", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData legs = enchanter.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

        ModelPartData left = legs.addChild("left", ModelPartBuilder.create().uv(0, 58).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -9.0F, 0.0F));

        ModelPartData right = legs.addChild("right", ModelPartBuilder.create().uv(54, 52).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -9.0F, 0.0F));

        ModelPartData body = enchanter.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(1.0F, -36.0F, -4.0F, 7.0F, 18.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 6).cuboid(-8.0F, -36.0F, -4.0F, 9.0F, 18.0F, 8.0F, new Dilation(0.0F))
                .uv(58, 6).cuboid(-8.0F, -18.0F, -4.0F, 16.0F, 3.0F, 0.0F, new Dilation(0.0F))
                .uv(58, 9).cuboid(-8.0F, -18.0F, 4.0F, 16.0F, 3.0F, 0.0F, new Dilation(0.0F))
                .uv(58, 12).cuboid(8.0F, -18.0F, -4.0F, 0.0F, 3.0F, 8.0F, new Dilation(0.0F))
                .uv(62, 23).cuboid(-8.0F, -18.0F, -4.0F, 0.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData hands = enchanter.addChild("hands", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right2 = hands.addChild("right2", ModelPartBuilder.create(), ModelTransform.pivot(-10.0104F, -32.5727F, 0.1364F));

        ModelPartData cube_r1 = right2.addChild("cube_r1", ModelPartBuilder.create().uv(30, 52).cuboid(-5.5F, -1.8326F, -2.7075F, 5.0F, 18.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(2.5104F, -1.1524F, -0.3762F, -0.8727F, 0.0F, 0.0F));

        ModelPartData wand = right2.addChild("wand", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

        ModelPartData cube_r2 = wand.addChild("cube_r2", ModelPartBuilder.create().uv(38, 77).cuboid(-2.5F, -0.5F, -1.0937F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5104F, -17.8148F, -15.3372F, 1.5708F, 1.0472F, 1.5708F));

        ModelPartData cube_r3 = wand.addChild("cube_r3", ModelPartBuilder.create().uv(24, 77).cuboid(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.4896F, -18.3922F, -11.4309F, -1.5708F, 1.1345F, -1.5708F));

        ModelPartData cube_r4 = wand.addChild("cube_r4", ModelPartBuilder.create().uv(62, 42).cuboid(-13.5F, 1.0F, -1.5F, 5.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.4896F, -25.8922F, -7.4309F, -1.5708F, 0.0F, -1.5708F));

        ModelPartData cube_r5 = wand.addChild("cube_r5", ModelPartBuilder.create().uv(60, 0).cuboid(-13.5F, 1.0F, -2.5F, 5.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5104F, -21.8922F, -8.4309F, -1.5708F, 0.0F, -1.5708F));

        ModelPartData cube_r6 = wand.addChild("cube_r6", ModelPartBuilder.create().uv(70, 76).cuboid(-13.5F, 1.0F, -2.0F, 5.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.5104F, -16.8922F, -12.4309F, -1.5708F, 0.0F, -1.5708F));

        ModelPartData cube_r7 = wand.addChild("cube_r7", ModelPartBuilder.create().uv(54, 76).cuboid(-13.5F, 1.0F, -1.0F, 5.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.5104F, 0.1078F, -12.4309F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r8 = wand.addChild("cube_r8", ModelPartBuilder.create().uv(62, 47).cuboid(-13.5F, 1.0F, -1.0F, 6.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.4896F, -8.8922F, -12.4309F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r9 = wand.addChild("cube_r9", ModelPartBuilder.create().uv(0, 0).cuboid(-13.5F, -2.0F, -1.0F, 27.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.5104F, 2.1078F, -12.4309F, 0.0F, 0.0F, -1.5708F));

        ModelPartData orb = wand.addChild("orb", ModelPartBuilder.create(), ModelTransform.pivot(0.0104F, -14.1242F, -15.2969F));

        ModelPartData cube_r10 = orb.addChild("cube_r10", ModelPartBuilder.create().uv(62, 34).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5982F, -0.0525F, -0.5169F));

        ModelPartData left2 = hands.addChild("left2", ModelPartBuilder.create().uv(34, 6).cuboid(-0.5F, -2.0F, -3.5F, 5.0F, 18.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(8.5F, -33.5577F, 0.5528F));

        ModelPartData head = enchanter.addChild("head", ModelPartBuilder.create().uv(30, 32).cuboid(-5.25F, -14.5F, -0.75F, 10.0F, 14.0F, 6.0F, new Dilation(0.0F))
                .uv(74, 12).cuboid(-1.75F, -8.5F, -3.75F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.25F, -35.5F, -2.25F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(EnchanterRenderState state) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngle(state.yawDegrees,state.yawDegrees);

        this.animateWalking(EnchanterAnimations.walk,state.limbFrequency,state.limbAmplitudeMultiplier,4f,2.5f);
        this.animate(state.idleAnimationState,EnchanterAnimations.idle, state.age,1f);
        this.animate(state.attackAnimationState,EnchanterAnimations.attack,state.age,1f);

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
