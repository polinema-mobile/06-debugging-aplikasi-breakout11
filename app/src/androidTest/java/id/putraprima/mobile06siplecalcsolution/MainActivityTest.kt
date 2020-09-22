package id.putraprima.mobile06siplecalcsolution

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test

@LargeTest
class MainActivityTest{

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testKurang() {
        val appCompatEditText = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.edit_text_angka_pertama), ViewMatchers.isDisplayed()))
        appCompatEditText.perform(ViewActions.replaceText("7"), ViewActions.closeSoftKeyboard())

        val appCompatEditText2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.edit_text_angka_kedua), ViewMatchers.isDisplayed()))
        appCompatEditText2.perform(ViewActions.replaceText("7"), ViewActions.closeSoftKeyboard())

        val appCompatButton = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button_kurang), ViewMatchers.withText("Kurang"), ViewMatchers.isDisplayed()))
        appCompatButton.perform(ViewActions.click())

        val appCompactTextView = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.text_hasil), ViewMatchers.withText("0"))
        )
        appCompactTextView.perform()
    }

    @Test
    fun testTambah() {
        val appCompatEditText = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.edit_text_angka_pertama), ViewMatchers.isDisplayed()))
        appCompatEditText.perform(ViewActions.replaceText("7"), ViewActions.closeSoftKeyboard())

        val appCompatEditText2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.edit_text_angka_kedua), ViewMatchers.isDisplayed()))
        appCompatEditText2.perform(ViewActions.replaceText("7"), ViewActions.closeSoftKeyboard())

        val appCompatButton = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button_tambah), ViewMatchers.withText("Tambah"), ViewMatchers.isDisplayed()))
        appCompatButton.perform(ViewActions.click())

        val appCompactTextView = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.text_hasil), ViewMatchers.withText("14"))
        )
        appCompactTextView.perform()
    }

    @Test
    fun testKali() {
        val appCompatEditText = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.edit_text_angka_pertama), ViewMatchers.isDisplayed()))
        appCompatEditText.perform(ViewActions.replaceText("7"), ViewActions.closeSoftKeyboard())

        val appCompatEditText2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.edit_text_angka_kedua), ViewMatchers.isDisplayed()))
        appCompatEditText2.perform(ViewActions.replaceText("7"), ViewActions.closeSoftKeyboard())

        val appCompatButton = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button_kali), ViewMatchers.withText("Kali"), ViewMatchers.isDisplayed()))
        appCompatButton.perform(ViewActions.click())

        val appCompactTextView = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.text_hasil), ViewMatchers.withText("49"))
        )
        appCompactTextView.perform()
    }

    @Test
    fun testBagi() {
        val appCompatEditText = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.edit_text_angka_pertama), ViewMatchers.isDisplayed()))
        appCompatEditText.perform(ViewActions.replaceText("7"), ViewActions.closeSoftKeyboard())

        val appCompatEditText2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.edit_text_angka_kedua), ViewMatchers.isDisplayed()))
        appCompatEditText2.perform(ViewActions.replaceText("7"), ViewActions.closeSoftKeyboard())

        val appCompatButton = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button_bagi), ViewMatchers.withText("Bagi"), ViewMatchers.isDisplayed()))
        appCompatButton.perform(ViewActions.click())

        val appCompactTextView = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.text_hasil), ViewMatchers.withText("1.00"))
        )
        appCompactTextView.perform()
    }
}