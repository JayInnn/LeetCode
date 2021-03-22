package concurrency;

import java.util.concurrent.Semaphore;

public class Exe1115_Print_FooBar_Alternately {
    private int n;

    private final Semaphore fooSem = new Semaphore(1);
    private final Semaphore barSem = new Semaphore(0);

    public Exe1115_Print_FooBar_Alternately(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSem.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSem.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSem.release();
        }
    }
}
