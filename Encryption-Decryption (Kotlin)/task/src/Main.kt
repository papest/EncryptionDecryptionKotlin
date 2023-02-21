package encryptdecrypt

fun main() {
    val choice = readln()
    val input = readln()
    val key = readln().toInt()

    println(
        if (choice == "enc") {
            shiftEncrypt(input, key)
        } else {
            shiftDecrypt(input, key)
        }
    )
}

fun shiftEncrypt(input: String, key: Int): String {
    val result = mutableListOf<Char>()
    for (ch in input) {
        result.add(ch + key)

    }
    return result.joinToString("")

}

fun shiftDecrypt(input: String, key: Int): String {
    val result = mutableListOf<Char>()
    for (ch in input) {
        result.add(ch - key)

    }
    return result.joinToString("")
}