import java.io.File

fun parseInputFile(): List<String> {
    val input = File("input.txt").readLines()
    return input
}

fun partOne(): Int {
    val input = parseInputFile()
    return input.count {
        val first = it.split(",").first().split("-").map { it.toInt() }
        val second = it.split(",").last().split("-").map { it.toInt() }

        val firstMin = Math.max(first.first(), second.first())
        val secondMin = Math.min(first.last(), second.last())

        (first.first() >= firstMin && first.last() <= secondMin) ||
                (second.first() >= firstMin && second.last() <= secondMin)
    }
}

fun partTwo(): Int {
    val input = parseInputFile()
    return input.count {
        val first = it.split(",").first().split("-").map { it.toInt() }
        val second = it.split(",").last().split("-").map { it.toInt() }

        first.last() >= second.first() && second.last() >= first.first()
    }
}
