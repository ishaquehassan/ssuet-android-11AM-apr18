package com.ishaquehassan.finalclass

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.ishaquehassan.finalclass.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.internal.builders.JUnit4Builder
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val mainActivityTest = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun click(){

        onView(ViewMatchers.withId(R.id.editTextData)).perform(ViewActions.typeText("hello world"))
        onView(ViewMatchers.withId(R.id.buttonData)).perform(ViewActions.click())

    }
}