fun main() {
    fun part1(input: List<String>): Int {
        val numbers = input.map(String::toInt)
        var prev = numbers[0]

        var count = 0
        for (i in 1 until numbers.size) {
            if (numbers[i] > prev) {
                count++
            }
            prev = numbers[i]
        }
        return count
    }

    fun part2(input: List<String>): Int {
        val numbers = input.map(String::toInt)
        var first = numbers[0]
        var second = numbers[1]
        var third = numbers[2]

        var count = 0
        var prev = first+second+third

        for (i in 3 until numbers.size) {
            first = second
            second = third
            third = numbers[i]

            val new = first+second+third
            if (new > prev) {
                count++
            }
            prev = new
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
