package lesson_6

enum class StudentsEnum(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val studentId: Int,
    val grade: Int,
    val averageScore: Double
) {
    STUDENT_1(
        "Paul",
        "Bunyan",
        15,
        1,
        10,
        92.5
    ),
    STUDENT_2(
        "Long-Tall",
        "Sally",
        16,
        2,
        10,
        96.0
    );
}
