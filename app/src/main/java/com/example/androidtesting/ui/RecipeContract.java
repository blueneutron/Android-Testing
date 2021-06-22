package com.example.androidtesting.ui;

import org.jetbrains.annotations.NotNull;

public interface RecipeContract {
    interface View {
        void showRecipeNotFoundError();

        void setTitle(@NotNull String title);

        void setDescription(@NotNull String description);

        void setFavourites(@NotNull Boolean isFavourite);
    }

    interface Listener {
        void toggleFavourite();
    }
}
