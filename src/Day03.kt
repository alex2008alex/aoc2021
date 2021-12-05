fun main() {
    fun part1(input: List<String>): Int {
        val results = IntArray(input[1].length)

        for (line in input) {
            for (i in line.indices) {
                results[i] += line[i].digitToInt()
            }
        }

        var gamma = ""
        var epsilon = ""
        for (val_res in results) {
            if (val_res > input.size / 2) {
                gamma += "1"
                epsilon += "0"
            } else {
                gamma += "0"
                epsilon += "1"
            }
        }

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>, ogr: Boolean): Int {
        var cp = input
        val len = input[0].length
        var i = 0
        while (i < len && cp.size > 1) {
            var zeros = 0
            var ones = 0
            for (line in cp) {
                when (line[i]) {
                    '0' -> zeros++
                    '1' -> ones++
                }
            }
            val keep = if (ogr) {
                if (ones >= zeros) '1' else '0'
            } else {
                if (zeros <= ones) '0' else '1'
            }
            cp = cp.filter { line -> line[i] == keep }
            i++
        }
        return cp.first().toInt(2)
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input, true) * part2(input, false))
}
