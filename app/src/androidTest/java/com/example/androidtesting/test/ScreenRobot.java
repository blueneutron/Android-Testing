package com.example.androidtesting.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isSelected;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import androidx.annotation.IntegerRes;
import androidx.annotation.StringRes;

public abstract class ScreenRobot<T extends ScreenRobot> {

    public T checkIsHidden(@IntegerRes int... viewIds) {
        for (int viewId : viewIds) {
            onView(withId(viewId))
                    .check(matches(not(isDisplayed())));
        }
        return (T) this;
    }

    public T checkViewHasText(@IntegerRes int viewId, @StringRes int stringId) {
        onView(withId(viewId))
                .check(matches(withText(stringId)));

        return (T) this;
    }

    public T checkViewHasText(@IntegerRes int viewId, String string) {
        onView(withId(viewId))
                .check(matches(withText(string)));

        return (T) this;
    }

    public T checkIsSelected(@IntegerRes int... viewIds) {
        for (int viewId : viewIds) {
            onView(withId(viewId))
                    .check(matches(isSelected()));
        }
        return (T) this;
    }
}
