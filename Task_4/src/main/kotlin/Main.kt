fun main(args: Array<String>) {
    print(removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4)))
}

fun removeDuplicates(nums: IntArray): Int {
    var result = nums.toSet()
    var j = 0
    for (i in result) {
        nums[i] = i
        j++
    }

    return result.size
}