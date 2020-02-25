package com.codingwithset.fixaslabtask

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.codingwithset.fixaslabtask.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityTest{
    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)



    @Test
    fun test_ifDataVisible_onAppLaunch() {

        onView(ViewMatchers.withId(R.id.parent_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun checkElementAtSpecifiedPosition() {

    }
}