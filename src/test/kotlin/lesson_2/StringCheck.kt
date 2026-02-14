package lesson_2

import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("String comparison")
@Story("Comparing strings")
@Tags(Tag("string"),Tag("words"),Tag("regression"))
class CompareStringsTest {

    @Test
    @DisplayName("Comparing two strings")
fun stringCompare() {
    val randomString = "Сядьте, успокойтесь, выпейте чаю, съешьте ещё этих мягких французских булок…"

        val searchString = "Сядьте, успокойтесь, выпейте чаю, съешьте ещё этих мягких французских булок…"
        val stringCompare = randomString.compareTo(searchString, true)
        stringCompare shouldBe 0
}
}