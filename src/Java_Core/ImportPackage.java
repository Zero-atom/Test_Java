package Java_Core;
//для полчения доступа к классам надо подключить нужный пакет (исключения базовые типа java.lang (например, String))
import java.util.Scanner; // импорт класса Scanner

//либо
import java.util.*; // импорт всех классов из пакета java.util

//два разных пакета с одним класом выдадут ошибку 'java.util.Date' is already defined in a single-type import (решение сипользовать второй класс с полным именем)
import java.util.Date;
//import java.sql.Date;

//Статический импорт
import static java.lang.System.*;
import static java.lang.Math.*;

public class ImportPackage {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //два разных класса в пакетах
        java.util.Date utilDate = new java.util.Date();
        //java.sql.Date sqlDate = new java.sql.Date();

        //Статический импорт
        //позволяет использовать метод без экземпляра класса
        double result = sqrt(20);
        out.println(result);
    }
}

