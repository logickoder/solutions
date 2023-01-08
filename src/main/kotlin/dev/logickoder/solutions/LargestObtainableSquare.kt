package dev.logickoder.solutions

/**
 * There are two wooden sticks of lengths A and B respectively. Each of them can be cut into shorter sticks
 * of integer lengths. Our goal is to construct the largest possible square. In order to do this, we want to
 * cut the sticks in such a way as to achieve four sticks of the same length (note that there can be some
 * leftover pieces).
 *
 * Write a function:
 *  class Solution {
 *      public int solution(int A, int B);
 *  }
 * that, given two integers A, B, returns the side length of the largest square that we can obtain. If it is
 * not possible to create any square, the function should return 0.
 *
 * Examples:
 *  1. Given A = 10, B = 21, the function should return 7. We can split the second stick into three sticks of
 *     length 7 and shorten the first stick by 3.
 *  2. Given A = 13, B = 11, the function should return 5. We can cut two sticks of length 5 from each of the
 *     given sticks.
 *  3. Given A = 2, B = 1, the function should return 0. It is not possible to make any square from the given
 *     sticks.
 *  4. Given A = 1, B = 8, the function should return 2. We can cut stick B into four parts.
 *
 * Write an efficient algorithm for the following assumptions:
 *  - A and B are integers within the range [1..1,000,000,000].
 *
 * @param a the length of the first wooden stick
 * @param b the length of the second wooden stick
 * @return the side length of the largest square that can be obtained, or 0 if it is not possible to create any
 *     square
 */
//fun solution(a: Int, b: Int): Int {
//    return gcd(a, b)
//}

fun solution(a: Int, b: Int): Int = when {
    a > b -> solution(b, a)
    a + b <= 3 -> 0
    b / 4 > a -> b / 4
    b / 3 >= a -> a
    b / 3 < a -> (a / 2).coerceAtLeast(b / 3)
    else -> 0
}

fun main() {
    println(solution(10, 21))
    println(solution(13, 11))
    println(solution(2, 1))
    println(solution(1, 8))
}
