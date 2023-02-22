fun main(args: Array<String>) {

    if (args.size != 3) {
        println("Invalid number of program arguments")
    } else {
        for (i in 1..args.size) {
            println("Argument $i: ${args[i - 1]}. It has ${args[i - 1].length} characters")
        }
    }
}