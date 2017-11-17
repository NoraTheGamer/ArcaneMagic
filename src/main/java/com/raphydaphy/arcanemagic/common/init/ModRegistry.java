package com.raphydaphy.arcanemagic.common.init;

import java.util.ArrayList;
import java.util.List;

import com.raphydaphy.arcanemagic.common.ArcaneMagic;
import com.raphydaphy.arcanemagic.common.block.BlockAnalyzer;
import com.raphydaphy.arcanemagic.common.block.BlockCrystallizer;
import com.raphydaphy.arcanemagic.common.block.BlockElementalCraftingTable;
import com.raphydaphy.arcanemagic.common.block.BlockEssenceConcentrator;
import com.raphydaphy.arcanemagic.common.block.BlockFancyLight;
import com.raphydaphy.arcanemagic.common.block.BlockInfusionAltar;
import com.raphydaphy.arcanemagic.common.block.BlockWritingDesk;
import com.raphydaphy.arcanemagic.common.data.EnumBasicEssence;
import com.raphydaphy.arcanemagic.common.handler.ArcaneMagicSoundHandler;
import com.raphydaphy.arcanemagic.common.item.ItemBase;
import com.raphydaphy.arcanemagic.common.item.ItemCore;
import com.raphydaphy.arcanemagic.common.item.ItemEnum;
import com.raphydaphy.arcanemagic.common.item.ItemEssenceChannelingRod;
import com.raphydaphy.arcanemagic.common.item.ItemIlluminator;
import com.raphydaphy.arcanemagic.common.item.ItemNotebook;
import com.raphydaphy.arcanemagic.common.item.ItemParchment;
import com.raphydaphy.arcanemagic.common.item.ItemScepter;
import com.raphydaphy.arcanemagic.common.item.ItemTip;
import com.raphydaphy.arcanemagic.common.tileentity.TileEntityAnalyzer;
import com.raphydaphy.arcanemagic.common.tileentity.TileEntityCrystallizer;
import com.raphydaphy.arcanemagic.common.tileentity.TileEntityElementalCraftingTable;
import com.raphydaphy.arcanemagic.common.tileentity.TileEntityEssenceConcentrator;
import com.raphydaphy.arcanemagic.common.tileentity.TileEntityInfusionAltar;
import com.raphydaphy.arcanemagic.common.tileentity.TileEntityWritingDesk;
import com.raphydaphy.arcanemagic.common.util.IHasRecipe;
import com.raphydaphy.arcanemagic.common.util.RecipeHelper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModRegistry
{
	public static final List<Block> BLOCKS = new ArrayList<>();
	public static final List<Item> ITEMS = new ArrayList<>();
	public static final List<IRecipe> RECIPES = new ArrayList<>();

	public static final BlockWritingDesk WRITING_DESK = new BlockWritingDesk();
	public static final BlockAnalyzer ANALYZER = new BlockAnalyzer();
	public static final BlockInfusionAltar INFUSION_ALTAR = new BlockInfusionAltar();
	public static final BlockElementalCraftingTable ELEMENTAL_CRAFTING_TABLE = new BlockElementalCraftingTable();
	public static final BlockCrystallizer CRYSTALLIZER = new BlockCrystallizer();
	public static final BlockEssenceConcentrator ESSENCE_CONCENTRATOR = new BlockEssenceConcentrator();
	public static final BlockFancyLight FANCY_LIGHT = new BlockFancyLight();

	public static final ItemBase TIP = new ItemTip();
	public static final ItemBase CORE = new ItemCore();
	public static final ItemScepter SCEPTER = new ItemScepter("scepter");
	public static final ItemNotebook NOTEBOOK = new ItemNotebook("notebook");
	public static final ItemEnum<EnumBasicEssence> ESSENCE = new ItemEnum<>("essence", EnumBasicEssence.values(),
			TextFormatting.DARK_AQUA);
	public static final ItemBase CREATION = new ItemBase("essence_creation", TextFormatting.GOLD);
	public static final ItemBase BLANK_PARCHMENt = (ItemBase) new ItemBase("blank_parchment").setMaxStackSize(1);
	public static final ItemParchment ANCIENT_PARCHMENT = new ItemParchment("ancient_parchment");
	public static final ItemParchment WRITTEN_PARCHMENT = new ItemParchment("written_parchment");
	public static final ItemIlluminator MYSTICAL_ILLUMINATOR = new ItemIlluminator();
	public static final ItemEssenceChannelingRod ESSENCE_CHANNELING_ROD = new ItemEssenceChannelingRod();

	@SubscribeEvent
	public void onBlockRegister(Register<Block> e)
	{
		e.getRegistry().registerAll(BLOCKS.toArray(new Block[BLOCKS.size()]));
	}

	@SubscribeEvent
	public void onItemRegister(Register<Item> e)
	{
		e.getRegistry().registerAll(ITEMS.toArray(new Item[ITEMS.size()]));
	}

	@SubscribeEvent
	public void onRecipeRegister(Register<IRecipe> e)
	{
		// TODO: shadows will probably make this better.. hopefully :-)
		OreDictionary.registerOre("formationEssence",
				new ItemStack(ModRegistry.ESSENCE, 1, OreDictionary.WILDCARD_VALUE));

		for (Item i : ModRegistry.ITEMS)
			if (i instanceof IHasRecipe)
				((IHasRecipe) i).initRecipes(e);
		for (Block b : ModRegistry.BLOCKS)
			if (b instanceof IHasRecipe)
				((IHasRecipe) b).initRecipes(e);

		RecipeHelper.addShaped(BLANK_PARCHMENt, 3, 3, null, "paper", null, "paper", "dye", "paper", null, "paper",
				null);

		// @Shadows: The day I work with JSON recipes is the day the world ends.
		// @raphy: uhoh
		e.getRegistry().registerAll(RECIPES.toArray(new IRecipe[RECIPES.size()]));
	}

	@SubscribeEvent
	public void registerSounds(Register<SoundEvent> event)
	{
		IForgeRegistry<SoundEvent> registry = event.getRegistry();
		ArcaneMagicSoundHandler.register("spell", registry);
		ArcaneMagicSoundHandler.register("scepter_1", registry);
		ArcaneMagicSoundHandler.register("scepter_2", registry);
		ArcaneMagicSoundHandler.register("scepter_3", registry);
		ArcaneMagicSoundHandler.register("page_1", registry);
		ArcaneMagicSoundHandler.register("page_2", registry);
		ArcaneMagicSoundHandler.register("elemental_crafting_success", registry);
		ArcaneMagicSoundHandler.register("write_1", registry);
		ArcaneMagicSoundHandler.register("write_2", registry);
		ArcaneMagicSoundHandler.register("learn_1", registry);
		ArcaneMagicSoundHandler.register("learn_2", registry);
		ArcaneMagicSoundHandler.register("reconstruct", registry);
		ArcaneMagicSoundHandler.register("clack", registry);
	}

	public static void registerTiles()
	{
		GameRegistry.registerTileEntity(TileEntityElementalCraftingTable.class,
				ArcaneMagic.MODID + "_elemental_crafting_table");
		GameRegistry.registerTileEntity(TileEntityCrystallizer.class, ArcaneMagic.MODID + "_crystallizer");
		GameRegistry.registerTileEntity(TileEntityEssenceConcentrator.class,
				ArcaneMagic.MODID + "_essence_concentrator");
		GameRegistry.registerTileEntity(TileEntityWritingDesk.class, ArcaneMagic.MODID + "_writing_desk");
		GameRegistry.registerTileEntity(TileEntityInfusionAltar.class, ArcaneMagic.MODID + "_infusion_altar");
		GameRegistry.registerTileEntity(TileEntityAnalyzer.class, ArcaneMagic.MODID + "_analyzer");
	}
}
