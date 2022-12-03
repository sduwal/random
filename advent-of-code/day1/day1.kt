import java.io.File

fun main(){
    val weights = readFile()

    println("The max weight is: ${weights.maxOrNull()}")

    val top3 = weights.sortedDescending().take(3)
    println("The top 3 weights are: ${top3.sum()}")
}

// read file in kotlin
fun readFile(): List<Int>{
    val weight: MutableList<Int> = mutableListOf()        // or, use `arrayListOf`
    val file = File("input.txt")
    val lines = file.readLines()

    var sum =0

    lines.forEach{
        if(it==""){
            weight.add(sum)
            sum=0
        }else{
        val value = it.toInt()
        sum += value
     }
    }
    return weight
}