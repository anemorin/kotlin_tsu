fun main(args: Array<String>) {
    var x = 10011001
    print(isPalindrome(x))
}

fun isPalindrome(x: Int): Boolean {
    var b = x
    var c = 0
    while (b > 0) {
        c = c * 10 + (b % 10)
        b = b / 10
    }
    return c == x
}
