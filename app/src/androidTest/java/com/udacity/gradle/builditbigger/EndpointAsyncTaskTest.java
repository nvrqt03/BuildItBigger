package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {

//    @Rule
//    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
//            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void asyncTaskTest() throws Exception {

        //onView(withId(R.id.jokeButton)).perform(click());
        EndpointAsyncTask task = new EndpointAsyncTask();
        task.execute(InstrumentationRegistry.getTargetContext());
        String text = task.get();
        Thread.sleep(5000);
        assertFalse(text.isEmpty());
    }
}
