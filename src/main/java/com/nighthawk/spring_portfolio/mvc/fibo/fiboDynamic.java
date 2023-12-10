package com.nighthawk.spring_portfolio.mvc.fibo;

public class fiboDynamic {

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        int n = 10; // Example number
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}
