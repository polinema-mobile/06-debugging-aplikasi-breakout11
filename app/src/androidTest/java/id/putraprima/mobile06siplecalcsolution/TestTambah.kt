package id.putraprima.mobile06siplecalcsolution


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TestTambah {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testTambah() {
        val appCompatEditText = onView(
                allOf(withId(R.id.edit_text_angka_pertama),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()))
        appCompatEditText.perform(replaceText("7"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
                allOf(withId(R.id.edit_text_angka_kedua),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()))
        appCompatEditText2.perform(click())

        val appCompatEditText3 = onView(
                allOf(withId(R.id.edit_text_angka_kedua),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()))
        appCompatEditText3.perform(replaceText(""), closeSoftKeyboard())

        val appCompatEditText4 = onView(
                allOf(withId(R.id.edit_text_angka_kedua),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()))
        appCompatEditText4.perform(click())

        val appCompatEditText5 = onView(
                allOf(withId(R.id.edit_text_angka_kedua),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()))
        appCompatEditText5.perform(replaceText("7"), closeSoftKeyboard())

        val appCompatButton = onView(
                allOf(withId(R.id.button_tambah), withText("Tambah"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()))
        appCompatButton.perform(click())

        val appCompactTextView = onView(
                allOf(withId(R.id.text_hasil), withText("14"))
        )
        appCompactTextView.perform()
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
