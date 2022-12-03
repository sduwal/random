import java.io.File

enum class Moves(val point:Int){
    ROCK(1),
    PAPER(2),
    SCISSORS(3)
}

val opponent = mapOf(
    "A" to Moves.ROCK,
    "B" to Moves.PAPER,
    "C" to Moves.SCISSORS,
)

val player = mapOf(
    "X" to Moves.ROCK,
    "Y" to Moves.PAPER,
    "Z" to Moves.SCISSORS,
)

val expectedResult = mapOf<String,Int>(
    "X" to 0,
    "Y" to 3,
    "Z" to 6,
)

fun main(){
    val points = parseInput()
    println("You would get ${points[0]} if you followed the strategy")
    println("You would get ${points[1]} if you followed the real strategy")
}

fun parseInput(): Array<Int>{
    val input = File("input.txt").readLines()
    var sum = 0
    var expectedSum = 0

    input.forEach{
        val opponentMove: Moves = opponent[it.split(" ")[0]]!!
        val playerMove:Moves = player[it.split(" ")[1]]!!

        sum+=playerMove.point+calculatePoint(opponentMove, playerMove)

        val expectedResultPoint:String = it.split(" ")[1]
        expectedSum+= chooseMove(opponentMove,expectedResultPoint).point + expectedResult[expectedResultPoint]!!
    }

    return arrayOf(sum, expectedSum)
}

fun calculatePoint(opponentMove: Moves, playerMove: Moves): Int{
    if(opponentMove == playerMove){
        return 3
    }
    if(opponentMove == Moves.ROCK && playerMove == Moves.PAPER ||
        opponentMove == Moves.PAPER && playerMove == Moves.SCISSORS ||
        opponentMove == Moves.SCISSORS && playerMove == Moves.ROCK){
        return 6
    }

    return 0
}

fun chooseMove(opponentMove:Moves, requiredReult: String):Moves{
    if(requiredReult=="X"){
        if(opponentMove==Moves.ROCK) return Moves.SCISSORS
        if(opponentMove==Moves.PAPER) return Moves.ROCK
        if(opponentMove==Moves.SCISSORS) return Moves.PAPER
    }

    if(requiredReult=="Z"){
        if(opponentMove==Moves.ROCK) return Moves.PAPER
        if(opponentMove==Moves.PAPER) return Moves.SCISSORS
        if(opponentMove==Moves.SCISSORS) return Moves.ROCK
    }

     return opponentMove
}