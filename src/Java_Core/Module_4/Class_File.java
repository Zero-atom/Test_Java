package Java_Core.Module_4;

import java.io.File;

//для потоков
import java.io.*;

public class Class_File {
}



class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String args[]) {
        File fl = new File("C:\\Users\\Denis.Iskhakov\\IdeaProjects\\Test\\src\\Java_Core\\Module_4_Key_Mechanisms\\Java\\COPYRIGHT.txt");
        p("Имя файла: " + fl.getName());
        p("Путь: " + fl.getPath());
        p("Абсолютный путь: " + fl.getAbsolutePath());
        p("pодительский каталог: " + fl.getParent());
        p(fl.exists() ? "существует" : "не существует");
        p(fl.canWrite() ? "доступен для записи" : "не доступен для записи");
        p(fl.canRead() ? "доступен для чтения" : "не доступен для чтения");
        p(fl.isDirectory() ? "является каталогом" : "не является каталогом");
        p(fl.isFile() ? "является обычным файлом" : "может быть именованным каналом");
        p(fl.isAbsolute() ? "является абсолютным" : "не является абсолютным");
        p("Последнее изменение в файле: " + fl.lastModified());
        p("pазмеp: " + fl.length() + " байт");

        //Фильтрация
        // Указываем путь к директории, которую будем фильтровать
        File directory = new File("/путь/к/директории");

        // Создаем экземпляр фильтра для файлов с расширением ".txt"
//        FilenameFilter txtFilter = new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.toLowerCase().endsWith(".txt");
//            }
//        };

        // Получаем список файлов, отфильтрованных по расширению ".txt"
        //File[] txtFiles = directory.listFiles(txtFilter);

//        // Выводим список отфильтрованных файлов
//        if (txtFiles != null) {
//            for (File file : txtFiles) {
//                System.out.println(file.getName());
//            }
        //}
    }
}

//закрытие потоков

//шаблон
//try {
//        // открыть файл и получить доступ к нему
//        } саtсh(исключение_ввода-вывода) {
//    // ...
//} finally {
//        // закрыть файл
//        }

class Program {

    public static void main(String[] args) {

        FileInputStream fin=null;
        try
        {
            fin = new FileInputStream("C://Users//Denis.Iskhakov//IdeaProjects//Test//src//Java_Core//Module_4//Java//COPYRIGHT.txt");

            int i=-1;
            while((i=fin.read())!=-1){

                System.out.print((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage()+" catch исключение ");
        }
        finally{

            try{

                if(fin!=null) {
                    fin.close();
                    System.out.println("\n поток закрыт");
                }
            }
            catch(IOException ex){

                System.out.println(ex.getMessage()+" finally исключение ");
            }
        }
    }
}

//try-with-resources (try-с-ресурсами)
//try(название_класса имя_переменной = конструктор_класса)

class ProgramTryWithResources {

    public static void main(String[] args) {

        try(FileInputStream fin=new FileInputStream("C://Users//Denis.Iskhakov//IdeaProjects//Test//src//Java_Core//Module_4//Java//COPYRIGHT.txt"))
        {
            int i=-1;
            while((i=fin.read())!=-1){

                System.out.print((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

//пример try-with-resources (try-с-ресурсами)
class FileInputStreamDemo {
    public static void main(String args[]) {
        int size;

        //Для автоматического закрытия потока ввода
        //используется оператор try с ресурсами
        try (FileInputStream f = new FileInputStream("C://Users//Denis.Iskhakov//IdeaProjects//Test//src//Java_Core//Module_4//Exceptions.java")) {
            System.out.println("Oбщee количество доступных байтов: " + (size = f.available()));
            int n = size / 40;

            System.out.println("Пepвыe " + n + " байтов прочитанных из файла по очереди методом read()");
            for (int i = 0; i < n; i++) {
                System.out.print((char) f.read());
            }

            System.out.println("\nBce еще доступно: " + f.available());
            System.out.println("Чтeниe следующих " + n + " байтов по очереди методом read(b[])");

            byte b[] = new byte[n];
            if (f.read(b) != n) {
                System.err.println("Heльзя прочитать " + n + " байтов.");
            }
            System.out.println(new String(b, 0, n));
            System.out.println("\nBce еще доступно: " + (size = f.available()));

            System.out.println("Пpoпycтить половину оставшихся байтов методом skip() ");
            f.skip(size / 2);
            System.out.println("Bce еще доступно: " + f.available());

            System.out.println("Чтeниe " + n / 2 + " байтов, размещаемых в конце массива");
            if (f.read(b, n / 2, n / 2) != n / 2) {
                System.err.println("Heльзя прочитать " + n / 2 + " байтов.");
            }

            System.out.println(new String(b, 0, b.length));
            System.out.println("\nBce еще доступно: " + f.available());
        } catch (IOException е) {
            System.out.println("Oшибкa ввода-вывода: " + е);
        }
    }
}
