package com.example.androidtesting.data.model;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.InputStream;

public class RecipeTest {

    @Test
    public void water() {
        InputStream inputStream = Recipe.class.getResourceAsStream("/recipes/water.txt");
        Recipe recipe = Recipe.readFromStream(inputStream);
        assertNotNull(recipe);
        assertEquals("water", recipe.getId());
        assertEquals("Water", recipe.getTitle());
        assertEquals("Put a glass of water", recipe.getDescription());
    }

    @Test
    public void mixed() {
        InputStream inputStream = Recipe.class.getResourceAsStream("/recipes/mixed.txt");
        Recipe recipe = Recipe.readFromStream(inputStream);
        assertNotNull(recipe);
        assertEquals("punch", recipe.getId());
        assertEquals("Punch", recipe.getTitle());
        assertEquals(
                "Juice of 3 lemons\n" +
                "1 orange\n" +
                "1 pint grape juice\n" +
                "1 cup sugar\n" +
                "1 cup water\n" +
                "1 pine apple juice\n" +
                "Mix all together and strain. Add large piece of ice.", recipe.getDescription());
    }

}