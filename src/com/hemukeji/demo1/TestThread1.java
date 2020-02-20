package com.hemukeji.demo1;

//线程开启不一定立即执行，由CPU调度执行。由run()方法先执行，无随机执行。
//创建线程的方式:继承Thread类，重写run()方法,调用start()方法开启线程
public class TestThread1  extends Thread{

    @Override
    public void run(){

      //run方法，线程体

        for (int i=0;i<200;i++){

            System.out.println("我在看代码---"+i);
        }


    }

    public static void main(String[] args) {

        //main主线程

        TestThread1 testThread1 = new TestThread1();
        testThread1.start();

        for (int i=0;i<1000;i++){

            System.out.println("我在学习多线程"+i);
        }

    }
}
