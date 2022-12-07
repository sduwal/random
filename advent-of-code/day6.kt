import java.io.File

fun main() {
    val input = File("input.txt").readLines()[0].toList()
    // part 1
    for (i in 0..input.size - 4) {
        if (input.subList(i, i + 4).distinct().size == 4) {
            println(i + 4)
            break
        }
    }

    // part 2
    for (i in 0..input.size - 14) {
        if (input.subList(i, i + 14).distinct().size == 14) {
            println(i + 14)
            break
        }
    }
}
