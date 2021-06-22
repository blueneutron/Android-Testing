package com.example.androidtesting.data.local;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import com.example.androidtesting.data.model.Recipe;

import org.junit.Test;

public class RecipeStoreTest {


    @Test
    public void nullDirectory() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        RecipeStore recipeStore = new RecipeStore(context, null);
        assertNotNull(recipeStore);
        assertNotNull(recipeStore.recipes);
        assertEquals(0, recipeStore.recipes.size());
    }

    @Test
    public void count() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        RecipeStore recipeStore = new RecipeStore(context, "recipes");
        assertNotNull(recipeStore);
        assertNotNull(recipeStore.recipes);
        assertEquals(4, recipeStore.recipes.size());
    }

    @Test
    public void getChocolatePudding() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        RecipeStore recipeStore = new RecipeStore(context, "recipes");
        Recipe recipe = recipeStore.getRecipe("chocolate_pudding");
        assertNotNull(recipe);
        assertEquals("chocolate_pudding", recipe.getId());
        assertEquals("Chocolate Pudding", recipe.getTitle());
        assertNotNull(recipe.getDescription());
    }

}