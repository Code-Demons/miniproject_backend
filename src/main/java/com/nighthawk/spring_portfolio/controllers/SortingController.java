package com.nighthawk.spring_portfolio.controllers;

import com.nighthawk.spring_portfolio.mvc.sort.BubbleSort;
import com.nighthawk.spring_portfolio.mvc.sort.InsertionSort;
import com.nighthawk.spring_portfolio.mvc.sort.MergeSort;
import com.nighthawk.spring_portfolio.mvc.sort.SelectionSort;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:4100")
public class SortingController {

    @GetMapping("/sort/bubble/{array}")
    public Map<String, Object> bubbleSort(@PathVariable int[] array) {
        return sortArray(array, BubbleSort::sort);
    }

    @GetMapping("/sort/insertion/{array}")
    public Map<String, Object> insertionSort(@PathVariable int[] array) {
        return sortArray(array, InsertionSort::sort);
    }

    @GetMapping("/sort/merge/{array}")
    public Map<String, Object> mergeSort(@PathVariable int[] array) {
        return sortArray(array, MergeSort::sort);
    }

    @GetMapping("/sort/selection/{array}")
    public Map<String, Object> selectionSort(@PathVariable int[] array) {
        return sortArray(array, SelectionSort::sort);
    }

    private Map<String, Object> sortArray(int[] array, SortingFunction sortFunction) {
        long startTime = System.nanoTime();
        sortFunction.sort(array);
        long endTime = System.nanoTime();

        Map<String, Object> result = new HashMap<>();
        result.put("sortedArray", arrayToString(array));
        result.put("timeTaken", endTime - startTime);
        return result;
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int value : array) {
            sb.append(value).append(" ");
        }
        return sb.toString().trim();
    }

    @FunctionalInterface
    interface SortingFunction {
        void sort(int[] array);
    }
}
