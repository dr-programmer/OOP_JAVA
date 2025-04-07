public class CountDownLatchCustom {
    private int count;

    public CountDownLatchCustom(int count) {
        this.count = count;
    }

    public synchronized void countDown() {
        count--;
        if (count == 0) this.notify();
    }

    public synchronized void await() throws InterruptedException {
        if (count > 0) this.wait();
    }
}
