package Java_Core.Module_3;
import java.util.*;

public class ClassArrays {
}



class ArraysDemo {
    public static void main(String[] args) {
        int array[] = new int[10];
        for (int i = 0; i < 10; i++)
            array[i] = -3 * i;

        // вывести, отсортировать и снова вывести
        // содержимое массива
        System.out.print("Иcxoдный массив: ");
        display(array);
        Arrays.sort(array);
        System.out.print("Oтcopтиpoвaнный массив: ");
        display(array);

        // заполнить массив и вывести его содержимое
        Arrays.fill(array, 2, 6, -1);
        System.out.print("Maccив после вызова метода fill(): ");
        display(array);
        Arrays.sort(array);
        System.out.print("Maccив после повторной сортировки: ");
        display(array);

        // выполнить двоичный поиск значения -9
        System.out.print("Знaчeниe -9 находится на позиции ");
        int index = Arrays.binarySearch(array, -9);
        System.out.println(index);
    }

    static void display(int array[]) {
        for (int i : array)
            System.out.print(i + " ");
        System.out.println();
    }
}


