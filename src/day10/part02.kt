package day10

import java.nio.file.Paths

fun main() {
    val orderedJoltages = mutableListOf(0).apply { // start with 0
        this.addAll(Paths.get("src/day10/input.in").toFile().readLines().map { it.toInt() }.sorted())
        this.add(this.maxOrNull()!! + 3)
    }

    val state = mutableMapOf(orderedJoltages.size - 1 to 1L)
    for (i in orderedJoltages.size - 2 downTo 0) {
        state[i] = IntRange(i + 1, i + 3)
            .filter { index -> index < orderedJoltages.size && orderedJoltages[index] - orderedJoltages[i] <= 3 }
            .map { index -> state[index]!! }.sum()
    }

    println(state[0])
}