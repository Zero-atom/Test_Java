package Java_Core.Module_5;

import java.util.concurrent.*;


public class InterfaceCallable {
}


class Sum implements Callable<Integer> {
    int stop;

    Sum(int v) {
        stop = v;
    }

    public Integer call() {
        int sum = 0;
        for (int i = 1; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}


class Hypotenuse implements Callable<Double> {
    double side1, side2;

    Hypotenuse(double sl, double s2) {
        side1 = sl;
        side2 = s2;
    }

    public Double call() {
        return Math.sqrt((side1 * side1) + (side2 * side2));
    }
}

class Factorial implements Callable<Integer> {
    int stop;

    Factorial(int v) {
        stop = v;
    }

    public Integer call() {
        int fact = 1;
        for (int i = 2; i <= stop; i++) {
            fact *= i;
        }
        return fact;
    }
}

class ExecutorDemo {
    public static void main(String args[]) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> f1;
        Future<Double> f2;
        Future<Integer> f3;

        System.out.println("Запуск");

        f1 = es.submit(new Sum(10));
        f2 = es.submit(new Hypotenuse(3, 4));
        f3 = es.submit(new Factorial(5));

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }

        System.out.println("Завершение");

        es.shutdown();
    }
}
