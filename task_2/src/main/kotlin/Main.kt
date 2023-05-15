fun main(args: Array<String>) {
    var result = romanToInt("III")
    println(result)
}

fun romanToInt(s: String): Int {
    val list = mutableListOf<Int>()
    for (i in s) {
        list.add(replacer(i))
    }
    var sum : Int = 0
    var i : Int = 0
    while (i < list.size) {
        if (i != list.size - 1 && list[i] < list[i + 1]) {
            sum += (list[i + 1] - list[i])
            i++
        }
        else
            sum += list[i]
        i++
    }
    return sum
}

fun replacer(s : Char): Int {
    return s.toString().replace("I", "1").replace("V", "5")
        .replace("X", "10").replace("L", "50")
        .replace("C", "100").replace("D", "500")
        .replace("M", "1000").toInt()
}