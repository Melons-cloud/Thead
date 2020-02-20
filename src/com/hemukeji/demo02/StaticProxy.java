package com.hemukeji.demo02;

public class StaticProxy {

    public static void main(String[] args) {

        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }

}

interface Marry{

    void HappyMarry();
}

//真实角色
class You implements Marry{

    @Override
    public void HappyMarry(){

        System.out.println("结婚了，超开心");
    }
}


//代理角色,帮助你结婚
class WeddingCompany implements Marry{

    private Marry target;

    //构造方法
    public WeddingCompany(Marry target){
        this.target=target;
        
    }
    @Override
    public void HappyMarry() {

        before();
        this.target.HappyMarry();
        after();

    }

    private void after() {

        System.out.println("结婚之后，收尾款");

    }

    private void before() {

        System.out.println("结婚之前，布置现场");
    }
}
