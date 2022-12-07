import java.io.File
import java.util.Scanner

fun main() {
    val stack =
            mutableListOf(
                    "GWLJBRTD".toList(),
                    "CWS".toList(),
                    "MTZR".toList(),
                    "VPSHCTD".toList(),
                    "ZDLTPG".toList(),
                    "DCQJZRBF".toList(),
                    "RTFMJDBS".toList(),
                    "MVTBRHL".toList(),
                    "VSDPQ".toList(),
            )
    // partOne(stack)
    partTwo(stack)
    stack.forEach { print(it[0]) }
}

fun parseFileInput(): List<List<Int>> {
    val input = File("input.txt").readLines()
    val moves = mutableListOf<List<Int>>()

    input.forEach {
        val scanner = Scanner(it)
        scanner.useDelimiter("[^0-9]+")

        val move = mutableListOf<Int>()
        while (scanner.hasNextInt()) {
            move.add(scanner.nextInt())
        }
        moves.add(move)
    }

    return moves
}

fun partOne(stack: MutableList<List<Char>>) {
    parseFileInput().forEach {
        val first = stack[it[1] - 1]
        val second = stack[it[2] - 1]
        val numToMove = it[0]

        stack.set(it[2] - 1, first.take(numToMove).reversed().plus(second))
        stack.set(it[1] - 1, first.drop(numToMove))
    }
}

fun partTwo(stack: MutableList<List<Char>>) {
    parseFileInput().forEach {
        val first = stack[it[1] - 1]
        val second = stack[it[2] - 1]
        val numToMove = it[0]

        stack.set(it[2] - 1, first.take(numToMove).plus(second))
        stack.set(it[1] - 1, first.drop(numToMove))
    }
}
