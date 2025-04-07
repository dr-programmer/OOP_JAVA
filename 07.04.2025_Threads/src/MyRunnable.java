public class MyRunnable implements Runnable {
    private CyclicBarrierCustom barrier;

    public MyRunnable(CyclicBarrierCustom barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is starting");
            Thread.sleep(100L);
            System.out.println("Common point for the barrier " + Thread.currentThread().getName());
            barrier.await();
            System.out.println("Passed barrier");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
