package com.example.androidtesting.ui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.androidtesting.data.local.Favourites;
import com.example.androidtesting.data.local.RecipeStore;
import com.example.androidtesting.data.model.Recipe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.InputStream;

public class RecipePresenterTest {

    private RecipeStore recipeStore;
    private RecipeContract.View view;
    private Favourites favourites;
    private RecipePresenter presenter;

    @Before
    public void setup() {
        recipeStore = Mockito.mock(RecipeStore.class);
        favourites = Mockito.mock(Favourites.class);
        view = Mockito.mock(RecipeContract.View.class);
        presenter = new RecipePresenter(recipeStore, view, favourites);
    }


    @Test
    public void recipeNotFound() {
        Mockito.when(recipeStore.getRecipe(Mockito.anyString())).thenReturn(null);
        presenter.loadRecipe("no_such_recipe");
        Mockito.verify(view, Mockito.times(1)).showRecipeNotFoundError();
    }

    @Test(expected = IllegalStateException.class)
    public void toggleWithoutLoad() {
        presenter.toggleFavourite();
    }

    @Test
    public void loadWaterAndFavourite() {
        InputStream inputStream = RecipePresenterTest.class.getResourceAsStream("/recipes/water.txt");
        Recipe recipe = Recipe.readFromStream(inputStream);
        Mockito.when(recipeStore.getRecipe(Mockito.anyString())).thenReturn(recipe);
        Mockito.when(favourites.toggle(Mockito.anyString())).thenReturn(true);

        presenter.loadRecipe("water");
        presenter.toggleFavourite();

        ArgumentCaptor<Boolean> captor = ArgumentCaptor.forClass(Boolean.class);
        Mockito.verify(view, Mockito.times(2)).setFavourites(captor.capture());
        assertFalse(captor.getAllValues().get(0));
        assertTrue(captor.getAllValues().get(1));
    }
}