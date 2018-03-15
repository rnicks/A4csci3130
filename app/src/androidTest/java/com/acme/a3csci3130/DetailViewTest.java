package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

/**
 * Created by robertnickerson on 2018-03-14.
 */

public class DetailViewTest {
    String busNumber = "123456789";
    String name = "test";
    String email = "test@test.com";
    String primaryBus = "Fisher";
    String address = "123 Fake Street";
    String province = "NS";

    public DatabaseReference firebaseReference;
    public FirebaseDatabase firebaseDBInstance;

    @Rule
    public ActivityTestRule<DetailViewActivity> mActivityRule = new ActivityTestRule<>(DetailViewActivity.class);

    @Before
    public void setup()
    {
        FirebaseDatabase firebaseDBInstance = FirebaseDatabase.getInstance();
        DatabaseReference firebaseReference = firebaseDBInstance.getReference("businesses");

    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }


    @Test
    /**
     * not sure why test is failing - out of time to figure it out
     */
    public void updateContactTest()
    {

        onView(withId(R.id.business_number)).perform(typeText(busNumber), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.name)).perform(typeText(name), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText(email), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.primary_business)).perform(typeText(primaryBus), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText(address), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText(province), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.updateButton)).perform(click());

    }

    @Test
    public void deleteContactTest()
    {
        onView(withId(R.id.deleteButton)).perform(click());

    }
}
