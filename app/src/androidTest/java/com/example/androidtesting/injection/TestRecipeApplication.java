package com.example.androidtesting.injection;

import com.example.androidtesting.RecipeApplication;
import com.example.androidtesting.data.local.Favourites;
import com.example.androidtesting.data.local.ImMemoryFavourites;

public class TestRecipeApplication extends RecipeApplication {

    private final Favourites favourites = new ImMemoryFavourites();

    @Override
    public Favourites getFavourites() {
        return favourites;
    }
}
