package Java_Core.Module_2;

public class Module_2_arrays {
    // Массив - это группа однотипных переменных, для обращения к которым используется общее имя.
    // Допускается создание массивов любого типа и разной размерности. Доступ к конкретному элементу массива осуществляется по его индексу.
    //массивы
    public static void main(String args[]) {
        int[] nums = new int [4];
        int[] nums1 = new int[] {1,2,3,4};
        int[] nums2 =  {1,2,3,4};
        int[][] nums3 = {{1,2,3,4},{1, 2, 3, 4}};
        System.out.println(nums3);
        System.out.println(nums3.length);
        int[][] nums4 = new int[3][];//зубчатый массиы
        nums4[0] = new int[2];
        nums4[1] = new int[3];
        //перебор массива
        for (int num : nums2) {
            System.out.println(num);
        }
    }
}

// Вычисление среднего из массива значений
class Average {
    public static void main(String args[]) {
        double nums[] = {10.1, 11.2, 12.3, 13.4, 14.5};
        double result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        System.out.println("Среднее значение равно " + result / nums.length);
    }
}

//Многомерные массивы
class ThreeDMatrix {
    public static void main(String args[]) {
        int[][][] threeD = new int[3][4][5];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++)
                for (int k = 0; k < 5; k++)
                    threeD[i][j][k] = i * j * k;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(threeD[i][j][k] + " ");
                }
                System.out.println();
            }
    }
}