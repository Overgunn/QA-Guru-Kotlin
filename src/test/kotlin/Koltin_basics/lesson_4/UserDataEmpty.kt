/*
package Basics.lesson_4

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
@Tags(Tag("scope-functions"),Tag("null-check"),Tag("negative-checks"),Tag("regression"))

class UserDataEmpty {

    @Test
    @DisplayName("Null data check")
    fun runScopeFunctions() {

        val secondUser = _root_ide_package_.Basics.lesson_4.UserDataClass.UserData(
            "Col",
            null,
            null,
            101,
            "colSunders@email.com",
            false
        )

        secondUser.name.let { println("Users name is $it")}
        secondUser.secondName?.let { println("Users second name is $it") } ?: run { println("User did not specify second name")}
        secondUser.age?.let { println("Users age is $it")} ?: run { println("User did not specify age")}
        secondUser.id.let { println("Users id is $it")}
        secondUser.email.let { println("Users email is $it")}
        secondUser.isActive.let { println("Is user active? $it")}

        with(secondUser) {
            println("User info: Name = $name, secondName = $secondName, age = $age, isActive = $isActive")}

        secondUser.name.shouldNotBeNull()
        secondUser.secondName.shouldNotBeNull()
        secondUser.age.shouldNotBeNull()
        secondUser.id.shouldNotBeNull()
        secondUser.email.shouldNotBeNull()
        secondUser.isActive.shouldBe(true)

    }
}*/
