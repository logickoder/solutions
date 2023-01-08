package dev.logickoder.solutions

/***
 * Write a function:
 * fun solution(A: IntArray): Int
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
private fun solution(array: IntArray): Int {
    // remove all redundant numbers
    val set = array.toSet()
    // get the beginning and end of the numbers
    // the integer one [1] is added to give a positive end range for numbers stuck in only the negative side
    val range = set.toMutableSet().apply { add(1) }.sorted().run {
        IntRange(first(), last())
    }
    // walk through the range and check if a value in the set is not in the range and the value is positive
    // then get the minimum, if none exists, return the integer immediately after the end of the range
    return range.filter { it > 0 && it !in set }.minOfOrNull { it } ?: (range.last + 1)
}

fun main() {
    assert(solution(arrayOf(1, 3, 6, 4, 1, 2).toIntArray()) == 5)
    assert(solution(arrayOf(1, 2, 3).toIntArray()) == 4)
    assert(solution(arrayOf(-1, -3).toIntArray()) == 1)
}