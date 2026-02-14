package Koltin_basics.lesson_5.asserts

class PassPhraseValidator {

    fun passPhraseValidator(passPhrase: String): Boolean {
        val passPhraseRegex = Regex("^(?=(?:.*\\d){3,})(?=.*[^A-Za-z0-9])[A-Z0-9^A-Z0-9]*\$")
        return passPhraseRegex.matches(passPhrase)
    }

    companion object {
        fun String.validPassphrase(): Boolean {
            val passPhraseRegex = Regex("^(?=(?:.*\\d){3,})(?=.*[^A-Za-z0-9])[A-Z0-9^A-Z0-9]*\$")
            return passPhraseRegex.matches(this)
        }
    }
}