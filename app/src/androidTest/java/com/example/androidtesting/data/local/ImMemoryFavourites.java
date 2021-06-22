package com.example.androidtesting.data.local;

import java.util.HashMap;
import java.util.Map;

public class ImMemoryFavourites implements Favourites {

    private final Map<String, Boolean> map = new HashMap<>();

    @Override
    public boolean get(String id) {
        Boolean value = map.get(id);
        return value != null ? value : false;
    }

    @Override
    public boolean toggle(String id) {
        boolean value = get(id);
        put(id, !value);
        return !value;
    }

    @Override
    public void put(String id, boolean favourite) {
        map.put(id, favourite);
    }

    public void clear() {
        map.clear();
    }
}
