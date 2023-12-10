package com.nighthawk.spring_portfolio.controllers;

import com.nighthawk.spring_portfolio.mvc.sort.BubbleSort;
import com.nighthawk.spring_portfolio.mvc.sort.InsertionSort;
import com.nighthawk.spring_portfolio.mvc.sort.MergeSort;
import com.nighthawk.spring_portfolio.mvc.sort.SelectionSort;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortingController {

    @GetMapping("/sort/bubble/{array}")
    public String bubbleSort(@PathVariable int[] array) {
        long startTime = System.nanoTime();
        BubbleSort.sort(array);
        long endTime = System.nanoTime();
        return "Sorted Array: " + arrayToString(array) + ", Time taken: " + (endTime - startTime) + " nanoseconds";
    }

    @GetMapping("/sort/insertion/{array}")
    public String insertionSort(@PathVariable int[] array) {
        long startTime = System.nanoTime();
        InsertionSort.sort(array);
        long endTime = System.nanoTime();
        return "Sorted Array: " + arrayToString(array) + ", Time taken: " + (endTime - startTime) + " nanoseconds";
    }

    @GetMapping("/sort/merge/{array}")
    public String mergeSort(@PathVariable int[] array) {
        long startTime = System.nanoTime();
        MergeSort.sort(array);
        long endTime = System.nanoTime();
        return "Sorted Array: " + arrayToString(array) + ", Time taken: " + (endTime - startTime) + " nanoseconds";
    }

    @GetMapping("/sort/selection/{array}")
    public String selectionSort(@PathVariable int[] array) {
        long startTime = System.nanoTime();
        SelectionSort.sort(array);
        long endTime = System.nanoTime();
        return "Sorted Array: " + arrayToString(array) + ", Time taken: " + (endTime - startTime) + " nanoseconds";
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int value : array) {
            sb.append(value).append(" ");
        }
        return sb.toString().trim();
    }
}
