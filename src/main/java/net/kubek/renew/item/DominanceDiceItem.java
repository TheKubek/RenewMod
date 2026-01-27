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


public class DominanceDiceItem extends Item {
    public DominanceDiceItem(Settings settings) {
        super(settings);
    }
    Random random = new Random();
    private int chance;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        chance=(int)(random.nextInt(9)+1);
        user.getStackInHand(hand).decrement(1);
        ItemEntity item = null;
        if(!world.isClient){
            if(chance==1) item = new ItemEntity(world,user.getX(),user.getY()+1,user.getZ(),new ItemStack(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE));
            else if(chance==2) item = new ItemEntity(world,user.getX(),user.getY()+1,user.getZ(),new ItemStack(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_TWO));
            else if(chance==3) item = new ItemEntity(world,user.getX(),user.getY()+1,user.getZ(),new ItemStack(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_THREE));
            else if(chance==4) item = new ItemEntity(world,user.getX(),user.getY()+1,user.getZ(),new ItemStack(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FOUR));
            else if(chance==5) item = new ItemEntity(world,user.getX(),user.getY()+1,user.getZ(),new ItemStack(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FIVE));
            else if(chance==6) item = new ItemEntity(world,user.getX(),user.getY()+1,user.getZ(),new ItemStack(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SIX));
            else if(chance==7) item = new ItemEntity(world,user.getX(),user.getY()+1,user.getZ(),new ItemStack(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SEVEN));
            else if(chance==8) item = new ItemEntity(world,user.getX(),user.getY()+1,user.getZ(),new ItemStack(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_EIGHT));
            else if(chance==9) item = new ItemEntity(world,user.getX(),user.getY()+1,user.getZ(),new ItemStack(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_NINE));
            assert item != null;
            item.setPickupDelay(0);
            world.spawnEntity(item);

        }

        world.playSound(user,user.getBlockPos(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS,1,1);
        return TypedActionResult.success(user.getStackInHand(hand),true);
    }
}
