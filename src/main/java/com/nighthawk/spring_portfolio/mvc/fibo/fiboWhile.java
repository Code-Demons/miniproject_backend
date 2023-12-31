package com.nighthawk.spring_portfolio.mvc.fibo;

public class fiboWhile {

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1, c;
        int i = 2;
        while (i <= n) {
            c = a + b;
            a = b;
            b = c;
            i++;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 10; // Example number
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}
