import java.util.Arrays

class GroupAnagrams {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var result = mutableListOf<List<String>>()
         strs.groupBy { it.sort() }.values.forEach {result.add(it)  }
        return  result
    }
    private fun String.sort():String{
        val srtCharArray =  this.toCharArray()
        Arrays.sort(srtCharArray)
        return String(srtCharArray)
    }

}

fun main() {
    GroupAnagrams().groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
}