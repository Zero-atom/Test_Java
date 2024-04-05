package Java_Core.Module_5;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperations {
}


class AtomicDemo {
    public static void main(String args[]) {
        new AtomicThread("А");
        new AtomicThread("В");
        new AtomicThread("C");
    }
}

// Общий ресурс
class Shared1 {
    static AtomicInteger atomicInteger = new AtomicInteger(0);
}

class AtomicThread implements Runnable {
    String name;
    Thread thread;

    AtomicThread(String n) {
        name = n;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        System.out.println("Зaпycк потока " + name);

        for (int i = 1; i < 3; i++) {
            System.out.println("Пoтoк " + name + " получено: " + Shared1.atomicInteger.getAndSet(i));
        }
    }
}
