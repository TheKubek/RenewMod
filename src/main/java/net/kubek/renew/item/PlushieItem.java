package net.kubek.renew.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class PlushieItem extends Item {
    public PlushieItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_BAT_AMBIENT, SoundCategory.PLAYERS, 10f, 1f);


        return ActionResult.SUCCESS;
    }
}
