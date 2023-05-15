fun main(args: Array<String>) {
    var result = romanToInt("MDCCCLXXXIV")
    println(result)
}

fun romanToInt(s: String): Int {
    var l = s.replace("I", "1 ").replace("V", "5 ")
        .replace("X", "10 ").replace("L", "50 ")
        .replace("C", "100 ").replace("D", "500 ")
        .replace("M", "1000 ")

    var list = l.split(" ")
    var sum : Int = 0
    var i : Int = 0
    while (i < list.size - 1) {
        if (list[i].toInt() < list[i + 1].toInt()) {
            sum += (list[i + 1].toInt() - list[i].toInt())
            i++
        }
        else
            sum += list[i].toInt()
        i++
    }
    return sum
}