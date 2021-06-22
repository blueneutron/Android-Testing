package com.example.androidtesting.ui

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidtesting.R
import com.example.androidtesting.test.RecipeRobot
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.atomic.AtomicReference

@RunWith(AndroidJUnit4::class)
class RecipeActivityTest {

    private val intent =
        Intent(ApplicationProvider.getApplicationContext(), RecipeActivity::class.java).apply {
            putExtra(RecipeActivity.KEY_ID, "creamed_carrots")
        }


    private val activityScenario: AtomicReference<ActivityScenario<RecipeActivity>> =
        AtomicReference()

    @After
    fun tearDown() {
        activityScenario.get()?.close()
    }

    @Test
    fun recipeNotFound() {
        RecipeRobot()
            .launch(activityScenario)
            .noTitle()
            .description(R.string.recipe_not_found)

    }

    @Test
    fun clickToFavourite() {
        RecipeRobot().launch(activityScenario, intent)

        onView(withId(R.id.title))
            .check(matches(withText("Creamed Carrots")))
            .check(matches(not(isSelected())))
            .perform(click())
            .check(matches(isSelected()));

    }

    @Test
    fun alreadyFavourite() {
        RecipeRobot()
            .setFavourites("creamed_carrots")
            .launch(activityScenario, intent)
            .title("Creamed Carrots")
            .isFavourite

    }
}