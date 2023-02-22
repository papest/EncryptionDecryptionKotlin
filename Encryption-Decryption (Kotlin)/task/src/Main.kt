package encryptdecrypt

fun main(args: Array<String>) {
    val parameters = Args(args)

    println(
        if (parameters.mode == "enc") {
            shiftEncrypt(parameters.data, parameters.key)
        } else {
            shiftDecrypt(parameters.data, parameters.key)
        }
    )


}

class Args(args: Array<String>) {
    var mode: String = "enc"
    var key: Int = 0
    var data: String = ""

    init {
        for (i in 0..2) {

            when (args[i + i]) {
                "-mode" -> mode = args[i + i + 1]
                "-key" -> key = args[i + i + 1].toInt()
                "-data" -> data = args[i + i + 1]
            }
        }
    }


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