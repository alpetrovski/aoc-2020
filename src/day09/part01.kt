package day09

import java.nio.file.Paths
import java.util.*

fun main() {
    println(findInvalidNumber("src/day09/input.in"))
}

fun findInvalidNumber(filePath: String): Long? {
    val preamble = 25
    val lastNumbers = LinkedList<Long>()

    Paths.get(filePath).toFile().readLines().map { it.toLong() }.forEach {number ->
        if (lastNumbers.size == preamble) {
            if (!isValidNumber(number, lastNumbers)) {
                return number
            }
            lastNumbers.removeFirst()
        }
        lastNumbers.addLast(number)
    }
    return null
}

private fun isValidNumber(number: Long, lastNumbers: List<Long>): Boolean {
    lastNumbers.forEach { number1 ->
        lastNumbers.forEach { number2 ->
            if (number1 != number2 && number1 + number2 == number) {
                return true
            }
        }
    }
    return false
}