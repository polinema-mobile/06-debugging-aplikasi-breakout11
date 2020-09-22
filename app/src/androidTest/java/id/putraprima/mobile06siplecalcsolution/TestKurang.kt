package id.putraprima.mobile06siplecalcsolution

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test

@LargeTest
class TestKurang {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testKurang() {
        val appCompatEditText = onView(
                allOf(withId(R.id.edit_text_angka_pertama), isDisplayed()))
        appCompatEditText.perform(replaceText("7"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
                allOf(withId(R.id.edit_text_angka_kedua), isDisplayed()))
        appCompatEditText2.perform(replaceText("7"), closeSoftKeyboard())

        val appCompatButton = onView(
                allOf(withId(R.id.button_kurang), withText("Kurang"), isDisplayed()))
        appCompatButton.perform(click())

        val appCompactTextView = onView(
                allOf(withId(R.id.text_hasil), withText("0"))
        )
        appCompactTextView.perform()
    }
}
