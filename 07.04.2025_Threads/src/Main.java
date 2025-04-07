public class Main {
    public static void main(String[] args) {
        Runnable barrierEvent = () -> System.out.println("Barrier event");

        CyclicBarrierCustom barrierCustom = new CyclicBarrierCustom(4, barrierEvent);
        MyRunnable myRunnable = new MyRunnable(barrierCustom);

        for(int i = 0; i < 4; i++) {
            Thread thread = new Thread(myRunnable, "Thread " + i);
            thread.start();
        }
    }
}