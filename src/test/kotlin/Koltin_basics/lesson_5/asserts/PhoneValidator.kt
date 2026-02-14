package Koltin_basics.lesson_5.asserts

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
}