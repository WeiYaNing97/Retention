package com.retention.test.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JobThread extends Thread {

    // 用于计数线程是否执行完成
    CountDownLatch countDownLatch = null;
    ExecutorService executorService = null;

    // 为线程命名
    public JobThread(String name, CountDownLatch countDownLatch , ExecutorService executorService) {
        super(name);
        this.countDownLatch = countDownLatch;
        this.executorService = executorService;
    }

    @Override
    public void run() {
    // 如果主线程包含这个线程就一直运行
        while (MainThread.threadNameMap.containsKey(this.getName())) {
            try {
                System.out.println("线程名称：-----" + this.getName());
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("***************线程结束，线程名称：*********" + this.getName());

        MainThread.removeThread(this.getName());
        countDownLatch.countDown();
        //将exes转换为ThreadPoolExecutor,ThreadPoolExecutor有方法 getActiveCount()可以得到当前活动线程数
        int threadCount = ((ThreadPoolExecutor)executorService).getActiveCount();

        System.err.println("活跃线程数："+threadCount);
    }

}
