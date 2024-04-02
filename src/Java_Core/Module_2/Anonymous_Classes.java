package Java_Core.Module_2;

public class Anonymous_Classes {
}

class Cat {

    public void voice() {
        System.out.println("Meow!");
    }
}

class Animal {
    public static void main(String[] args) {
        Cat cat = new Cat() {//  { - начало реализации подкласса
            @Override
            public void voice() {
                System.out.println("Meow in anonymous class!");
            }
        };
        cat.voice();
    }
}
