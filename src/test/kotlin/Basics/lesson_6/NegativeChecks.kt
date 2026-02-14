package Basics.lesson_6

import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Data class")
@Story("Data class compare-checks(negative checks)")
@Tags(Tag("data-class"),Tag("negative-checks"),Tag("regression"))

class NegativeChecks {
    val Basics.lesson_6.StudentsEnum.toStudent: Basics.lesson_6.StudentData
        get() = _root_ide_package_.Basics.lesson_6.StudentData(
            firstName,
            lastName,
            age,
            studentId,
            grade,
            averageScore
        )
    val defaultStudent = _root_ide_package_.Basics.lesson_6.StudentData(
        "Paul",
        "Bunyan",
        15,
        1,
        10,
        92.5
    )

    @Test
    @DisplayName("Full data compare test")
    fun studentDataCheck() {
        val expectedStudentData = _root_ide_package_.Basics.lesson_6.StudentData(
            "Roddy",
            "Pipper",
            17,
            3,
            11,
            70.5
        )
        val actualStudentData = defaultStudent
        expectedStudentData shouldBe actualStudentData
    }

    @Test
    @DisplayName("By line data compare test with defaultStudent copy")
    fun studentDataCheckByLine() {
        val studentsDataCopy = defaultStudent.copy(
            firstName = "Long-Tall",
            lastName = "Sally",
            age = 16,
            studentId = 2,
            grade = 10,
            averageScore = 96.0
        )
        studentsDataCopy.firstName shouldBe defaultStudent.firstName
        studentsDataCopy.lastName shouldBe defaultStudent.lastName
        studentsDataCopy.age shouldBe defaultStudent.age
        studentsDataCopy.studentId shouldBe defaultStudent.studentId
        studentsDataCopy.grade shouldBe defaultStudent.grade
        studentsDataCopy.averageScore shouldBe defaultStudent.averageScore
    }

    @Test
    @DisplayName("Get data from enum class for negative check")
    fun secondStudentEnumData() {
        val secondEnumStudent = _root_ide_package_.Basics.lesson_6.StudentsEnum.STUDENT_2

        secondEnumStudent.firstName shouldBe defaultStudent.firstName
        secondEnumStudent.lastName shouldBe defaultStudent.lastName
        secondEnumStudent.age shouldBe defaultStudent.age
        secondEnumStudent.studentId shouldBe defaultStudent.studentId
        secondEnumStudent.grade shouldBe defaultStudent.grade
        secondEnumStudent.averageScore shouldBe defaultStudent.averageScore

    }

    @Test
    @DisplayName("Enum toStudent conversion test")
    fun enumToStudentTest() {
        val expectedStudent = defaultStudent
        val actualStudent = _root_ide_package_.Basics.lesson_6.StudentsEnum.STUDENT_2.toStudent

        actualStudent shouldBe expectedStudent
    }

}