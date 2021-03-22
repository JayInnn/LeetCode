package concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Exe1116_Print_Zero_Even_Odd {
    private int n;

    private final Semaphore zeroSem = new Semaphore(1);
    private final Semaphore evenSem = new Semaphore(0);
    private final Semaphore oddSem  = new Semaphore(0);

    public Exe1116_Print_Zero_Even_Odd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSem.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                oddSem.release();
            } else {
                evenSem.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 1) {
            evenSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            oddSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }
}
