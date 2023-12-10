package com.nighthawk.spring_portfolio.mvc.sort;

public class InsertionSort {

    public static void sort(int[] array) {
        long startTime = System.nanoTime();

        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Insertion Sort Time: " + duration + " nanoseconds");
    }
}
