package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/7/1
 * @description:
 * @result:
 */
public class Producer_Consumer_model {

    private BlockingQueue<Integer> messageQueue = new ArrayBlockingQueue<>(10);

    public void producer(Integer message) {
        try {
            messageQueue.put(message);
            System.out.println("producing message =====>"+ message + "   message size = " + messageQueue.size());
            Thread.sleep(5);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consumer() {
        try {
            int message = messageQueue.take();
            System.out.println("consuming message =====>"+ message + "   message size = " + messageQueue.size());
            Thread.sleep(3);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void  main(String[] args) {
        Producer_Consumer_model model = new Producer_Consumer_model();
        int end = 50;
        Runnable producerOne = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; ; i++){
                    model.producer(i);
                }
            }
        };
        Runnable producerTwo = new Runnable() {
            @Override
            public void run() {
                for (int i = -1; ; i--){
                    model.producer(i);
                }
            }
        };
        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                for (;;){
                    model.consumer();
                }
            }
        };
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(producerOne);
        service.submit(producerTwo);
        service.submit(consumer);
    }
}
