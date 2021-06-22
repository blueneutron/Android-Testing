package com.example.androidtesting.test;

import android.content.Intent;

import androidx.annotation.StringRes;
import androidx.test.core.app.ActivityScenario;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.androidtesting.R;
import com.example.androidtesting.data.local.ImMemoryFavourites;
import com.example.androidtesting.injection.TestRecipeApplication;
import com.example.androidtesting.ui.RecipeActivity;

import java.util.concurrent.atomic.AtomicReference;

public class RecipeRobot extends ScreenRobot<RecipeRobot> {

    private final ImMemoryFavourites inMemoryFavourites;

    public RecipeRobot() {
        TestRecipeApplication testApplication =
                (TestRecipeApplication) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
        inMemoryFavourites = (ImMemoryFavourites) testApplication.getFavourites();
        inMemoryFavourites.clear();
    }

    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.title);
    }

    public RecipeRobot title(String sting) {
        return checkViewHasText(com.example.androidtesting.R.id.title, sting);
    }

    public RecipeRobot description(@StringRes int stringId) {
        return checkViewHasText(com.example.androidtesting.R.id.description, stringId);
    }

    public RecipeRobot launch(AtomicReference<ActivityScenario<RecipeActivity>> activityScenario) {
        activityScenario.set(ActivityScenario.launch(RecipeActivity.class));
        return this;
    }

    public RecipeRobot launch(AtomicReference<ActivityScenario<RecipeActivity>> activityScenario, Intent intent) {
        activityScenario.set(ActivityScenario.launch(intent));
        return this;
    }

    public RecipeRobot setFavourites(String id) {
        inMemoryFavourites.put(id, true);
        return this;
    }

    public RecipeRobot isFavourite() {
        checkIsSelected(R.id.title);
        return this;
    }
}
