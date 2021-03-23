package concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Exe1195_Fizz_Buzz_Multithreaded_Sem {
    private int n;

    private final Semaphore numSem = new Semaphore(1);
    private final Semaphore fizzSem = new Semaphore(0);
    private final Semaphore buzzSem = new Semaphore(0);
    private final Semaphore bothSem = new Semaphore(0);

    public Exe1195_Fizz_Buzz_Multithreaded_Sem(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i = i + 3) {
            if (i % 5 != 0) {
                fizzSem.acquire();
                printFizz.run();
                numSem.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i = i + 5) {
            if (i % 3 != 0) {
                buzzSem.acquire();
                printBuzz.run();
                numSem.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i = i + 15) {
            bothSem.acquire();
            printFizzBuzz.run();
            numSem.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numSem.acquire();
            boolean triple = (i % 3 == 0);
            boolean fifth = (i % 5 == 0);
            if (triple && fifth) {
                bothSem.release();
            } else if (triple) {
                fizzSem.release();
            } else if(fifth) {
                buzzSem.release();
            } else {
                printNumber.accept(i);
                numSem.release();
            }
        }
    }
}
