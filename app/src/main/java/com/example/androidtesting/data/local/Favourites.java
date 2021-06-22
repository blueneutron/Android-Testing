package com.example.androidtesting.data.local;

public interface Favourites {
    boolean get(String id);

    boolean toggle(String id);

    void put(String id, boolean favourite);
}
