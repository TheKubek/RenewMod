package net.kubek.renew.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScytheItem extends HoeItem {
    public ScytheItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        Block block = world.getBlockState(blockPos).getBlock();
        BlockState blockState = world.getBlockState(blockPos);
        PlayerEntity player = context.getPlayer();

            if (block instanceof CropBlock cropBlock) {
                if (cropBlock.isMature(blockState)) {
                    if(!world.isClient) {
                        context.getStack().damage(1,((ServerWorld) world),((ServerPlayerEntity) context.getPlayer()),
                                item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND)
                        );
                        world.breakBlock(blockPos, true, player);
                        world.setBlockState(blockPos, block.getDefaultState());

                    }
                }
                return ActionResult.SUCCESS;

            }
            else return super.useOnBlock(context);



    }
}
