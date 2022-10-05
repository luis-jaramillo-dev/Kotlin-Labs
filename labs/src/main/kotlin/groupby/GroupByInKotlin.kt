package groupby

class GroupByInKotlin {


    fun simpleGroupBy(){
        val numbers = listOf(-2, -1, 0, 1)
        println(numbers.groupBy { it < 0 }) // {true=[-2, -1], false=[0, 1]}
    }
}

fun main() {
    GroupByInKotlin().simpleGroupBy()
}