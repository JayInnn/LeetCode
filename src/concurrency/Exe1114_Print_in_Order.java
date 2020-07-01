package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/7/1
 * @description:
 * @result:
 */
public class Exe1114_Print_in_Order {
    private BlockingQueue<Integer> one = new ArrayBlockingQueue<>(1);
    private BlockingQueue<Integer> two = new ArrayBlockingQueue<>(1);

    public Exe1114_Print_in_Order() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.one.offer(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        this.one.poll();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        this.two.offer(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        this.two.poll();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args){
        Exe1114_Print_in_Order foo = new Exe1114_Print_in_Order();

        Runnable t1 = new Runnable() {
            @Override
            public void run(){
                System.out.print("one");
            }
        };

        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                System.out.print("two");
            }
        };

        Runnable t3 = new Runnable() {
            @Override
            public void run(){
                System.out.print("three");
            }
        };
        try {
            foo.first(t1);
            foo.second(t2);
            foo.third(t3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
