package lesson_5

import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import lesson_5.asserts.EmailValidator.Companion.validEmail
import lesson_5.asserts.PassPhraseValidator.Companion.validPassphrase
import lesson_5.asserts.PhoneValidator.Companion.validNumber
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Asserts")
@Story("Assert checks using regexp")
@Tags(Tag("asserts"),Tag("positive-checks"),Tag("regression"))

class PositiveChecks {

    val validUserData = BasicData.BasicData(
        "Hilly",
        "Billy",
        "farmerhead@gmail.com",
        "+1234567890",
        "PASSPHRASE123^"
    )



    @Test
    @DisplayName("Phone number assertion")
    fun phoneAssertTest() {
        val assertPhoneNumber = validUserData.phoneNumber
        val validTestNumber = assertPhoneNumber.validNumber()

        validTestNumber shouldBe true
    }

    @Test
    @DisplayName("Phone number assertion with infix")
    fun phoneAssertInfixTest() {
        val assertPhoneNumber = validUserData.phoneNumber
        val validTestNumber = assertPhoneNumber.validNumber()

        infix fun String.isPhoneValid(expected: Boolean) {
            val actual = this.validNumber()
            if (actual != expected) throw AssertionError("Phone '$this': expected $expected, got $actual") }

        validUserData.phoneNumber isPhoneValid true
    }

    @Test
    @DisplayName("E-mail assertion")
    fun emailAssertTest() {
        val assertEmail = validUserData.email
        val validTestEmail = assertEmail.validEmail()

        validTestEmail shouldBe true
    }

    @Test
    @DisplayName("E-mail assertion with infix")
    fun emailAssertInfixTest() {
        val assertEmail = validUserData.email
        val validTestEmail = assertEmail.validEmail()

        infix fun String.isEmailValid(expected: Boolean) {
            val actual = this.validEmail()
            if (actual != expected) throw AssertionError("Email '$this': expected $expected, got $actual") }

        validUserData.email isEmailValid true
    }

    @Test
    @DisplayName("Passphrase assertion")
    fun passPhraseAssertTest() {
        val assertPassphrase = validUserData.passPhrase
        val validPassphrase = assertPassphrase.validPassphrase()

        validPassphrase shouldBe true
    }

    @Test
    @DisplayName("Passphrase assertion with infix")
    fun passPhraseAssertInfixTest() {
        val assertPassphrase = validUserData.passPhrase
        val validPassphrase = assertPassphrase.validPassphrase()

        infix fun String.isPassphraseValid(expected: Boolean) {
            val actual = this.validPassphrase()
            if (actual != expected) throw AssertionError("Passphrase '$this': expected $expected, got $actual") }

        validUserData.passPhrase isPassphraseValid true
    }
}