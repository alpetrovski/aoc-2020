package day10

import java.nio.file.Paths

fun main() {
    val orderedJoltages = mutableListOf(0).apply { // start with 0
        this.addAll(Paths.get("src/day10/input.in").toFile().readLines().map { it.toInt() }.sorted())
    }

    val diffs = IntRange(1, orderedJoltages.size - 1)
        .map {index -> orderedJoltages[index] - orderedJoltages[index - 1]}
        .groupingBy { it }.eachCount()

    println(diffs[1]!! * (diffs[3]!! + 1)) // add 1 for the last joltage
}