package com.nighthawk.spring_portfolio.mvc.sort;

public class BubbleSort {

    public static void sort(int[] array) {
        long startTime = System.nanoTime();

        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    // swap array[j+1] and array[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Bubble Sort Time: " + duration + " nanoseconds");
    }
}
