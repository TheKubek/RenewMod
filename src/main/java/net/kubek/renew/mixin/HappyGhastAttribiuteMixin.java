package net.kubek.renew.mixin;


import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.HappyGhastEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(HappyGhastEntity.class)
public class HappyGhastAttribiuteMixin {

    @Overwrite
    public static DefaultAttributeContainer.Builder createHappyGhastAttributes() {
        return AnimalEntity.createAnimalAttributes().add(EntityAttributes.MAX_HEALTH, (double)20.0F)
                .add(EntityAttributes.TEMPT_RANGE, (double)16.0F)
                .add(EntityAttributes.FLYING_SPEED, 0.08)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.08)
                .add(EntityAttributes.FOLLOW_RANGE, (double)32.0F)
                .add(EntityAttributes.CAMERA_DISTANCE, (double)12.0F);
    }



}
