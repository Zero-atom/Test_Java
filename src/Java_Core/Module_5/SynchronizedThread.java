package Java_Core.Module_5;

public class SynchronizedThread {
}



class CallMe {
    synchronized void call(String msg) { ///synchronized
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прервано:" + e);
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    CallMe target;
    Thread thread;

    public Caller(CallMe target, String s) {
        this.target = target;
        msg = s;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        target.call(msg);
        //альтернатива
//        synchronized (target) {
//            target.call(msg);
//        }
    }


}

class DemoSync {
    public static void main(String args[]) {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target, "Добро пожаловать");
        Caller ob2 = new Caller(target, "в синхронизированный");
        Caller ob3 = new Caller(target, "мир!");

        try {
            ob1.thread.join();
            ob2.thread.join();
            ob3.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Прервано:" + e);
        }
    }
}
