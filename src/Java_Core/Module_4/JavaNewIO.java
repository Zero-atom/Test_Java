package Java_Core.Module_4;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class JavaNewIO {
}

class PathDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C://Users//Denis.Iskhakov//IdeaProjects//Test//src//Java_Core//Module_4//Java//COPYRIGHT.txt");
        FileSystem fs = path.getFileSystem();
        System.out.println(fs);
        System.out.println(path.isAbsolute());
        System.out.println(path.getFileName());
        System.out.println(path.toAbsolutePath());
        System.out.println(path.getRoot());
        System.out.println(path.getParent());
        // Возвращает количество элементов в пути
        System.out.println(path.getNameCount());
        System.out.println(path.getName(0));
        System.out.println(path.subpath(0, 2));
        System.out.println(path);

        // Возвращает реальный путь существующего файла.
        Path realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
        System.out.println(realPath);
        String originalPath = "C://Users//Denis.Iskhakov//IdeaProjects//Test";
        Path path1 = Paths.get(originalPath);

        // Возвращает путь, который является этим путем с удаленными избыточными элементами имени ("." и "..")
        Path path2 = path1.normalize();
        System.out.println("path2 = " + path2);

        //files
        Path rootPath = Paths.get("data");
        String fileToFind = File.separator + "README.txt";

        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileString = file.toAbsolutePath().toString();
                    // System.out.println("pathString = " + fileString);

                    if (fileString.endsWith(fileToFind)) {
                        System.out.println("Нашли файл по пути: " + file.toAbsolutePath());
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

//files
