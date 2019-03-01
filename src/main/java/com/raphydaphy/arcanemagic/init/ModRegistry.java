package com.raphydaphy.arcanemagic.init;

import com.raphydaphy.arcanemagic.ArcaneMagic;
import com.raphydaphy.arcanemagic.block.*;
import com.raphydaphy.arcanemagic.block.base.FluidBlockBase;
import com.raphydaphy.arcanemagic.block.entity.*;
import com.raphydaphy.arcanemagic.fluid.LiquifiedSoulFluid;
import com.raphydaphy.arcanemagic.item.*;
import com.raphydaphy.arcanemagic.recipe.TransfigurationRecipe;
import com.raphydaphy.arcanemagic.util.ArcaneMagicUtils;
import com.raphydaphy.arcanemagic.util.ModDamageSource;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

@SuppressWarnings("WeakerAccess")
public class ModRegistry
{
	public static final LiquifiedSoulFluid FLOWING_LIQUIFIED_SOUL = new LiquifiedSoulFluid.Flowing();
	public static final LiquifiedSoulFluid LIQUIFIED_SOUL = new LiquifiedSoulFluid.Still();
	public static final FluidBlockBase LIQUIFIED_SOUL_BLOCK = new FluidBlockBase(LIQUIFIED_SOUL, FabricBlockSettings.of(Material.WATER).noCollision().strength(100.0F, 100.0F).dropsNothing());
	public static final List<TransfigurationRecipe> TRANSFIGURATION_RECIPES = new ArrayList<>();
	public static final ModDamageSource DRAINED_DAMAGE = new ModDamageSource(ArcaneMagic.DOMAIN + ".drained").setUnblockable().setUsesMagic().setBypassesArmor();

	public static BlockEntityType<AltarBlockEntity> ALTAR_TE = Registry.register(Registry.BLOCK_ENTITY, ArcaneMagic.PREFIX + "altar", BlockEntityType.Builder.create(AltarBlockEntity::new).build(null));
	public static BlockEntityType<AnalyzerBlockEntity> ANALYZER_TE = Registry.register(Registry.BLOCK_ENTITY, ArcaneMagic.PREFIX + "analyzer", BlockEntityType.Builder.create(AnalyzerBlockEntity::new).build(null));
	public static BlockEntityType<CrystalInfuserBlockEntity> CRYSTAL_INFUSER_TE = Registry.register(Registry.BLOCK_ENTITY, ArcaneMagic.PREFIX + "crystal_infuser", BlockEntityType.Builder.create(CrystalInfuserBlockEntity::new).build(null));
	public static BlockEntityType<MixerBlockEntity> MIXER_TE = Registry.register(Registry.BLOCK_ENTITY, ArcaneMagic.PREFIX + "mixer", BlockEntityType.Builder.create(MixerBlockEntity::new).build(null));
	public static BlockEntityType<PipeBlockEntity> PIPE_TE = Registry.register(Registry.BLOCK_ENTITY, ArcaneMagic.PREFIX + "pipe", BlockEntityType.Builder.create(PipeBlockEntity::new).build(null));
	public static BlockEntityType<PumpBlockEntity> PUMP_TE = Registry.register(Registry.BLOCK_ENTITY, ArcaneMagic.PREFIX + "pump", BlockEntityType.Builder.create(PumpBlockEntity::new).build(null));
	public static BlockEntityType<SmelterBlockEntity> SMELTER_TE = Registry.register(Registry.BLOCK_ENTITY, ArcaneMagic.PREFIX + "smelter", BlockEntityType.Builder.create(SmelterBlockEntity::new).build(null));
	public static BlockEntityType<TransfigurationTableBlockEntity> TRANSFIGURATION_TABLE_TE = Registry.register(Registry.BLOCK_ENTITY, ArcaneMagic.PREFIX + "transfiguration_table", BlockEntityType.Builder.create(TransfigurationTableBlockEntity::new).build(null));

