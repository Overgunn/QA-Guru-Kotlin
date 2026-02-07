package lesson_5.asserts

class PhoneValidator {

    fun validPhoneNumber(phoneNumber: String): Boolean {
        val phoneRegex = Regex("^\\+?[1-9]\\d{1,14}\$")
        return phoneRegex.matches(phoneNumber)
    }

    companion object {
        fun String.validNumber(): Boolean {
            val phoneRegex = Regex("^\\+?[1-9]\\d{1,14}\$")
            return phoneRegex.matches(this)
        }
    }

    infix fun String.phoneCheck(expected: Boolean) {
        val actual = this.validNumber()
        if (actual != expected) throw AssertionError("Phone '$this': expected $expected, got $actual")
    }
}