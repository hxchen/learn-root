package com.a3fun.learn.concurrency.thread_communication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier可以在构造时指定需要在屏障前执行await的个数，所有对await的调用都会等待，直到调用await的次数达到预定指，所有等待都会立即被唤醒。
 *
 * 从使用场景上来说，CyclicBarrier是让多个线程互相等待某一事件的发生，然后同时被唤醒。而上文讲的CountDownLatch是让某一线程等待多个线程的状态，然后该线程被唤醒。
 * @author haixiangchen
 */
public class CyclicBarrierDemo1 {

    static class Athlete implements Runnable {

        private CyclicBarrier cyclicBarrier;
        private String name;

        public Athlete(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "就位");
            try {
                cyclicBarrier.await();
                Random random =new Random();
                double time = random.nextDouble() + 9;
                System.out.println(name + ": "+ time);
            } catch (Exception e) {
            }
        }
    }
    static class Race {
        public Race(){}
        private CyclicBarrier cyclicBarrier = new CyclicBarrier(8);

        public void start() {
            List<Athlete> athleteList = new ArrayList<>();
            athleteList.add(new Athlete(cyclicBarrier, "博尔特"));
            athleteList.add(new Athlete(cyclicBarrier, "鲍威尔"));
            athleteList.add(new Athlete(cyclicBarrier, "盖伊"));
            athleteList.add(new Athlete(cyclicBarrier, "布雷克"));
            athleteList.add(new Athlete(cyclicBarrier, "加特林"));
            athleteList.add(new Athlete(cyclicBarrier, "苏炳添"));
            athleteList.add(new Athlete(cyclicBarrier, "路人甲"));
            athleteList.add(new Athlete(cyclicBarrier, "路人乙"));
            Executor executor = Executors.newFixedThreadPool(8);
            for (Athlete athlete : athleteList) {
                executor.execute(athlete);
            }
        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        race.start();
    }
}
