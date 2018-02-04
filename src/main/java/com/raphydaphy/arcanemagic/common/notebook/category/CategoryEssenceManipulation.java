package com.raphydaphy.arcanemagic.common.notebook.category;

import java.util.ArrayList;
import java.util.List;

import com.raphydaphy.arcanemagic.api.notebook.INotebookEntry;
import com.raphydaphy.arcanemagic.api.notebook.INotebookInfo;
import com.raphydaphy.arcanemagic.api.notebook.NotebookCategory;
import com.raphydaphy.arcanemagic.api.notebook.NotebookPage;
import com.raphydaphy.arcanemagic.common.init.ModRegistry;
import com.raphydaphy.arcanemagic.common.notebook.NotebookCategories;
import com.raphydaphy.arcanemagic.common.notebook.entry.NotebookEntryCraftingRecipe;
import com.raphydaphy.arcanemagic.common.notebook.entry.NotebookEntryText;

import akka.japi.Pair;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CategoryEssenceManipulation extends NotebookCategory {
	public CategoryEssenceManipulation() {
		setUnlocalizedName("arcanemagic.notebook.category.essence_manipulation");
		setUnlocParchmentInfo(new Pair<String, Integer>("arcanemagic.message.parchment.glowstone", 2));
		setRequiredTag("unlockedEssenceManipulation");
		setPrerequisiteTag(NotebookCategories.FOUNDATIONS_OF_MAGIC.getRequiredTag());
		setIcon(new ItemStack(ModRegistry.ESSENCE_CHANNELING_ROD));
	}

	@Override
	public List<NotebookPage> getPages(INotebookInfo info) {
		List<NotebookPage> pages = new ArrayList<NotebookPage>();
		List<INotebookEntry> page0 = new ArrayList<INotebookEntry>();
		for (int i = 0; i < 2; i++) {
			page0.add(new NotebookEntryText(getUnlocalizedName() + "." + i, 0x000000));
		}

		pages.add(new NotebookPage(page0));
		List<INotebookEntry> page1 = new ArrayList<INotebookEntry>();
		ItemStack[][] elementalCraftingTableRecipe = {
				{ ItemStack.EMPTY, new ItemStack(Items.GLOWSTONE_DUST), ItemStack.EMPTY },
				{ new ItemStack(Blocks.PLANKS), new ItemStack(Blocks.CRAFTING_TABLE), new ItemStack(Blocks.PLANKS) },
				{ new ItemStack(Blocks.PLANKS), ItemStack.EMPTY, new ItemStack(Blocks.PLANKS) } };
		page1.add(new NotebookEntryCraftingRecipe(elementalCraftingTableRecipe,
				new ItemStack(ModRegistry.ARCANE_TRANSFIGURATION_TABLE)));
		page1.add(new NotebookEntryText(getUnlocalizedName() + ".2", 0x000000));
		ItemStack[][] essenceChannelingRodRecipe = {
				{ ItemStack.EMPTY, new ItemStack(Items.GLOWSTONE_DUST), new ItemStack(Items.REDSTONE) },
				{ ItemStack.EMPTY, new ItemStack(Items.STICK), new ItemStack(Items.GLOWSTONE_DUST) },
				{ new ItemStack(Items.STICK), ItemStack.EMPTY, ItemStack.EMPTY } };
		page1.add(new NotebookEntryCraftingRecipe(essenceChannelingRodRecipe,
				new ItemStack(ModRegistry.ESSENCE_CHANNELING_ROD)));
		pages.add(new NotebookPage(page1));
		return pages;
	}
}