	public static AltarBlock ALTAR = new AltarBlock();
	public static AnalyzerBlock ANALYZER = new AnalyzerBlock();
	public static CrystalInfuserBlock CRYSTAL_INFUSER = new CrystalInfuserBlock();
	public static MixerBlock MIXER = new MixerBlock();
	public static PipeBlock PIPE = new PipeBlock();
	public static PumpBlock PUMP = new PumpBlock();
	public static SmelterBlock SMELTER = new SmelterBlock();
	public static TransfigurationTableBlock TRANSFIGURATION_TABLE = new TransfigurationTableBlock();

	public static ScepterItem GOLDEN_SCEPTER = new ScepterItem(20);
	public static ScepterItem PURE_SCEPTER = new ScepterItem(50);
	public static ParchmentItem PARCHMENT = new ParchmentItem(ParchmentItem.ParchmentType.BLANK);
	public static ParchmentItem WRITTEN_PARCHMENT = new ParchmentItem(ParchmentItem.ParchmentType.WRITTEN);
	public static ParchmentItem ANCIENT_PARCHMENT = new ParchmentItem(ParchmentItem.ParchmentType.ANCIENT);
	public static NotebookItem NOTEBOOK = new NotebookItem();
	public static SoulStorageItem SOUL_PENDANT = new SoulStorageItem(new Item.Settings().itemGroup(ArcaneMagic.GROUP).stackSize(1));
	public static CrystalItem EMERALD_CRYSTAL = new CrystalItem(ArcaneMagicUtils.ForgeCrystal.EMERALD);
	public static CrystalItem DIAMOND_CRYSTAL = new CrystalItem(ArcaneMagicUtils.ForgeCrystal.DIAMOND);
	public static CrystalItem GOLD_CRYSTAL = new CrystalItem(ArcaneMagicUtils.ForgeCrystal.GOLD);
	public static CrystalItem LAPIS_CRYSTAL = new CrystalItem(ArcaneMagicUtils.ForgeCrystal.LAPIS);
	public static CrystalItem REDSTONE_CRYSTAL = new CrystalItem(ArcaneMagicUtils.ForgeCrystal.REDSTONE);
	public static CrystalItem COAL_CRYSTAL = new CrystalItem(ArcaneMagicUtils.ForgeCrystal.COAL);
	public static Item PURE_CRYSTAL = new Item(new Item.Settings().itemGroup(ArcaneMagic.GROUP));
	public static CrystalArmorItem EMERALD_CRYSTAL_HELMET = new CrystalArmorItem(CrystalArmorItem.ModArmorMaterials.EMERALD_CRYSTAL, EquipmentSlot.HEAD);
	public static CrystalArmorItem EMERALD_CRYSTAL_CHESTPLATE = new CrystalArmorItem(CrystalArmorItem.ModArmorMaterials.EMERALD_CRYSTAL, EquipmentSlot.CHEST);
	public static CrystalArmorItem EMERALD_CRYSTAL_LEGGINGS = new CrystalArmorItem(CrystalArmorItem.ModArmorMaterials.EMERALD_CRYSTAL, EquipmentSlot.LEGS);
	public static CrystalArmorItem EMERALD_CRYSTAL_BOOTS = new CrystalArmorItem(CrystalArmorItem.ModArmorMaterials.EMERALD_CRYSTAL, EquipmentSlot.FEET);
	public static DaggerItem IRON_DAGGER = new DaggerItem(ToolMaterials.IRON, 3, -2.4f);
	public static BucketItem LIQUIFIED_SOUL_BUCKET = new BucketItem(LIQUIFIED_SOUL, (new Item.Settings()).recipeRemainder(Items.BUCKET).stackSize(1).itemGroup(ArcaneMagic.GROUP));

