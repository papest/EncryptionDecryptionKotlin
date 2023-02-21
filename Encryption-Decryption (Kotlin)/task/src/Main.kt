package encryptdecrypt

fun main() {
    println(encrypt("we found a treasure!"))
}

fun encrypt(input: String): String {
    val result = mutableListOf<Char>()
    for (ch in input) {
        if (ch in 'a'..'z') {
            result.add('a' + ('z' - ch))
        } else {
            result.add(ch)
        }

    }
    return result.joinToString("")
}