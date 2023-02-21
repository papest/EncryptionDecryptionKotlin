fun main() {
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    if (numbers.size > 1) {
        val first = numbers.first()
        numbers[0] = numbers.last()
        numbers[numbers.size - 1] = first
    }
    println(numbers.joinToString(separator = " "))
}