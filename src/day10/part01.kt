package day10

import java.nio.file.Paths

fun main() {
    val orderedJoltages = mutableListOf(0).apply {
        this.addAll(Paths.get("src/day10/input.in").toFile().readLines().map { it.toInt() }.sorted())
        this.add(this.maxOrNull()!! + 3)
    }

    val result = orderedJoltages.zipWithNext { a, b -> b - a }.groupingBy { it }.eachCount()
        .filter {entry -> entry.key == 1  || entry.key == 3}
        .map { entry -> entry.value }
        .reduce { a, b -> a * b }

    println(result)
}