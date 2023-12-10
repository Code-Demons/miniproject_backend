package com.nighthawk.spring_portfolio.mvc.fibo;

public class fiboRecursive {

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 10; // Example number
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}
