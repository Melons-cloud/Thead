package com.hemukeji.demo1;


//实现Runnable接口，实现线程，重写run方法，执行线程，丢入Runnable接口实现类
public class TestThread3 implements Runnable{


    @Override
    public void run() {
        for (int i=0;i<200;i++){

            System.out.println("我在看代码---"+i);
        }
    }
    public static void main(String[] args) {

        //创建Runnable接口实现类
        TestThread3 testThread3 = new TestThread3();
        new Thread(testThread3).start();



        for (int i=0;i<1000;i++){

            System.out.println("我在学习多线程"+i);
        }

    }

}
