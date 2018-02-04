package com.raphydaphy.arcanemagic.common.block;

import java.util.ArrayList;
import java.util.List;

import com.raphydaphy.arcanemagic.common.ArcaneMagic;
import com.raphydaphy.arcanemagic.common.tileentity.TileEntityAnimusMaterializer;
import com.raphydaphy.arcanemagic.common.util.IHasRecipe;
import com.raphydaphy.arcanemagic.common.util.RecipeHelper;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockAnimusMaterializer extends BlockBase implements IHasRecipe {
	public static final int GUI_ID = 2;
	protected static final List<AxisAlignedBB> BOUNDS = new ArrayList<>();

	static {
		BOUNDS.add(makeAABB(2, 0, 2, 4, 2, 4));
		BOUNDS.add(makeAABB(12, 0, 12, 14, 2, 14));
		BOUNDS.add(makeAABB(2, 0, 12, 4, 2, 14));
		BOUNDS.add(makeAABB(12, 0, 2, 14, 2, 4));
		BOUNDS.add(makeAABB(2, 6, 2, 14, 8, 14));
		BOUNDS.add(makeAABB(4, 8, 4, 12, 10, 12));
	}

	public BlockAnimusMaterializer() {
		super("animus_materializer", Material.ROCK, 2.5f, SoundType.STONE);

		this.setRenderedAABB(makeAABB(2, 0, 2, 14, 10, 14));
		this.setCollisionAABBList(BOUNDS);
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityAnimusMaterializer te = (TileEntityAnimusMaterializer) world.getTileEntity(pos);
		IItemHandler cap = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		for (int i = 0; i < cap.getSlots(); ++i) {
			ItemStack itemstack = cap.getStackInSlot(i);

			if (!itemstack.isEmpty()) {
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), itemstack);
			}
		}

		super.breakBlock(world, pos, state);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityAnimusMaterializer();
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (world.isRemote) {
			return true;
		}
		TileEntity te = world.getTileEntity(pos);
		if (!(te instanceof TileEntityAnimusMaterializer)) {
			return false;
		}
		player.openGui(ArcaneMagic.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return face == EnumFacing.DOWN ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
	}

	@Override
	public void initRecipes(Register<IRecipe> e) {
		RecipeHelper.addElementalShaped(this, null, 0, null, Items.BLAZE_ROD, null, Items.BLAZE_ROD,
				Items.PRISMARINE_CRYSTALS, Items.BLAZE_ROD, Blocks.IRON_BLOCK, Blocks.IRON_BLOCK, Blocks.IRON_BLOCK);
	}
}
