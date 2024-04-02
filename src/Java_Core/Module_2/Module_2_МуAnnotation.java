package Java_Core.Module_2;

public class Module_2_МуAnnotation {
    public static void main(String[] args) {
        String s1 = "string";
        String s2 = "left" + s1;
        String s3 = "leftstring";
        System.out.println(s3.equals(s2));
        int i=1;


//        public static void print(List<? extends Number> list) {
//            for (Number n : list)
//                System.out.print(n + " ");
//            System.out.println();
//        }
    }

}

// Простой тип аннотации
@interface MyAnnotation {
    String message();

    int value();

//    @MyAnnotation(message = "Пример аннотации", value = 42)
//    public static void demoMethod() { };
}


