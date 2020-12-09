package day09

import java.nio.file.Paths
import java.util.*

fun main() {
    println(findWeakness("src/day09/input.in"))
}

private fun findWeakness(filePath: String): Long? {
    val invalidNumber = findInvalidNumber(filePath)!!
    val contiguousRange = LinkedList<Long>()

    Paths.get(filePath).toFile().readLines().map { it.toLong() }.forEach {number ->
        contiguousRange.addLast(number)

        while (contiguousRange.sum() > invalidNumber) {
            contiguousRange.removeFirst()
        }

        if (contiguousRange.sum() == invalidNumber) {
            return contiguousRange.minOrNull()!! + contiguousRange.maxOrNull()!!
        }
    }
    return null
}
