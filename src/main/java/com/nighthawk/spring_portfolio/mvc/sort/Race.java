import java.util.Random;
import java.util.Arrays;


public class Race {
    public static int[] generateRandomArray(int length, int maxValue) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(maxValue + 1);
        }

        return array;
    }
    public static long[] runSortingAlgorithms() {
        long[] sortingTimes = new long[4];

        int arrayLength = 1000; // Adjust the length as needed
        int maxValue = 100; // Adjust the maximum value as needed

        int[] array = generateRandomArray(arrayLength, maxValue);
        // Adjust the length and constants accordingly
        int constantMultiplier = 1000;

        // Run and measure Bubble Sort
        long startTime = System.currentTimeMillis();
        SortingAlgorithm bubbleSort = new BubbleSort();
        bubbleSort.sort(array.clone());  // Clone to avoid modifying the original array
        long endTime = System.currentTimeMillis();
        long bubbleSortTime = endTime - startTime;
        sortingTimes[0] = bubbleSortTime;

        // Run and measure Insertion Sort
        startTime = System.currentTimeMillis();
        SortingAlgorithm insertionSort = new InsertionSort();
        insertionSort.sort(array.clone());
        endTime = System.currentTimeMillis();
        long insertionSortTime = endTime - startTime;
        sortingTimes[1] = insertionSortTime;

        // Run and measure Merge Sort
        startTime = System.currentTimeMillis();
        SortingAlgorithm mergeSort = new MergeSort();
        mergeSort.sort(array.clone());
        endTime = System.currentTimeMillis();
        long mergeSortTime = endTime - startTime;
        sortingTimes[2] = mergeSortTime;

        // Run and measure Quick Sort
        startTime = System.currentTimeMillis();
        SortingAlgorithm quickSort = new QuickSort();
        quickSort.sort(array.clone());
        endTime = System.currentTimeMillis();
        long quickSortTime = endTime - startTime;
        sortingTimes[3] = quickSortTime;

        // Print or store the results
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " milliseconds");
        System.out.println("Insertion Sort Time: " + insertionSortTime + " milliseconds");
        System.out.println("Merge Sort Time: " + mergeSortTime + " milliseconds");
        System.out.println("Quick Sort Time: " + quickSortTime + " milliseconds");

        // Return array of stats
        // order of array: (bubble, insertion, merge, quick)
        return sortingTimes;

    }
    public static void main(String[] args) {
        // Adjust the length and constants accordingly
        long[] sortingTimes = runSortingAlgorithms();

        // Print or use the sorting times array as needed
        System.out.println("Sorting Algorithm Times: " + Arrays.toString(sortingTimes));
    }
}
