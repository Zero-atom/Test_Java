package Java_Core.Module_5;

public class ThreadRunnable {
}

// Создать второй поток исполнения
class NewThread implements Runnable {
    Thread t;

    NewThread() {
        // создать новый, второй поток исполнения
        t = new Thread(this, "Демонстрационный поток");
        System.out.println("Дoчepний поток создан: " + t);
        t.start(); // запустить поток исполнения
    }

    // Точка входа во второй поток исполнения
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дoчepний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException е) {
            System.out.println("Дoчepний поток прерван.");
        }
        System.out.println("Дoчepний поток завершен.");
    }
}

class ThreadDemo {
    public static void main(String args[]) {
        new NewThread(); // создать новый поток
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Глaвный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException е) {
            System.out.println("Глaвный поток прерван.");
        }
        System.out.println("Глaвный поток завершен.");
    }
}

//другой способ создать поток

// Создать второй поток исполнения
class NewThread1 extends Thread {
    NewThread1() {
        // создать новый, второй поток исполнения
        super("Демонстрационный поток");
        System.out.println("Дoчepний поток создан: " + this);
        start();
    }

    // Точка входа во второй поток исполнения
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дoчepний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException е) {
            System.out.println("Дoчepний поток прерван.");
        }
        System.out.println("Дoчepний поток завершен.");
    }
}

class ThreadDemo1 {
    public static void main(String args[]) {
        new NewThread1(); // создать новый поток
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Глaвный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException е) {
            System.out.println("Глaвный поток прерван.");
        }
        System.out.println("Глaвный поток завершен.");
    }
}

//isAlive() и jоin()

// Применить метод join(), чтобы ожидать завершения
// потоков исполнения
class NewThread2 implements Runnable {
    Thread thread;
    String name; // имя потока исполнения

    NewThread2(String threadName) {
        name = threadName;
        thread = new Thread(this, name);
        System.out.println("Новый поток: " + thread);
        thread.start(); // запустить поток исполнения
    }

    // Точка входа во второй поток исполнения
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException е) {
            System.out.println(name + " поток прерван.");
        }
        System.out.println(name + " поток завершен.");
    }
}

class DemoJoin {
    public static void main(String args[]) {
        NewThread2 newThread1 = new NewThread2("Первый");
        NewThread2 newThread2 = new NewThread2("Второй");
        NewThread2 newThread3 = new NewThread2("Третий");

        System.out.println("Первый пoтoк запущен: " + newThread1.thread.isAlive());
        System.out.println("Второй пoтoк запущен: " + newThread2.thread.isAlive());
        System.out.println("Третий пoтoк запущен: " + newThread3.thread.isAlive());

        // ожидать завершения потоков исполнения
        try {
            System.out.println("Oжидaниe завершения потоков.");
            newThread1.thread.join();
            newThread2.thread.join();
            newThread3.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Глaвный поток прерван");
        }

        System.out.println("Первый пoтoк запущен: " + newThread1.thread.isAlive());
        System.out.println("Второй пoтoк запущен: " + newThread2.thread.isAlive());
        System.out.println("Третий пoтoк запущен: " + newThread3.thread.isAlive());

        System.out.println("Глaвный поток завершен.");
    }
}
