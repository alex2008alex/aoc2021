fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        for (line in input) {
            val (direction, distanceString) = line.split(" ")
            val distance = distanceString.toInt()

            if (direction == "forward") {
                horizontal+=distance
            } else if (direction == "down") {
             depth+=distance
            } else if (direction == "up") {
                depth-=distance
            }
        }
        return horizontal*depth
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0
        for (line in input) {
            val (direction, distanceString) = line.split(" ")
            val distance = distanceString.toInt()

            if (direction == "forward") {
                horizontal+=distance
                depth += aim * distance
            } else if (direction == "down") {
                aim+=distance
            } else if (direction == "up") {
                aim-=distance
            }
        }
        return horizontal*depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
