package Java_Core_Test_Tasks;
import java.util.Arrays;

public class Sort_Merge_Multithreading {
}

class ParallelMergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        parallelMergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void parallelMergeSort(int[] arr) {
        if (arr.length <= 1)
            return;

        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        Thread leftSorter = new Thread(() -> parallelMergeSort(left));
        Thread rightSorter = new Thread(() -> parallelMergeSort(right));

        leftSorter.start();
        rightSorter.start();

        try {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}

