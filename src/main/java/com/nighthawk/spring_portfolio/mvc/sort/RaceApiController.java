import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/sort")
public class RaceApiController {

    @GetMapping("/run")
    public Map<String, long[]> runSortingAlgorithms() {
        int[] array = Race.generateRandomArray(10000, 1000);

        long[] sortingTimes = runSortingAlgorithms(array);

        Map<String, long[]> result = new HashMap<>();
        result.put("sortingTimes", sortingTimes);

        return result;
    }

    private long[] runSortingAlgorithms(int[] array) {
        long[] sortingTimes = new long[4];
        int[] clonedArray = array.clone();

        SortingAlgorithm bubbleSort = new BubbleSort();
        sortingTimes[0] = measureSortingTime(bubbleSort, clonedArray);

        SortingAlgorithm insertionSort = new InsertionSort();
        sortingTimes[1] = measureSortingTime(insertionSort, clonedArray);

        SortingAlgorithm mergeSort = new MergeSort();
        sortingTimes[2] = measureSortingTime(mergeSort, clonedArray);

        SortingAlgorithm quickSort = new QuickSort();
        sortingTimes[3] = measureSortingTime(quickSort, clonedArray);

        return sortingTimes;
    }

    private long measureSortingTime(SortingAlgorithm sortingAlgorithm, int[] array) {
        long startTime = System.currentTimeMillis();
        sortingAlgorithm.sort(array);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
