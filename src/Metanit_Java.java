import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Metanit_Java {
    public static void main(String[] args) {
//        TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//         to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");
//        char ch = 102;
//        System.out.println(ch);
//
//        String Text = """
//                Мой дядя самых честных правил
//                когда в не шутку за не мог
//                он уважать себя заставил
//                и лучше выдумать не мог
//                """;
//        System.out.println(Text);
//
//        int x=6;
//        int y=7;
//        x= y++;
//        System.out.printf("x=%d, y=%d", x,y);
//
//        // ввод с консоли
//        Scanner in = new Scanner(System.in);
//        System.out.print("Input a number:");
//        int num = in.nextInt();
//
//        System.out.printf("Your number: %d \n", num);
//        in.close();

//        boolean a1 = (5 > 6) | (4 < 6); // 5 > 6 - false, 4 < 6 - true, поэтому возвращается true
//        boolean a2 = (5 > 6) || (4 > 6); // 5 > 6 - false, 4 > 6 - false, поэтому возвращается false
//        boolean a3 = (5 > 6) & (4 < 6); // 5 > 6 - false, поэтому возвращается false (4 < 6 - true, но не вычисляется)
//        boolean a4 = (50 > 6) && (4 / 2 < 3); // 50 > 6 - true, 4/2 < 3 - true, поэтому возвращается true
        // || && экономия времени

        //преобразование базовых типов данных
//         int a =4;
//         byte b = (byte)a;
//         System.out.println(b);
//
//         double a1 = 56.9998;
//         int b1 = (int)Math.round(a1);
//         System.out.println(b1);

        //условные конструкции
//        int z = 1>2 ? 3 : 4 ;
//        System.out.println(z);

        //циклы
        //массивы
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

        //методы
        hello();

        //параметры переснной длины
        //sumMas(1,2,4);

        try{
            int[] numbers = new int[3];
            numbers[2]=45;
            if (6>5) {
                throw new Exception("число много ");
            }
            System.out.println(numbers[4]);
        } catch (Exception ex) {// тип сиключения , имя перменной
            //Exception - базовый класс дляя всех иключений
            ex.printStackTrace();
        } finally {
            System.out.println("все равно");
        }
        System.out.println("конец");

    }

    static void hello() {
        System.out.println("хо");
    }

    static void sumMas (int ...nums) {
        int result =0 ;
        for (int n: nums)
            result +=n;
        System.out.println(result);
    }
}