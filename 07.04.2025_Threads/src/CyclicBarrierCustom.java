public class CyclicBarrierCustom {
    private int parties;
    private Runnable event;
    private int finished = 0;

    public CyclicBarrierCustom(int parties, Runnable event) {
        this.parties = parties;
        this.event = event;
    }

    public synchronized void await() throws InterruptedException {
        finished++;

        if(finished == parties) {
            event.run();
            this.notifyAll();
            finished = 0;
        } else {
            this.wait();
        }
    }
}
