package Java_Core.Module_4_Key_Mechanisms;

import java.io.File;

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
        FilenameFilter txtFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        // Получаем список файлов, отфильтрованных по расширению ".txt"
        File[] txtFiles = directory.listFiles(txtFilter);

        // Выводим список отфильтрованных файлов
        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println(file.getName());
            }
        }
    }
}
