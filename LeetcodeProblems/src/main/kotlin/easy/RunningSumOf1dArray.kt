package easy


    fun runningSum(nums: IntArray): IntArray {
        var result =  arrayListOf<Int>()
        for ((index, value)  in nums.withIndex() ){
            val sum = nums.filterIndexed{
                i, v -> i<= index
            }.sum()
            result.add(sum)
        }
        return result.toIntArray()
    }


fun main() {
    val  array = intArrayOf(3,1,2,10,1)
     val arrayResult = runningSum(array)
    arrayResult.forEach {
        print("$it ")
    }


}
