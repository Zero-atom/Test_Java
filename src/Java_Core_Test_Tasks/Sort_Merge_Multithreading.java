package Java_Core_Test_Tasks;

import java.util.Arrays;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import java.util.concurrent.*;

public class Sort_Merge_Multithreading {
}

//без многопоточности
class MergeSort {

    public static void main(String[] params) {
        int[] array = new int[] {10,60,20,50,40,30};//15,78,89,9,12,12546,8,879,16,54,1
        System.out.println(arrayToString(array));
        array = mergeSort(array);
        System.out.println(arrayToString(array));
    }

    public static int[] mergeSort(int[] array) {
        int[] tmp;//временный для смены местами
        int[] currentSrc = array;//источник
        int[] currentDest = new int[array.length];//приемник куда будем сливать после слияния

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            //меняем местами
            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;

            System.out.println(arrayToString(currentSrc));
        }
        return currentSrc;
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start,
                              int[] dest, int destStart, //куда будем сдивать подмассивы
                              int size) {

        int index1 = src1Start; // с какого элемента начать слияние
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);// концы подмассивов
        int src2End = Math.min(src2Start + size, src2.length);

        if (src1Start + size > src1.length) {
            for (int i = src1Start; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }

        int iterationCount = src1End - src1Start + src2End - src2Start;// кол-во итераций для слияния

        //слияние подмасивов в dest
        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}

//многопоточность


class ParallelMergeSort {

//    public static void main(String[] args) {
//        int[] arr = {10,60,20,50,40,30};
//        merge(arr, Runtime.getRuntime().availableProcessors());
//        System.out.println("Sorted array: " + Arrays.toString(arr));
//    }


}




