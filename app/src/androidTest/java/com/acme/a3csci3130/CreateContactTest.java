package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import android.app.Activity;



import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.Espresso.onData;
/**
 * Created by robertnickerson on 2018-03-14.
 */

public class CreateContactTest {

    String busNumber = "123456789";
    String name = "test";
    String email = "test@test.com";
    String primaryBus = "Fisher";
    String address = "123 Fake Street";
    String province = "NS";

    public DatabaseReference firebaseReference;
    public FirebaseDatabase firebaseDBInstance;

    @Rule
    public ActivityTestRule<CreateContactAcitivity> mActivityRule = new ActivityTestRule<>(CreateContactAcitivity.class);

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
    public void createContactTest()
    {

        onView(withId(R.id.business_number)).perform(typeText(busNumber), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.name)).perform(typeText(name), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText(email), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.primary_business)).perform(typeText(primaryBus), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText(address), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText(province), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.submitButton)).perform(click());

    }
}
