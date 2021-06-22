package com.example.androidtesting.data.local;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesFavourites implements Favourites {

    private final SharedPreferences preferences;

    public SharedPreferencesFavourites(Context context) {
        this.preferences = context.getSharedPreferences("favourites.xml", Context.MODE_PRIVATE);
    }

    @Override
    public boolean get(String id) {
        return preferences.getBoolean(id, false);
    }

    @Override
    public void put(String id, boolean favourite) {
        SharedPreferences.Editor editor = preferences.edit();
        if (favourite) {
            editor.putBoolean(id, true);
        } else {
            editor.remove(id);
        }
        editor.apply();
    }

    @Override
    public boolean toggle(String id) {
        boolean favourite = get(id);
        put(id, !favourite);
        return !favourite;
    }
}
