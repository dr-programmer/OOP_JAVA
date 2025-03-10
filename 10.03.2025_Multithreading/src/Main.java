import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread(0); // state NEW
        thread.run(); // state RUNNABLE

        Thread thread1 = new Thread(new MyThread(1), "Task1");
        System.out.println(thread1.getState());
        Thread thread2 = new Thread(new MyThread(2), "Task2");
        Thread thread3 = new Thread(new MyThread(3), "Task3");

        thread3.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println(thread3.getState());

        try {
            System.out.println(thread2.getState());
            thread2.join();
            System.out.println(thread2.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t1 = new Thread(thread, "Task1");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        System.out.println(t1.getName() + " " + " " + t1.getPriority());

        MyThread commonThread = new MyThread(11);
        Thread commonThread1 = new Thread(commonThread, "Task1");
        Thread commonThread2 = new Thread(commonThread, "Task2");
        Thread commonThread3 = new Thread(commonThread, "Task3");

        commonThread1.start();
        commonThread2.start();
        commonThread3.start();

        try {
            commonThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(commonThread.getCounter());
    }
}