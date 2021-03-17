package concurrency;

import java.util.concurrent.*;

public class Exe1117_Building_H2O {

    private final Semaphore hSam = new Semaphore(2);
    private final Semaphore oSam = new Semaphore(1);
    private final CyclicBarrier barrier = new CyclicBarrier(3);

    public Exe1117_Building_H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSam.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hSam.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSam.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        oSam.release();
    }
}
