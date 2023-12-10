package com.nighthawk.spring_portfolio.mvc.sort;

public class SelectionSort {

    public static void sort(int[] array) {
        long startTime = System.nanoTime();

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;

            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Selection Sort Time: " + duration + " nanoseconds");
    }
}
