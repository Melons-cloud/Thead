package com.hemukeji.demo1;


//多个线程操作同一对象

//火车票的例子

//多个线程操作同一对象，线程不安全，会发生多个人抢到同一张票
public class TestThread4 implements Runnable{

    //票数
    private int ticketNums=10;



    @Override
    public void run() {


        while (true){

            if (ticketNums<0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNums--+"张票");
        }

    }

    public static void main(String[] args) {

        TestThread4 testThread4 = new TestThread4();
        new Thread(testThread4,"程序员").start();
        new Thread(testThread4,"老师").start();
        new Thread(testThread4,"学生").start();


    }
}
