package Java_Core; //примеры встроенных пакетов java.lang, java.util, java.io
//Принадлежность класса к пакету позволяет гарантировать однозначность имен.

public class Program{ // после компиляции в out ,  в папке Java_Core появятся скомпилированные файлы Program.class и Person.class

    public static void main(String[] args) {

        Person kate = new Person("Kate", 32);
        kate.displayInfo();
    }
}
class Person{

    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    void displayInfo(){
        System.out.printf("Name: %s \t Age: %d \n", name, age);
    }
}

