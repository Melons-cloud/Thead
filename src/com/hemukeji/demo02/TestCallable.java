package com.hemukeji.demo02;


import com.hemukeji.demo01.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//线程创建，实现Callable接口
public class TestCallable implements Callable<Boolean> {

    private String url;//网络图片地址
    private String name;


    public TestCallable(String url,String name){

        this.url=url;
        this.name=name;
    }
    @Override
    public Boolean call(){

       WebDownloader webDownloader =new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为:"+name);
        return true;

    }
    public static void main(String[] args) throws ExecutionException,InterruptedException {


        TestCallable t1 =new TestCallable("https://blog.kuangstudy.com/usr/uploads/2019/10/3278965235.png","1.jpg");
        TestCallable t2 =new TestCallable("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582214272633&di=e8765d1493083ebbae9aaaef0c37a610&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180209%2Ff4734a37574746da8a7c27906e77eaa5.jpeg","2.jpg");
        TestCallable t3 =new TestCallable("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582214272632&di=ad274a869bab08456ffca0fa6bbdae13&imgtype=0&src=http%3A%2F%2Fimg.qzcns.com%2F2018%2F0521%2F20180521092124931.jpg","3.jpg");
        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        boolean rs1=r1.get();
        boolean rs2=r1.get();
        boolean rs3=r1.get();

        //关闭服务
        ser.shutdownNow();





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
