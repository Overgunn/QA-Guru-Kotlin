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
@Story("Using let, run and apply scope functions")
@Tags(Tag("scope-functions"),Tag("user-data"),Tag("regression"))

class UserDataApply {

    @Test
    @DisplayName("Scope functions")
    fun runScopeFunctions() {
        val thirdUser = UserDataClass.UserData(
            "King",
            null,
            null,
            100,
            "KingBurger@email.com",
            false
        )

        thirdUser.apply {
            secondName = "unspecified"
        }

        thirdUser.apply {
            age = 50
        }

        thirdUser.apply {
            isActive = true
        }

        thirdUser.name.let { println("Users name is $it")}
        thirdUser.secondName?.let { println("Users second name is $it") } ?: run { println("User did not specify second name")}
        thirdUser.age?.let { println("Users age is $it")} ?: run { println("User did not specify age")}
        thirdUser.id.let { println("Users id is $it")}
        thirdUser.email.let { println("Users email is $it")}
        thirdUser.isActive.let { println("Is user active? $it")}

        thirdUser.name.shouldNotBeNull()
        thirdUser.secondName.shouldNotBeEmpty()
        thirdUser.age.shouldNotBeNull()
        thirdUser.id.shouldNotBeNull()
        thirdUser.email.shouldNotBeNull()
        thirdUser.isActive.shouldBe(true)

    }
}