package lesson_5.asserts

class EmailValidator {

    fun validEmailCheck(email: String): Boolean {
        val emailRegexp = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$")
        return emailRegexp.matches(email)
    }

    companion object {
        fun String.validEmail(): Boolean {
            val emailRegex = Regex("^[A-Za-z0-9.-]+@[A-Za-z0-9.-]+\$")
            return emailRegex.matches(this)
        }
    }
}