package day05

import java.nio.file.Paths

fun main() {
    val sortedSeats = getSeatNumbers().sorted()
    for (seatIndex in 1 until sortedSeats.size) {
        if (sortedSeats[seatIndex] != sortedSeats[seatIndex-1] + 1) {
            println(sortedSeats[seatIndex-1] + 1)
            return
        }
    }
    println("seat not found")
}

private fun getSeatNumbers(): List<Int> {
    return Paths.get("src/day05/input.in").toFile().readLines().map { boardingPass ->
        val row = boardingPass.substring(0, 7)
                .replace("B", "1")
                .replace("F", "0")
                .let { binaryString -> Integer.parseInt(binaryString, 2)}
        val column = boardingPass.substring(7)
                .replace("R", "1")
                .replace("L", "0")
                .let { binaryString -> Integer.parseInt(binaryString, 2)}
        row * 8 + column
    }
}