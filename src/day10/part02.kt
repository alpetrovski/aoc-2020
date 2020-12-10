package day10

import java.nio.file.Paths

fun main() {
    val orderedJoltages = mutableListOf(0).apply { // start with 0
        this.addAll(Paths.get("src/day10/input.in").toFile().readLines().map { it.toInt() })
        this.add(this.maxOrNull()!! + 3)
    }.sorted()

    val state = mutableMapOf(orderedJoltages.size - 1 to 1L)
    for (i in orderedJoltages.size - 2 downTo 0) {
        state[i] = calculateFromIndex(orderedJoltages, i, state)
    }

    println(state[0])
}

fun calculateFromIndex(orderedJoltages: List<Int>, fromIndex: Int, state: Map<Int, Long>): Long {
    if (state.containsKey(fromIndex)) {
        return state[fromIndex]!!
    }

    return IntRange(fromIndex + 1, fromIndex + 3)
            .filter { index -> index < orderedJoltages.size && orderedJoltages[index] - orderedJoltages[fromIndex] <= 3 }
            .map { index -> calculateFromIndex(orderedJoltages, index, state) }.sum()
}