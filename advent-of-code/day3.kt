import java.io.File

fun main(){
    val rucksack = parseInput()
    println(partOne(rucksack))
    println(partTwo(rucksack))
}

private fun parseInput(): List<String> = File("input.txt").readLines()

private fun partOne(rucksack:List<String>):Int{
    var sum = 0
    rucksack.forEach{
        val first = it.substring(0,it.length/2).toList()
        val second = it.substring(it.length/2).toList()

        val intersection = first.intersect(second)

        intersection.forEach{
          if(it.isUpperCase()){
              sum += it - 'A' + 27
          }else{
                sum += it - 'a' + 1
          }
        }
    }
    return sum
}


private fun partTwo(rucksack:List<String>):Int{
    var sum = 0

    rucksack.chunked(3){
        val intesection = it[0].toList().intersect(it[1].toList()).intersect(it[2].toList())

        intesection.forEach{
            if(it.isUpperCase()){
                sum+=it-'A'+27
            }else{
                sum+=it-'a'+1
            }
        }

    }

    return sum
}
