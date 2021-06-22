package com.example.androidtesting.ui;

import com.example.androidtesting.data.local.Favourites;
import com.example.androidtesting.data.local.RecipeStore;
import com.example.androidtesting.data.model.Recipe;

public class RecipePresenter implements RecipeContract.Listener {

    private final RecipeStore recipeStore;
    private final RecipeContract.View view;
    private final Favourites favourites;
    private Recipe recipe;

    public RecipePresenter(RecipeStore recipeStore, RecipeContract.View view, Favourites favourites) {
        this.recipeStore = recipeStore;
        this.view = view;
        this.favourites = favourites;
    }

    public void loadRecipe(String id) {
        recipe = recipeStore.getRecipe(id);
        if(recipe == null) {
            view.showRecipeNotFoundError();
        } else {
            view.setTitle(recipe.getTitle());
            view.setDescription(recipe.getDescription());
            view.setFavourites(favourites.get(recipe.getId()));
        }
    }

    @Override
    public void toggleFavourite() {
        if(recipe == null) {
            throw new IllegalStateException("recipe is null");
        }
        Boolean result = favourites.toggle(recipe.getId());
        view.setFavourites(result);
    }
}
