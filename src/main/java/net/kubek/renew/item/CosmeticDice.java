package net.kubek.renew.item;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class CosmeticDice extends Item {
    public CosmeticDice(Settings settings) {
        super(settings);
    }
    Random random = new Random();
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient) {
            ItemEntity item = null;
            int chance = (int) (random.nextInt(100) + 1);
            user.getStackInHand(hand).decrement(1);
            if (chance <= 24)
                item = new ItemEntity(world, user.getX(), user.getY() + 1, user.getZ(), new ItemStack(ModItems.TEDDY_BEAR_PLUSHIE));
            else if (chance <= 48)
                item = new ItemEntity(world, user.getX(), user.getY() + 1, user.getZ(), new ItemStack(ModItems.MONKEY_PLUSHIE));
            else if (chance <= 72)
                item = new ItemEntity(world, user.getX(), user.getY() + 1, user.getZ(), new ItemStack(ModItems.KOALA_PLUSHIE));
            else if (chance <= 96)
                item = new ItemEntity(world, user.getX(), user.getY() + 1, user.getZ(), new ItemStack(ModItems.RED_PANDA_PLUSHIE));
            else
                item = new ItemEntity(world, user.getX(), user.getY() + 1, user.getZ(), new ItemStack(ModItems.SUMMEYY_PLUSHIE));
            item.setPickupDelay(0);
            world.spawnEntity(item);


        }




        world.playSound(user,user.getBlockPos(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS,1,1);
        return TypedActionResult.success(user.getStackInHand(hand),true);
    }
}
