package com.example.androidtesting.data.model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Recipe {

    public static final String ID_PREFIX = "id=";
    private static final String TITLE_PREFIX = "title=";
    private String id;
    private String title;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static Recipe readFromStream(InputStream inputStream) {
        String id = null;
        String title = null;
        StringBuilder descriptionBuilder = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                if (line.startsWith(ID_PREFIX)) {
                    id = line.substring(ID_PREFIX.length());
                    continue;
                }
                if (line.startsWith(TITLE_PREFIX)) {
                    title = line.substring(TITLE_PREFIX.length());
                    continue;
                }
                if (descriptionBuilder.length() > 0) {
                    descriptionBuilder.append("\n");
                }
                descriptionBuilder.append(line);
            }
        } catch (IOException e) {
            return null;
        }

        return new Recipe(id, title, descriptionBuilder.toString());
    }
}
