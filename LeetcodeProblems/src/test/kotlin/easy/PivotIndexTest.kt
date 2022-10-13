package easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum
 * of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
 * This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
internal class PivotIndexTest {
    private val pivotIndex: PivotIndex = PivotIndex()

    @Test
    fun testPivotIndex() {
        val expected = 3
        assertEquals(expected, pivotIndex.pivotIndex( intArrayOf(1,7,3,6,5,6)))
    }
}