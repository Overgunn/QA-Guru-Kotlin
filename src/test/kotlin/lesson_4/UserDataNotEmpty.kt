package lesson_4

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotBeEmpty
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Scope functions")
@Story("Using let and run scope functions")
@Tags(Tag("scope-functions"),Tag("non-null-check"),Tag("regression"))

class UserDataNotEmpty {

    @Test
    @DisplayName("Non-null data check")
    fun runScopeFunctions() {
        val firstUser = UserDataClass.UserData(
            "Ronald",
            "McDonald",
            33,
            100,
            "ronMcD@email.com",
            true
        )

        firstUser.name.let { println("Users name is $it")}
        firstUser.secondName?.let { println("Users second name is $it") } ?: run { println("User did not specify second name")}
        firstUser.age?.let { println("Users age is $it")} ?: run { println("User did not specify age")}
        firstUser.id.let { println("Users id is $it")}
        firstUser.email.let { println("Users email is $it")}
        firstUser.isActive.let { println("Is user active? $it")}

        with(firstUser) {
            println("User info: Name = $name, Second Name = $secondName, age = $age, isActive = $isActive")}

                firstUser.name.shouldNotBeNull()
                firstUser.secondName.shouldNotBeEmpty()
                firstUser.age.shouldNotBeNull()
                firstUser.id.shouldNotBeNull()
                firstUser.email.shouldNotBeNull()
                firstUser.isActive.shouldBe(true)

    }
}