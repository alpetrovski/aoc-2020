package day04

import java.nio.file.Paths
import java.util.*

val validFields = arrayOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

fun main() {
    val parsedPassports = LinkedList<Set<String>>()

    Paths.get("src/day04/input.in").toFile().readLines().reduce { previousLine, currentLine ->
        if (currentLine.isBlank()) {
            parsedPassports.add(parsePass(previousLine))
            ""
        } else {
            "$previousLine $currentLine"
        }
    }.also { lastLine ->
        parsedPassports.add(parsePass(lastLine))
    }

    val validPassports = parsedPassports.count { passport ->
        validFields.all { passport.contains(it) }
    }

    println("Valid passports: $validPassports")
}

private fun parsePass(input: String): Set<String> {
    return input.split(" ").map { it.split(":")[0] }.toSet()
}