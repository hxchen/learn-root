package com.a3fun.learn.java.zulong;


public final class Task extends Thread implements Comparable {
    private int id;

    public Task(int id, int priority) {
        this.id = id;
        setPriority(priority);
    }


    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName() + "正在处理优先级：" + getPriority() + "的任务");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Object o) {
        return this.id - ((Task)o).id;
    }
}
