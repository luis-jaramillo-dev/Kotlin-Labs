class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        var result = intArrayOf(0,0)
        var sum = 0;
        var index = 0;
        while (index < nums.size && sum != target){
            val indexValue = nums[index]
            for (j in 0..nums.size){
                 sum = indexValue + nums[j]
                println("comparing $sum")
                if (target == sum){
                    result[0] = index
                    result[1] = j
                    break
                }
            }
            index++
        }
        println("${result.get(0)} - ${result.get(1)}")


        return result;


    }


}

fun main() {
    TwoSum().twoSum(intArrayOf(2,3,4), 6 )
}