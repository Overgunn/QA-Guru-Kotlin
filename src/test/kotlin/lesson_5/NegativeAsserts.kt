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
@Tags(Tag("asserts"),Tag("negative-checks"),Tag("regression"))

class NegativeAsserts {

    val validUserData = BasicData.BasicData(
        "Hilly",
        "Billy",
        "farmerhead @gmail.com",
        "+123456-7890",
        "pass!PHRASE123"
    )



    @Test
    @DisplayName("Phone number assertion")
    fun phoneAssertTest() {
        val assertPhoneNumber = validUserData.phoneNumber
        val validTestNumber = assertPhoneNumber.validNumber()

        validUserData.phoneNumber.validNumber() shouldBe true
        validTestNumber shouldBe true
    }

    @Test
    @DisplayName("E-mail assertion")
    fun emailAssertTest() {
        val assertEmail = validUserData.email
        val validTestEmail = assertEmail.validEmail()

        validTestEmail shouldBe true
    }

    @Test
    @DisplayName("Passphrase assertion")
    fun passPhraseAssertTest() {
        val assertPassphrase = validUserData.passPhrase
        val validPassphrase = assertPassphrase.validPassphrase()

        validPassphrase shouldBe true
    }
}