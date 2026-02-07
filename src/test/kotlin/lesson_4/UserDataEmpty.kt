package lesson_4

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Scope functions")
@Story("Using let and run scope functions")
@Tags(Tag("scope-functions"),Tag("user-data"),Tag("negative-checks"),Tag("regression"))

class UserDataEmpty {

    @Test
    @DisplayName("Null data check")
    fun runScopeFunctions() {

        val secondUser = UserDataClass.UserData(
            "Col",
            null,
            null,
            101,
            "colSunders@email.com",
            true
        )

        secondUser.name.let { println("Users name is $it")}
        secondUser.secondName?.let { println("Users second name is $it") } ?: run { println("User did not specify second name")}
        secondUser.age?.let { println("Users age is $it")} ?: run { println("User did not specify age")}
        secondUser.id.let { println("Users id is $it")}
        secondUser.email.let { println("Users email is $it")}
        secondUser.isActive.let { println("Is user active? $it")}

        secondUser.name.shouldNotBeNull()
        secondUser.secondName.shouldNotBeNull()
        secondUser.age.shouldNotBeNull()
        secondUser.id.shouldNotBeNull()
        secondUser.email.shouldNotBeNull()
        secondUser.isActive.shouldBe(true)
    }
}