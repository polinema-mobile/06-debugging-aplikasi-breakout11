package id.putraprima.mobile06siplecalcsolution


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun tambah() {
        onView(withId(R.id.edit_text_angka_pertama)).perform(replaceText("2"))
        onView(withId(R.id.edit_text_angka_kedua)).perform(replaceText("2"), closeSoftKeyboard())
        onView(withId(R.id.button_tambah)).perform(click())
        onView(withId(R.id.text_hasil)).check(matches(withText("4")))
    }

    @Test
    fun kurang(){
        onView(withId(R.id.edit_text_angka_pertama)).perform(replaceText("2"))
        onView(withId(R.id.edit_text_angka_kedua)).perform(replaceText("2"), closeSoftKeyboard())
        onView(withId(R.id.button_kurang)).perform(click())
        onView(withId(R.id.text_hasil)).check(matches(withText("0")))
    }

    @Test
    fun kali(){
        onView(withId(R.id.edit_text_angka_pertama)).perform(replaceText("2"))
        onView(withId(R.id.edit_text_angka_kedua)).perform(replaceText("2"), closeSoftKeyboard())
        onView(withId(R.id.button_kali)).perform(click())
        onView(withId(R.id.text_hasil)).check(matches(withText("4")))
    }

    @Test
    fun bagi(){
        onView(withId(R.id.edit_text_angka_pertama)).perform(replaceText("4"))
        onView(withId(R.id.edit_text_angka_kedua)).perform(replaceText("2"), closeSoftKeyboard())
        onView(withId(R.id.button_bagi)).perform(click())
        onView(withId(R.id.text_hasil)).check(matches(withText("2.00")))
    }

    @Test
    fun zero_division(){
        onView(withId(R.id.edit_text_angka_pertama)).perform(replaceText("0"))
        onView(withId(R.id.edit_text_angka_kedua)).perform(replaceText("2"), closeSoftKeyboard())
        onView(withId(R.id.button_bagi)).perform(click())
        onView(withId(R.id.text_hasil)).check(matches(withText("Can't Divide By Zero")))
    }

    @Test
    fun empty_no_force(){
        onView(withId(R.id.edit_text_angka_pertama)).perform(replaceText(""))
        onView(withId(R.id.edit_text_angka_kedua)).perform(replaceText(""), closeSoftKeyboard())
        onView(withId(R.id.button_bagi)).perform(click())
        onView(withText("Perhatikan Input, kosong")).inRoot(withDecorView(not(mActivityTestRule.activity.window.decorView))).check(matches(isDisplayed()))
    }

    @Test
    fun punctuation_everywhere(){
        onView(withId(R.id.edit_text_angka_pertama)).perform(replaceText("-"))
        onView(withId(R.id.edit_text_angka_kedua)).perform(replaceText("+"), closeSoftKeyboard())
        onView(withId(R.id.button_bagi)).perform(click())
        onView(withText("Perhatikan Input, angka tidak ada")).inRoot(withDecorView(not(mActivityTestRule.activity.window.decorView))).check(matches(isDisplayed()))
    }
}
