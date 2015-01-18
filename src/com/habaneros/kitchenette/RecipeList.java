package com.habaneros.kitchenette;

import java.util.ArrayList;

class RecipeList {
	
	private static ArrayList<Recipe> recipes;
	
	public static int getListSize() {
		return recipes.size();
	}
	
	public static boolean isEmpty() {
		return recipes.size()==0;
	}
	
	public static void addRecipe(Recipe r) {
		recipes.add(r);
	}
	
	public static boolean removeRecipe(Recipe r) {
		return recipes.remove(r);
	}
	
	public static Recipe get(int index) {
		return recipes.get(index);
	}

}
