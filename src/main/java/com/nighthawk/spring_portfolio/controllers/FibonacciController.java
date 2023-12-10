package com.nighthawk.spring_portfolio.controllers;

import com.nighthawk.spring_portfolio.mvc.fibo.fibofor;
import com.nighthawk.spring_portfolio.mvc.fibo.fiboRecursive;
import com.nighthawk.spring_portfolio.mvc.fibo.fiboWhile;
import com.nighthawk.spring_portfolio.mvc.fibo.fiboDynamic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    @GetMapping("/fibonacci/forloop/{n}")
    public String fibonacciForLoop(@PathVariable int n) {
        long startTime = System.nanoTime();
        long result = fibofor.fibonacci(n);
        long endTime = System.nanoTime();
        return "Result: " + result + ", Time taken: " + (endTime - startTime) + " nanoseconds";
    }

    @GetMapping("/fibonacci/recursion/{n}")
    public String fibonacciRecursion(@PathVariable int n) {
        long startTime = System.nanoTime();
        long result = fiboRecursive.fibonacci(n);
        long endTime = System.nanoTime();
        return "Result: " + result + ", Time taken: " + (endTime - startTime) + " nanoseconds";
    }

    @GetMapping("/fibonacci/whileloop/{n}")
    public String fibonacciWhileLoop(@PathVariable int n) {
        long startTime = System.nanoTime();
        long result = fiboWhile.fibonacci(n);
        long endTime = System.nanoTime();
        return "Result: " + result + ", Time taken: " + (endTime - startTime) + " nanoseconds";
    }

    @GetMapping("/fibonacci/dynamic/{n}")
    public String fibonacciDynamic(@PathVariable int n) {
        long startTime = System.nanoTime();
        long result = fiboDynamic.fibonacci(n);
        long endTime = System.nanoTime();
        return "Result: " + result + ", Time taken: " + (endTime - startTime) + " nanoseconds";
    }
}
