package com.raphydaphy.arcanemagic.block;

import com.raphydaphy.arcanemagic.tileentity.TileEntityAltar;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ShapeUtils;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockAltar extends BlockWaterloggableBase implements ITileEntityProvider
{
    private static final VoxelShape shape;

    public BlockAltar()
    {
        super(Block.Builder.create(Material.ROCK).hardnessAndResistance(5.0F, 1200.0F).soundType(SoundType.STONE));
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Nullable
    @Override
    public TileEntity getTileEntity(IBlockReader iBlockReader)
    {
        return new TileEntityAltar();
    }

    @Override
    public boolean onRightClick(IBlockState blockstate, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing facing, float x, float y, float z)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            TileEntity te = world.getTileEntity(pos);
            if (te instanceof TileEntityAltar)
            {
                TileEntityAltar altar = (TileEntityAltar)te;
                ItemStack held = player.getHeldItem(hand);
                if (!held.isEmpty() && altar.isItemValidForSlot(0, held))
                {
                    ItemStack add = held.copy();
                    add.setCount(1);
                    altar.setInventorySlotContents(0, add);
                    held.shrink(1);
                    altar.sync();
                    player.openContainer.detectAndSendChanges();
                }
            }
            return true;
        }
    }

    @Override
    public VoxelShape getShape(IBlockState p_getShape_1_, IBlockReader p_getShape_2_, BlockPos p_getShape_3_)
    {
        return shape;
    }

    @Override
    public void beforeReplacingBlock(final IBlockState state, final World world, final BlockPos pos, final IBlockState newState, final boolean p_196243_5_)
    {
        if (state.getBlock() != newState.getBlock())
        {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof IInventory)
            {
                InventoryHelper.dropInventoryItems(world, pos, (IInventory) tileEntity);
            }
            world.removeTileEntity(pos);
        }
        super.beforeReplacingBlock(state, world, pos, newState, p_196243_5_);
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockReader reader, IBlockState blockState, BlockPos pos, EnumFacing facing)
    {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean isFullCube(IBlockState p_isFullCube_1_)
    {
        return false;
    }

    static
    {
        VoxelShape bottom = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D);
        VoxelShape middle = Block.makeCuboidShape(4.0D, 4.0D, 4.0D, 12.0D, 6.0D, 12.0D);
        VoxelShape top = Block.makeCuboidShape(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D);
        shape = ShapeUtils.func_197872_a(ShapeUtils.func_197872_a(bottom, middle), top);
    }
}
