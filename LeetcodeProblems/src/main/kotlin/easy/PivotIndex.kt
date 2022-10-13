package easy

class PivotIndex {

    fun pivotIndex(nums: IntArray): Int {
        var leftsum = 0
        var sum = 0
        for (x in nums) sum += x
        for (i in 0 until nums.size) {
            if (leftsum === sum - leftsum - nums[i]) return i
            leftsum += nums[i]
        }
        return -1
    }
}
