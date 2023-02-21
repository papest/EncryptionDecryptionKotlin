package encryptdecrypt

fun main() {
    println(shiftEncrypt(readln(), readln().toInt()))
}

fun shiftEncrypt(input: String, key: Int): String {
    val result = mutableListOf<Char>()
    for (ch in input) {
        result.add(ch + key)

    }
    return result.joinToString("")

}
