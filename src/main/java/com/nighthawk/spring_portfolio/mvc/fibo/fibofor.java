package com.nighthawk.spring_portfolio.mvc.fibo;

public class fibofor {

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long fib = 1;
        long prevFib = 1;

        for (int i = 2; i < n; i++) {
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }

        return fib;
    }

    public static void main(String[] args) {
        int n = 10; // Example number
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}
