package com.codingwithset.fixaslabtask

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
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

    val LIST_ITEM_IN_TEST = 4
    //val DATA_IN_TEST =



    @Test
    fun test_ifDataVisible_onAppLaunch() {

        onView(ViewMatchers.withId(R.id.parent_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun checkElementAtSpecifiedPosition() {
        // First, scroll to the position that needs to be matched and click on it.

//        onView(ViewMatchers.withId(R.id.recyclerview))
//            .perform(RecyclerViewActions.actionOnItemAtPosition(4, click()))


//        onView(ViewMatchers.withId(R.id.recyclerview))
//            .perform(
//                RecyclerViewActions.actionOnItemAtPosition(
//                   4,
//                    click()
//                )
//            )

        // Match the text in an item below the fold and check that it's displayed.
//        val itemElementText = "${activityRule.activity.resources
//            .getString(R.string.item_element_text)} ${ITEM_BELOW_THE_FOLD.toString()}"
//        onView(withText(itemElementText)).check(matches(isDisplayed()))
    }
}