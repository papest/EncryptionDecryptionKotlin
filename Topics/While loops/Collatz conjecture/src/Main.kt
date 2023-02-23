@SuppressWarnings("MagicNumber")
fun main() {

    var n = readln().toInt()

    val result = mutableListOf<Int>()

    while (n != 1) {

        result.add(n)
        if (n % 2 == 0) {
            n /= 2
        } else {
            n = n * 3 + 1

        }

    }

    result.add(1)

    println(result.joinToString(" "))

}