	public static void init()
	{
		// Block Registration
		Registry.register(Registry.BLOCK, new Identifier(ArcaneMagic.DOMAIN, "altar"), ALTAR);
		Registry.register(Registry.BLOCK, new Identifier(ArcaneMagic.DOMAIN, "analyzer"), ANALYZER);
		Registry.register(Registry.BLOCK, new Identifier(ArcaneMagic.DOMAIN, "crystal_infuser"), CRYSTAL_INFUSER);
		Registry.register(Registry.BLOCK, new Identifier(ArcaneMagic.DOMAIN, "mixer"), MIXER);
		Registry.register(Registry.BLOCK, new Identifier(ArcaneMagic.DOMAIN, "pipe"), PIPE);
		Registry.register(Registry.BLOCK, new Identifier(ArcaneMagic.DOMAIN, "pump"), PUMP);
		Registry.register(Registry.BLOCK, new Identifier(ArcaneMagic.DOMAIN, "smelter"), SMELTER);
		Registry.register(Registry.BLOCK, new Identifier(ArcaneMagic.DOMAIN, "transfiguration_table"), TRANSFIGURATION_TABLE);

		// Item Block Registration
		Registry.register(Registry.ITEM, ArcaneMagic.PREFIX + "altar", new BlockItem(ALTAR, new Item.Settings().itemGroup(ArcaneMagic.GROUP)));
		Registry.register(Registry.ITEM, ArcaneMagic.PREFIX + "analyzer", new BlockItem(ANALYZER, new Item.Settings().itemGroup(ArcaneMagic.GROUP)));
		Registry.register(Registry.ITEM, ArcaneMagic.PREFIX + "crystal_infuser", new BlockItem(CRYSTAL_INFUSER, new Item.Settings().itemGroup(ArcaneMagic.GROUP)));
		Registry.register(Registry.ITEM, ArcaneMagic.PREFIX + "mixer", new BlockItem(MIXER, new Item.Settings().itemGroup(ArcaneMagic.GROUP)));
		Registry.register(Registry.ITEM, ArcaneMagic.PREFIX + "pipe", new BlockItem(PIPE, new Item.Settings().itemGroup(ArcaneMagic.GROUP)));
		Registry.register(Registry.ITEM, ArcaneMagic.PREFIX + "pump", new BlockItem(PUMP, new Item.Settings().itemGroup(ArcaneMagic.GROUP)));
		Registry.register(Registry.ITEM, ArcaneMagic.PREFIX + "smelter", new BlockItem(SMELTER, new Item.Settings().itemGroup(ArcaneMagic.GROUP)));
		Registry.register(Registry.ITEM, ArcaneMagic.PREFIX + "transfiguration_table", new BlockItem(TRANSFIGURATION_TABLE, new Item.Settings().itemGroup(ArcaneMagic.GROUP)));

		// Fluid Registration
		Registry.register(Registry.FLUID, "liquified_soul", LIQUIFIED_SOUL);
		Registry.register(Registry.FLUID, "flowing_liquified_soul", FLOWING_LIQUIFIED_SOUL);

		// Fluid Block Registration
		Registry.register(Registry.BLOCK, new Identifier(ArcaneMagic.DOMAIN, "liquified_soul"), LIQUIFIED_SOUL_BLOCK);

		// Item Registration
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "golden_scepter"), GOLDEN_SCEPTER);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "pure_scepter"), PURE_SCEPTER);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "parchment"), PARCHMENT);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "written_parchment"), WRITTEN_PARCHMENT);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "ancient_parchment"), ANCIENT_PARCHMENT);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "notebook"), NOTEBOOK);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "soul_pendant"), SOUL_PENDANT);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "emerald_crystal"), EMERALD_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "diamond_crystal"), DIAMOND_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "gold_crystal"), GOLD_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "lapis_crystal"), LAPIS_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "redstone_crystal"), REDSTONE_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "coal_crystal"), COAL_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "pure_crystal"), PURE_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "emerald_crystal_helmet"), EMERALD_CRYSTAL_HELMET);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "emerald_crystal_chestplate"), EMERALD_CRYSTAL_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "emerald_crystal_leggings"), EMERALD_CRYSTAL_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "emerald_crystal_boots"), EMERALD_CRYSTAL_BOOTS);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "iron_dagger"), IRON_DAGGER);
		Registry.register(Registry.ITEM, new Identifier(ArcaneMagic.DOMAIN, "liquified_soul_bucket"), LIQUIFIED_SOUL_BUCKET);
	}
}
