package com.javarush.task.task34.task3401;

/* 
Числа Фибоначчи с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.fibonacci(9));     //34
        System.out.println(solution.fibonacci(5));     //5
        System.out.println(solution.fibonacci(2));     //1
        System.out.println(solution.fibonacci(1));     //1
    }

    public int fibonacci(int n) {
        int i = 0;
        if (n == 1) {
            return 1;
        }
        if (n > 0) {
            int fibonacciNMinus1 = fibonacci(n - 1) + fibonacci(n - 2);
            i += fibonacciNMinus1;
        }
        return i;
    }
}
