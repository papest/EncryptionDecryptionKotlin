package encryptdecrypt

const val ALPHABET_LENGTH = 26
fun main() {
    println(shiftEncrypt(readln(), readln().toInt()))
}

fun shiftEncrypt(input: String, key: Int): String {
    val result = mutableListOf<Char>()
    for (ch in input) {
        if (ch in 'a'..'z') {
            result.add('a' + (ch - 'a' + key) % ALPHABET_LENGTH)
        } else {
            result.add(ch)

        }
    }
    return result.joinToString("")

}
