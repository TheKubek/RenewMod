package net.kubek.renew.entity.client;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

public class CorruptedEnchanterRenderState extends LivingEntityRenderState{
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
}
