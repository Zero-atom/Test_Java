package Java_Core_Test_Tasks;

import java.io.IOException;
import java.util.function.Consumer;


//checked, unchecked
//checked - заранее проверяет код и не компилирует его пока есть ошибка

//unchecked - происходят от класса RuntimeException - только послк компиляции
//ArithmeticException возникает при делении на ноль
//ArrayIndexOutOfBoundsException возникает при попытке обратиться к ячейке за пределами массива.

public class Exception_Lambda_Expressions {
    public static void main(String[] args) {
        // Вызов метода с checked exception в лямбда-выражении
        //Consumer - функциональный интерфейс принимающий в данном случе String и ничего не возвращает
        //лямбда выражение реализует метод accept
        Consumer<String> checkedExceptionLambda = s -> {
            //отличие 1 - нужно указать try catch
            //из-за чего код более объемный
            try {
                throwIOException();
            } catch (IOException e) {
                System.err.println("Checked IOException  внутри лямбда выражения: " + e);
            }
        };

        // Вызов метода с unchecked exception в лямбда-выражении
        Consumer<String> uncheckedExceptionLambda = s -> {
            //отличие 1 - не нужно указать try catch
            throwUncheckedException();
        };

        // Вызов лямбда-выражений
        checkedExceptionLambda.accept("Checked Exception Lambda");
        uncheckedExceptionLambda.accept("Unchecked Exception Lambda");
    }

    // Метод, выбрасывающий IOException
    private static void throwIOException() throws IOException { //отличе 2 - нужно указать throws в сигнатруе метода
        throw new IOException("IOException");
    }
    // Метод, выбрасывающий unchecked exception
    private static void throwUncheckedException() {
        throw new RuntimeException("Unchecked Exception");
    }
}





