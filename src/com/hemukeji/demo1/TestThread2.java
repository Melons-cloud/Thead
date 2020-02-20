package com.hemukeji.demo1;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
//Runnable接口，一个线程跑多个对象。Thread类，一个线程跑一个对象
//Thread，实现多线程同步下载图片
public class TestThread2 implements Runnable {

    private String url;//网络图片地址
    private String name;


    public TestThread2(String url,String name){

        this.url=url;
        this.name=name;
    }
    @Override
    public void run(){

        WebDownloader webDownloader =new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为:"+name);

    }
    public static void main(String[] args) {


        TestThread2 t1 =new TestThread2("https://blog.kuangstudy.com/usr/uploads/2019/10/3278965235.png","1.jpg");
        TestThread2 t2 =new TestThread2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582214272633&di=e8765d1493083ebbae9aaaef0c37a610&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180209%2Ff4734a37574746da8a7c27906e77eaa5.jpeg","2.jpg");
        TestThread2 t3=new TestThread2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582214272632&di=ad274a869bab08456ffca0fa6bbdae13&imgtype=0&src=http%3A%2F%2Fimg.qzcns.com%2F2018%2F0521%2F20180521092124931.jpg","3.jpg");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();



    }


    class WebDownloader{

        //下载方法
        public void downloader( String url,String name){


            try {
                FileUtils.copyURLToFile(new URL(url),new File(name));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO异常,downloader方法出现问题");
            }

        }


    }


}
