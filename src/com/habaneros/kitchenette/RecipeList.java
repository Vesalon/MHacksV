package com.habaneros.kitchenette;
import com.microsoft.windowsazure.mobileservices.*;

import java.util.ArrayList;

class RecipeList {
    
    private static ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    
    public static void populate() {
        Recipe pC = new Recipe("The Habaneros", "Praline Cheesecake");
        pC.addStep("Obtain ingredients");
        pC.addTimedStep("Blend ingredients", 0, 5, 0);
        pC.addTimedStep("Bake mix", 0, 30, 0);
        pC.addTimedStep("Chill cheesecake in the fridge", 9, 0, 0);
        pC.addStep("Serve chilled");
        recipes.add(pC);
        
        Recipe vL = new Recipe("The Habaneros", "Vegetarian Lasagna");
        vL.addStep("Obtain 500 grams of Lasagna Sheets");
        vL.addTimedStep("Boil sheets in water", 0, 20, 0);
        vL.addStep("Obtain carrots, eggplant, and zucchini");
        vL.addStep("Heat Alfredo Sauce and add the vegetables");
        vL.addStep("Pile the lasagna sheets in layers, filling with the sauce between the layers");
        vL.addStep("Serve hot");
        recipes.add(vL);
        
        Recipe cB = new Recipe("The Habaneros", "Chicken Biryani");
        cB.addStep("Obtain 3 cups cooked rice, 3 to 4 cinammon sticks, a pinch of cardamom seeds, chicken, and a marinade");
        cB.addStep("Marinade the chicken and grill until brown");
        cB.addStep("Combine the grilled chicken, rice, and spices in a pot, and cover with foil");
        cB.addTimedStep("Bake pot in oven", 0, 40, 0);
        cB.addStep("Remove from oven and serve hot");
        recipes.add(cB);
        
        Recipe bT = new Recipe("The Habaneros", "Beef Tacos");
        cB.addStep("Obtain 8 to 12 corn tortillas, 12 to 16 ounces of ground sirloin, shredded lettuce, tomatoes, and taco seasoning");
        cB.addStep("Combine the filling ingredients along with the taco seasoning until evenly mixed");
        cB.addStep("Fill the corn tortillas with the filling, topping off with shredded cheddar cheese");
        cB.addStep("Serve warm");
        recipes.add(bT);
        
        Recipe mP = new Recipe("The Habaneros", "Margherita Pizza");
        mP.addStep("Obtain pizza dough, olive oil, marinara sauce, and mozzarella cheese");
        mP.addStep("Stretch the pizza dough, oiling it, kneading it, and tossing it until it is wide and flat");
        mP.addStep("Spread dough flat on an oven pan and add marinara sauce onto the dough");
        mP.addStep("Spread shredded mozzarella over the entire pizza and fold some into the edges for a cheesy crust");
        mP.addTimedStep("Place pizza in oven and bake to perfection", 0, 25, 0);
        mP.addStep("Serve hot");
        recipes.add(mP);
    }
    
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
    
    public static ArrayList<Recipe> getList() {
        return recipes;
    }

}