package com.example.androidtesting;

import android.app.Application;

import com.example.androidtesting.data.local.Favourites;
import com.example.androidtesting.data.local.SharedPreferencesFavourites;

public class RecipeApplication extends Application {

    private Favourites favourites = null;

    public Favourites getFavourites() {
        if (favourites == null) {
            favourites = new SharedPreferencesFavourites(this);
        }
        return favourites;
    }

}
