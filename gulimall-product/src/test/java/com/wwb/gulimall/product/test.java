package com.wwb.gulimall.product;

public class test {
    public static void main(String[] args) {
        System.out.println("begin");
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
        System.out.println("end===============");
    }
}
