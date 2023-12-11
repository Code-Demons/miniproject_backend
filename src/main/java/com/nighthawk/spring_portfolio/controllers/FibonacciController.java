package com.nighthawk.spring_portfolio.controllers;

import com.nighthawk.spring_portfolio.mvc.fibo.fibofor;
import com.nighthawk.spring_portfolio.mvc.fibo.fiboRecursive;
import com.nighthawk.spring_portfolio.mvc.fibo.fiboWhile;
import com.nighthawk.spring_portfolio.mvc.fibo.fiboDynamic;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:4100")
public class FibonacciController {

    @GetMapping("/fibonacci/forloop/{n}")
    public Map<String, Object> fibonacciForLoop(@PathVariable int n) {
        return calculateFibonacci(n, fibofor::fibonacci);
    }

    @GetMapping("/fibonacci/recursion/{n}")
    public Map<String, Object> fibonacciRecursion(@PathVariable int n) {
        return calculateFibonacci(n, fiboRecursive::fibonacci);
    }

    @GetMapping("/fibonacci/whileloop/{n}")
    public Map<String, Object> fibonacciWhileLoop(@PathVariable int n) {
        return calculateFibonacci(n, fiboWhile::fibonacci);
    }

    @GetMapping("/fibonacci/dynamic/{n}")
    public Map<String, Object> fibonacciDynamic(@PathVariable int n) {
        return calculateFibonacci(n, fiboDynamic::fibonacci);
    }

    private Map<String, Object> calculateFibonacci(int n, FibonacciFunction fiboFunction) {
        long startTime = System.nanoTime();
        long result = fiboFunction.fibonacci(n);
        long endTime = System.nanoTime();

        Map<String, Object> response = new HashMap<>();
        response.put("result", result);
        response.put("timeTaken", endTime - startTime);
        return response;
    }

    @FunctionalInterface
    interface FibonacciFunction {
        long fibonacci(int n);
    }
}
