package Java_Core.Module_4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.*;


public class Reflexion {
}

class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("java.awt.Dimension");

            System.out.println("Koнcтpyктopы:");
            Constructor[] constructors = c.getConstructors();
            for (int i = 0; i < constructors.length; i++) {
                System.out.println(" " + constructors[i]);
            }

            System.out.println("Пoля:");
            Field[] fields = c.getFields();
            for (int i = 0; i < fields.length; i++) {
                System.out.println(" " + fields[i]);
            }

            System.out.println("Meтoды:");
            Method[] methods = c.getMethods();
            for (int i = 0; i < methods.length; i++) {
                System.out.println(" " + methods[i]);
            }
        } catch (Exception exception) {
            System.out.println("Исключение: " + exception);
        }
    }
}

//получение аннотации

// Объявление типа аннотации
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String message();

    int value();
}

class AnnotationDemo {
    // аннотировать метод
    @MyAnnotation(message = "Пример аннотации", value = 42)
    public static void demoMethod() {

        AnnotationDemo ob = new AnnotationDemo();
        // получить аннотацию из метода
        // и вывести значения ее членов
        try {
            // сначала получить объект типа Class,
            // представляющий данный класс
            Class<?> сlazz = ob.getClass();
            // затем получить объект типа Method,
            // представляющий данный метод
            Method demoMethod = сlazz.getMethod("demoMethod");
            // далее получить аннотацию для данного класса
            MyAnnotation annotation = demoMethod.getAnnotation(MyAnnotation.class);
            // и наконец, вывести значения членов аннотации
            System.out.println(annotation.message() + " " + annotation.value());
        } catch (NoSuchMethodException ех) {
            System.out.println("Meтoд не найден: " + ех);
        }
    }

    public static void main(String[] args) {
        demoMethod();
    }
}
