package Java_Core.Module_5;
import java.util.concurrent.Semaphore;





class Shared {
    static int count = 0;
}

class IncrementThread implements Runnable {
    String name;
    Semaphore semaphore;
    Thread thread;

    public IncrementThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        this.thread = new Thread(this, this.name);
        this.thread.start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + this.name);

        try {
            // сначала получить разрешение
            System.out.println("Пoтoк " + name + " ожидает разрешения");
            semaphore.acquire();
            System.out.println("Пoтoк " + name + " получает разрешение");

            // а теперь получить доступ к общему ресурсу
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                //разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        // освободить разрешение
        System.out.println("Пoтoк " + name + " освобождает разрешение");
        semaphore.release();
    }
}

class DecrementThread implements Runnable {
    String name;
    Semaphore semaphore;
    Thread thread;

    public DecrementThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        this.thread = new Thread(this, this.name);
        this.thread.start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + this.name);

        try {
            // сначала получить разрешение
            System.out.println("Пoтoк " + name + " ожидает разрешения");
            semaphore.acquire();
            System.out.println("Пoтoк " + name + " получает разрешение");

            // а теперь получить доступ к общему ресурсу
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                //разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        // освободить разрешение
        System.out.println("Пoтoк " + name + " освобождает разрешение");
        semaphore.release();
    }
}

class SemaphoreJoin {
    public static void main(String args[]) {
        Semaphore semaphore = new Semaphore(1);
        new IncrementThread("А", semaphore);
        new DecrementThread("В", semaphore);
    }
}
