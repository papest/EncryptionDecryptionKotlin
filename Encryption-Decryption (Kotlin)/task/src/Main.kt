package encryptdecrypt

import java.io.File

fun main(args: Array<String>) {
    try {
        val parameters = Args(args)
        val data = readData(parameters.data, parameters.inFile)
        val outData = encryptDecrypt(parameters.mode, data, parameters.key)
        writeData(outData, parameters.outFile)
    } catch (e: Exception) {
        println(e.message)
    }

}

fun writeData(outData: String, outFile: String) {
    if (outFile.isEmpty()) {
        println(outData)
    } else {
        try {
            val file = File(outFile)
            file.writeText(outData)

        } catch (e: Exception) {
            errorPrinting("writing", e)
        }
    }
}

fun readData(data: String, inFile: String): String {
    if (data.isNotEmpty()) return data
    try {
        val file = File(inFile)
        return file.readText()
    } catch (e: Exception) {
        errorPrinting("reading", e)
    }
    return ""
}

fun errorPrinting(s: String, e: Exception) {
    println("Error in $s exception: ${e.message}")
    throw Exception("encryption-decryption Error")

}

class Args(args: Array<String>) {
    var mode: String = "enc"
    var key: Int = 0
    var data: String = ""
    var inFile: String = ""
    var outFile: String = ""

    init {
        for (i in args.indices step 2) {

            when (args[i]) {
                "-mode" -> mode = args[i + 1]
                "-key" -> key = args[i + 1].toInt()
                "-data" -> data = args[i + 1]
                "-in" -> inFile = args[i + 1]
                "-out" -> outFile = args[i + 1]
            }
        }
    }

}

fun encryptDecrypt(mode: String, data: String, key: Int): String =
    if (mode == "enc") shiftEncrypt(data, key) else shiftDecrypt(data, key)

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