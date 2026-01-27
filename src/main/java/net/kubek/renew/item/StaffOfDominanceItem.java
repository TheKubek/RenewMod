package net.kubek.renew.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class StaffOfDominanceItem extends Item {
    public StaffOfDominanceItem(Settings settings) {
        super(settings);
    }
    private static final Map<Block,Block> TRANSFORMABLE_BLOCKS = Map.of
            (
            Blocks.BARRIER,Blocks.BEDROCK,
            Blocks.BEDROCK,Blocks.BARRIER,
            Blocks.OAK_LOG,Blocks.POLISHED_BASALT,
            Blocks.BIRCH_LOG,Blocks.POLISHED_BASALT,
            Blocks.GRASS_BLOCK,Blocks.PODZOL,
            Blocks.PODZOL,Blocks.MYCELIUM,
            Blocks.MYCELIUM,Blocks.GRASS_BLOCK,
            Blocks.DIRT,Blocks.ROOTED_DIRT,
            Blocks.ROOTED_DIRT,Blocks.COARSE_DIRT,
            Blocks.COARSE_DIRT,Blocks.DIRT
            );
private static final Map<Block,Block> TRANSFORMABLE_BLOCKS_TWO = Map.of
            (
            Blocks.STONE,Blocks.STONE_BRICKS,
            Blocks.STONE_BRICKS,Blocks.STONE,
            Blocks.DEEPSLATE,Blocks.DEEPSLATE_BRICKS,
            Blocks.DEEPSLATE_BRICKS,Blocks.DEEPSLATE,
            Blocks.TUFF,Blocks.TUFF_BRICKS,
            Blocks.TUFF_BRICKS,Blocks.TUFF,
            Blocks.BLUE_ICE,Blocks.LAVA,
            Blocks.ACACIA_LOG,Blocks.POLISHED_BASALT,
            Blocks.SPRUCE_LOG,Blocks.POLISHED_BASALT,
            Blocks.DARK_OAK_LOG,Blocks.POLISHED_BASALT
            );
private static final Map<Block,Block> TRANSFORMABLE_BLOCKS_THREE = Map.of
        (
            Blocks.BIRCH_LOG,Blocks.POLISHED_BASALT,
            Blocks.JUNGLE_LOG,Blocks.POLISHED_BASALT,
            Blocks.CHERRY_LOG,Blocks.POLISHED_BASALT,
            Blocks.MANGROVE_LOG,Blocks.POLISHED_BASALT,
            Blocks.SAND,Blocks.RED_SAND,
            Blocks.RED_SAND,Blocks.SAND,
            Blocks.RAW_IRON_BLOCK,Blocks.IRON_BLOCK,
            Blocks.RAW_COPPER_BLOCK,Blocks.COPPER_BLOCK,
            Blocks.RAW_GOLD_BLOCK,Blocks.GOLD_BLOCK
            );


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockState blockState = context.getWorld().getBlockState(context.getBlockPos());
        World world = context.getWorld();
        if(!world.isClient){
            if(TRANSFORMABLE_BLOCKS.containsKey(blockState.getBlock())){
                world.setBlockState(context.getBlockPos(),TRANSFORMABLE_BLOCKS.get(blockState.getBlock()).getDefaultState());

            }
            else if(TRANSFORMABLE_BLOCKS_TWO.containsKey(blockState.getBlock())){
                world.setBlockState(context.getBlockPos(),TRANSFORMABLE_BLOCKS_TWO.get(blockState.getBlock()).getDefaultState());

            }
            else if(TRANSFORMABLE_BLOCKS_THREE.containsKey(blockState.getBlock())){
                world.setBlockState(context.getBlockPos(),TRANSFORMABLE_BLOCKS_THREE.get(blockState.getBlock()).getDefaultState());

            }
            else world.breakBlock(context.getBlockPos(),true);

        }
        return ActionResult.SUCCESS;
    }


    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();
        if(entity instanceof ZombieEntity)
        {
            SkeletonEntity skeletonEntity = new SkeletonEntity(EntityType.SKELETON,world);
            skeletonEntity.setPosition(entity.getPos());
            skeletonEntity.equipStack(EquipmentSlot.MAINHAND, entity.getMainHandStack());
            world.spawnEntity(skeletonEntity);
        }
        else if(entity instanceof BatEntity)
        {
            BeeEntity beeEntity = new BeeEntity(EntityType.BEE,world);
            beeEntity.setPosition(entity.getPos());
            world.spawnEntity(beeEntity);
        }
        else if(entity instanceof WitherEntity){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS,2000, 1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,5, 3));
        }
        entity.setInvisible(true);
        entity.kill();
        entity.deathTime = 20;
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown())tooltip.add(Text.translatable("tooltip.renew.staff_of_dominance"));
        else {
            tooltip.add(Text.translatable("tooltip.renew.staff_of_dominance_shift_line_one"));
            tooltip.add(Text.translatable("tooltip.renew.staff_of_dominance_shift_line_two"));
            tooltip.add(Text.translatable("tooltip.renew.staff_of_dominance_shift_line_three"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }


}
