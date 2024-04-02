package Java_Core.Module_2;

public class StringObject {
    public static void main(String[] args) {
        //При работе со строками важно понимать, что объект String является неизменяемым (immutable).
        // То есть при любых операциях над строкой, которые изменяют эту строку, фактически будет создаваться новая строка.

        String str1 = "Java";//строковые литералы
        String str2 = new String("Java"); // пустая строка
        String str3 = new String(new char[] {'h', 'e', 'l', 'l', 'o'}); //строковые объекты
        String str4 = new String(new char[]{'w', 'e', 'l', 'c', 'o', 'm', 'e'}, 3, 4);//3 -начальный индекс, 4 -кол-во символов

        System.out.println(str1); // Java
        System.out.println(str2); //
        System.out.println(str3); // hello
        System.out.println(str4); // come

        //После Java 7 строки хранятся в специальном пространстве в Heap (куча) - String Pool (пул строк)
        //где периодически происходит очистка памяти при помощи Garbage Collector

        //Поскольку строка рассматривается как набор символов, то мы можем применить метод length() для нахождения длины строки или длины набора символов:
        //concat(): объединяет строки
        //valueOf(): преобразует объект в строковый вид
        //join(): соединяет строки с учетом разделителя
        //сompareTo(): сравнивает две строки
        //charAt(): возвращает символ строки по индексу
        //getChars(): возвращает группу символов
        //equals(): сравнивает строки с учетом регистра
        //equalsIgnoreCase(): сравнивает строки без учета регистра
        //regionMatches(): сравнивает подстроки в строках
        //indexOf(): находит индекс первого вхождения подстроки в строку
        //lastIndexOf(): находит индекс последнего вхождения подстроки в строку
        //startsWith(): определяет, начинается ли строка с подстроки
        //endsWith(): определяет, заканчивается ли строка на определенную подстроку
        //replace(): заменяет в строке одну подстроку на другую
        //trim(): удаляет начальные и конечные пробелы
        //substring(): возвращает подстроку, начиная с определенного индекса до конца или до определенного индекса
        //toLowerCase(): переводит все символы строки в нижний регистр
        //toUpperCase(): переводит все символы строки в верхний регистр

        String first = "Waveaccess";
        String second = "Waveaccess";
        String st6 = new String("Waveaccess");
        String st7 = new String("Waveaccess");
        System.out.println(first == second); // true
    }
}
