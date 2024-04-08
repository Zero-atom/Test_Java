package Java_Core_Test_Tasks;

import java.util.concurrent.*;

//без многопоточности
public class SortMerge {
    public static void main(String[] params) {
        int[] array = new int[] {10, 60, 20, 50, 40, 30};
        System.out.println("До сортировки: " +arrayToString(array));

        long startTime = System.nanoTime(); // Засекаем начальное время

        array = sortArray(array);

        long endTime = System.nanoTime(); // Засекаем конечное время
        long duration = (endTime - startTime) / 1000000; // Вычисляем время выполнения в миллисекундах

        System.out.println("После сортировки: " + arrayToString(array));
        System.out.println("Время выполнения: " + duration + " milliseconds");
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

    public static int [] sortArray(int[] arrayA){ // сортировка Массива который передается в функцию
        // проверяем не нулевой ли он?
        if (arrayA == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (arrayA.length < 2) {
            return arrayA; // возврат в рекурсию в строки ниже см комменты.
        }
        // копируем левую часть от начала до середины
        int [] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии строкой return arrayA;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии строкой return arrayA;

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayB, arrayC);

    }

    public static int[] mergeArray(int[] arrayA, int[] arrayB) {
        // Создаём новый массив для объединённых значений с размером, равным сумме размеров arrayA и arrayB
        int[] arrayC = new int[arrayA.length + arrayB.length];

        // Инициализируем переменные для отслеживания текущей позиции в массивах arrayA и arrayB
        int positionA = 0, positionB = 0;

        // Проходим по всем элементам массива arrayC
        for (int i = 0; i < arrayC.length; i++) {
            // Проверяем, достигли ли мы конца массива arrayA
            if (positionA == arrayA.length) {
                // Если достигли, значит все элементы из arrayA уже добавлены в arrayC,
                // поэтому можем добавлять элементы из arrayB
                arrayC[i] = arrayB[positionB];
                positionB++; // Переходим к следующему элементу в массиве arrayB
            }
            // Проверяем, достигли ли мы конца массива arrayB
            else if (positionB == arrayB.length) {
                // Если достигли, значит все элементы из arrayB уже добавлены в arrayC,
                // поэтому можем добавлять элементы из arrayA
                arrayC[i] = arrayA[positionA];
                positionA++; // Переходим к следующему элементу в массиве arrayA
            }
            // Сравниваем текущие элементы arrayA и arrayB и добавляем минимальный в arrayC
            else if (arrayA[positionA] < arrayB[positionB]) {
                arrayC[i] = arrayA[positionA];
                positionA++; // Переходим к следующему элементу в массиве arrayA
            } else {
                arrayC[i] = arrayB[positionB];
                positionB++; // Переходим к следующему элементу в массиве arrayB
            }
        }

        // Возвращаем объединённый и отсортированный массив arrayC
        return arrayC;
    }
}


class ParallelSortMerge {
    public static void main(String[] params) {

        int[] array = new int[] {10, 60, 20, 50, 40, 30};
        System.out.println("До сортировки: " +arrayToString(array));

        long startTime = System.nanoTime(); // Засекаем начальное время

        array = sortArray(array);

        long endTime = System.nanoTime(); // Засекаем конечное время
        long duration = (endTime - startTime) / 1000000; // Вычисляем время выполнения в миллисекундах

        System.out.println("После сортировки: " + arrayToString(array));
        System.out.println("Время выполнения: " + duration + " milliseconds");
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

    public static int[] sortArray(int[] arrayA) {
        if (arrayA == null) {
            return null;
        }
        if (arrayA.length < 2) {
            return arrayA;
        }
        int[] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        int[] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        // Создаем пул потоков
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Создаем задачи для сортировки левой и правой частей массива
        Future<int[]> futureB = executor.submit(() -> sortArray(arrayB));
        Future<int[]> futureC = executor.submit(() -> sortArray(arrayC));

        int[] sortedB = null;
        int[] sortedC = null;
        try {
            // Получаем отсортированные части массивов
            sortedB = futureB.get();
            sortedC = futureC.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Завершаем работу пула потоков
        executor.shutdown();

        // Сливаем отсортированные части массивов
        return mergeArray(sortedB, sortedC);
    }

    public static int[] mergeArray(int[] arrayA, int[] arrayB) {
        int[] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayA.length) {
                arrayC[i] = arrayB[positionB++];
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[positionA++];
            } else if (arrayA[positionA] < arrayB[positionB]) {
                arrayC[i] = arrayA[positionA++];
            } else {
                arrayC[i] = arrayB[positionB++];
            }
        }
        return arrayC;
    }
}

