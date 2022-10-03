import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun plusMinus(arr: Array<Int>): Unit {
    // Write your code here

    val positives = arr.count { it > 0 }.toDouble()
    val negatives  = arr.count { it<0 }.toDouble()
    val zero = arr.count { it ==0 }.toDouble()
    val dec = DecimalFormat("0.000000")
    dec.roundingMode = RoundingMode.CEILING

    println(dec.format(positives/arr.size))
    println(dec.format(negatives.div(arr.size)))
    println(dec.format(zero.div(arr.size)))




}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    plusMinus(arr)
}
