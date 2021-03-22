package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Exe1115_Print_FooBar_Alternately_lock {
    private int n;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition fooCondition = lock.newCondition();
    private final Condition barCondition = lock.newCondition();
    private volatile int status = 0;

    public Exe1115_Print_FooBar_Alternately_lock(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            // printBar.run() outputs "bar". Do not change or remove this line.
            try {
                if (status != 0) {
                    fooCondition.await();
                }
                printFoo.run();
                status = 1;
                barCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            // printBar.run() outputs "bar". Do not change or remove this line.
            try {
                if (status != 1) {
                    barCondition.await();
                }
                printBar.run();
                status = 0;
                fooCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
