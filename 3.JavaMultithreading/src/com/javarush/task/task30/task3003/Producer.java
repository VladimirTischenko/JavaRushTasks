package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by Vladimir on 22.03.2017.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.format("Элемент ‘ShareItem-%d‘ добавлен\n", i);
            queue.offer(new ShareItem("ShareItem-" + i, i));
        }
    }
}
