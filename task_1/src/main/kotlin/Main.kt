fun main(args: Array<String>) {
    var nums = intArrayOf(1, 2, 3, 4)
    var result = twoSum(nums, 5)
    for (i in result) {
        println(i)
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in 0 until nums.size) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target)
                return intArrayOf(i, j)
        }
    }
    return intArrayOf()
}

