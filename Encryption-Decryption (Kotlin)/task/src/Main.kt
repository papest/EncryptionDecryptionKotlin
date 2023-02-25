package encryptdecrypt

import java.io.File

const val ALPHABET_LENGTH = 26

fun main(args: Array<String>) {
    try {
        Operations(args).operation
    } catch (e: Exception) {
        println(e.message)
    }
}

class Operations(args: Array<String>) {
    private val parameters = Args(args)
    private var data = parameters.data
    private var writeOperation = { a: String, _: String -> println(a) }
    private var cryptDecryptOperations = ::shift
    private var key = if (parameters.mode == "dec") -parameters.key else parameters.key
    var operation = writeOperation(cryptDecryptOperations(data, key), parameters.outFile)

    init {
        if (data.isEmpty() && parameters.inFile.isNotEmpty()) {
            data = readData(parameters.inFile)
        }
        if (parameters.alg == "unicode") {
            cryptDecryptOperations = ::unicode
        }
        if (parameters.outFile.isNotEmpty()) writeOperation = ::writeData
        operation = writeOperation(cryptDecryptOperations(data, key), parameters.outFile)

    }

    private fun unicode(data: String, key: Int): String = data.map { it + key }.joinToString("")

    private fun shift(data: String, key: Int): String = data.map {
        var key = key
        while (key < 0) {
            key += ALPHABET_LENGTH
        }
        when (it) {
            in 'a'..'z' -> 'a' + (it - 'a' + key) % ALPHABET_LENGTH
            in 'A'..'Z' -> 'A' + (it - 'A' + key) % ALPHABET_LENGTH
            else -> it
        }
    }.joinToString("")

    private fun writeData(outData: String, outFile: String) {
        try {
            val file = File(outFile)
            file.writeText(outData)

        } catch (e: Exception) {
            errorPrinting("writing", e)
        }
    }

    private fun readData(inFile: String): String {
        try {
            val file = File(inFile)
            return file.readText()
        } catch (e: Exception) {
            errorPrinting("reading", e)
        }
        return ""
    }

    private fun errorPrinting(s: String, e: Exception) {
        println("Error in $s exception: ${e.message}")
        throw Exception("encryption-decryption Error")

    }

}

class Args(args: Array<String>) {
    var mode: String = "enc"
    var key: Int = 0
    var data: String = ""
    var inFile: String = ""
    var outFile: String = ""
    var alg: String = "unicode"

    init {
        for (i in args.indices step 2) {
            when (args[i]) {
                "-mode" -> mode = args[i + 1]
                "-key" -> key = args[i + 1].toInt()
                "-data" -> data = args[i + 1]
                "-in" -> inFile = args[i + 1]
                "-out" -> outFile = args[i + 1]
                "-alg" -> alg = args[i + 1]
            }
        }
    }

}