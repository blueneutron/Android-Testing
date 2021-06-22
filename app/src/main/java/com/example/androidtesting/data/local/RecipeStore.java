package com.example.androidtesting.data.local;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.androidtesting.data.model.Recipe;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeStore {

    public final List<Recipe> recipes = new ArrayList<>();
    private final Map<String, Recipe> map = new HashMap<>();

    public RecipeStore(Context context, String directory) {

        List<InputStream> streams = getAssetStreams(context.getAssets(), directory);

        for (InputStream stream : streams) {
            Recipe recipe = Recipe.readFromStream(stream);
            if (recipe != null) {
                recipes.add(recipe);
                map.put(recipe.getId(), recipe);
            }
        }
    }

    private static List<InputStream> getAssetStreams(AssetManager assetManager, String directory) {
        String[] filenames = getFilenames(assetManager, directory);
        List<InputStream> streams = new ArrayList<>();
        for (String filename : filenames) {
            File file = new File(directory, filename);
            try {
                InputStream inputStream = assetManager.open(file.getPath());
                if (inputStream != null) {
                    streams.add(inputStream);
                }
            } catch (IOException ioe) {
            }
        }
        return streams;
    }

    private static String[] getFilenames(AssetManager assetManager, String directory) {
        if (directory == null) {
            return new String[0];
        }
        try {
            return assetManager.list(directory);
        } catch (IOException ioe) {
            return new String[0];
        }
    }

    public Recipe getRecipe(String id) {
        return map.get(id);
    }
}
