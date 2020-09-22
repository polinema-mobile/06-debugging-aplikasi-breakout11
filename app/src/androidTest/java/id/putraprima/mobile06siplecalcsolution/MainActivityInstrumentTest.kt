package id.putraprima.mobile06siplecalcsolution

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import id.putraprima.mobile06siplecalcsolution.ToastMatcher.Companion.onToast
import org.hamcrest.Matchers.allOf

@LargeTest
class MainActivityInstrumentTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testKurang() {
        onView(allOf(withId(R.id.edit_text_angka_pertama), isDisplayed()))
                .perform(replaceText("7"), closeSoftKeyboard())

        onView(allOf(withId(R.id.edit_text_angka_kedua), isDisplayed()))
                .perform(replaceText("7"), closeSoftKeyboard())

        onView(allOf(ViewMatchers.withId(R.id.button_kurang), withText("Kurang"), isDisplayed()))
                .perform(ViewActions.click())

        onView(allOf(withId(R.id.text_hasil), withText("0")))
                .perform()
    }

    @Test
    fun testTambah() {
        onView(allOf(withId(R.id.edit_text_angka_pertama), isDisplayed()))
                .perform(replaceText("7"), closeSoftKeyboard())

        onView(allOf(withId(R.id.edit_text_angka_kedua), isDisplayed()))
                .perform(replaceText("7"), closeSoftKeyboard())

        onView(allOf(ViewMatchers.withId(R.id.button_tambah), withText("Tambah"), isDisplayed()))
                .perform(ViewActions.click())

        onView(allOf(withId(R.id.text_hasil), withText("14")))
                .perform()
    }

    @Test
    fun testKali() {
        onView(allOf(withId(R.id.edit_text_angka_pertama), isDisplayed()))
                .perform(replaceText("7"), closeSoftKeyboard())

        onView(allOf(withId(R.id.edit_text_angka_kedua), isDisplayed()))
                .perform(replaceText("7"), closeSoftKeyboard())

        onView(allOf(ViewMatchers.withId(R.id.button_kali), withText("Kali"), isDisplayed()))
                .perform(ViewActions.click())

        onView(allOf(withId(R.id.text_hasil), withText("49")))
                .perform()
    }

    @Test
    fun testBagi() {
        onView(allOf(withId(R.id.edit_text_angka_pertama), isDisplayed()))
                .perform(replaceText("7"), closeSoftKeyboard())

        onView(allOf(withId(R.id.edit_text_angka_kedua), isDisplayed()))
                .perform(replaceText("7"), closeSoftKeyboard())

        onView(allOf(ViewMatchers.withId(R.id.button_bagi), withText("Bagi"), isDisplayed()))
                .perform(ViewActions.click())

        onView(allOf(withId(R.id.text_hasil), withText("1.0")))
                .perform()
    }

    @Test
    fun testToast() {
        onView(allOf(withId(R.id.button_bagi), withText("Bagi"), isDisplayed()))
                .perform(ViewActions.click())

        onToast("Input harus diisi").check(matches(isDisplayed()))

        onView(allOf(withId(R.id.edit_text_angka_pertama), isDisplayed()))
                .perform(replaceText("7"), closeSoftKeyboard())

        onView(allOf(withId(R.id.button_bagi), withText("Bagi"), isDisplayed()))
                .perform(ViewActions.click())

        onToast("Input harus diisi").check(matches(isDisplayed()))
    }

    @Test
    fun testNan() {
        onView(allOf(withId(R.id.edit_text_angka_pertama), isDisplayed()))
                .perform(replaceText("0"), closeSoftKeyboard())

        onView(allOf(withId(R.id.edit_text_angka_kedua), isDisplayed()))
                .perform(replaceText("0"), closeSoftKeyboard())

        onView(allOf(ViewMatchers.withId(R.id.button_bagi), withText("Bagi"), isDisplayed()))
                .perform(ViewActions.click())

        onView(allOf(withId(R.id.text_hasil), withText("tidak bisa dibagi 0")))
                .perform()
    }

    @Test
    fun testInfinite() {
        onView(allOf(withId(R.id.edit_text_angka_pertama), isDisplayed()))
                .perform(replaceText("65"), closeSoftKeyboard())

        onView(allOf(withId(R.id.edit_text_angka_kedua), isDisplayed()))
                .perform(replaceText("0"), closeSoftKeyboard())

        onView(allOf(ViewMatchers.withId(R.id.button_bagi), withText("Bagi"), isDisplayed()))
                .perform(ViewActions.click())

        onView(allOf(withId(R.id.text_hasil), withText("tidak bisa dibagi 0")))
                .perform()
    }
}