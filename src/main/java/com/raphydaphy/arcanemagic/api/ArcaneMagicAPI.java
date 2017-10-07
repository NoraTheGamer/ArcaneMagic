package com.raphydaphy.arcanemagic.api;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.raphydaphy.arcanemagic.ArcaneMagic;
import com.raphydaphy.arcanemagic.api.essence.Essence;
import com.raphydaphy.arcanemagic.api.notebook.NotebookCategory;
import com.raphydaphy.arcanemagic.api.recipe.ElementalCraftingRecipe;

import net.minecraft.item.ItemStack;

public class ArcaneMagicAPI
{
	public static final String VERSION = "0.1";

	private static ImmutableList<NotebookCategory> sorted_categories;
	public static List<ElementalCraftingRecipe> elemental_crafting_recipes = new ArrayList<ElementalCraftingRecipe>();
	
	public static void registerCategory(NotebookCategory category)
	{
		NotebookCategory.REGISTRY.register(category);
	}

	public static void registerEssence(Essence e)
	{
		Essence.REGISTRY.register(e);
	}

	public static void registerAllCategories(NotebookCategory... category)
	{
		NotebookCategory.REGISTRY.registerAll(category);
	}

	public static void registerAllEssences(Essence... e)
	{
		Essence.REGISTRY.registerAll(e);
	}

	public static int getCategoryCount()
	{
		if (sorted_categories == null)
			throw new UnsupportedOperationException("Categories not yet sorted!");
		return sorted_categories.size();
	}

	public static ImmutableList<NotebookCategory> getNotebookCategories()
	{
		if (sorted_categories == null)
			throw new UnsupportedOperationException("Categories not yet sorted!");
		return sorted_categories;
	}

	public static void setCategoryList(ImmutableList<NotebookCategory> list)
	{
		if (sorted_categories == null)
			sorted_categories = list;
		else
			throw new UnsupportedOperationException("Pls stop");
		ArcaneMagic.LOGGER
				.info("Setting sorted category list - being called from " + Thread.currentThread().getStackTrace()[1]);
	}
	
	public static void registerElementalCraftingRecipe(ElementalCraftingRecipe recipe)
	{
		elemental_crafting_recipes.add(recipe);
	}
	
	public static ElementalCraftingRecipe getElementalCraftingRecipe(ItemStack[][] recipeIn)
	{
		for (ElementalCraftingRecipe curRecipe : elemental_crafting_recipes)
		{
			if (curRecipe.inputMatches(recipeIn))
			{
				return curRecipe;
			}
		}
		return null;
	}
}
