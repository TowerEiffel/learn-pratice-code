package com.myplay.eventprogram.before9;

import java.util.Observable;

/**
 * java9之前的事件驱动
 *
 * @author baihe
 * @Date: 2018/10/31 13:50
 */
public class ObserverDemo {

    public static void main(String[] args) {
        //用vector做存储，线程安全，使用的是倒叙
        //没有实现泛型，原因是 在1.5之前就存在了，至于为啥官方没有把它升级就不得而知了
        //同步
        MyObs obs=new MyObs();//构建观察对象

        //增加第一个观察者
        obs.addObserver((ob,value)->{
            System.out.println("1、收到的参数：----->"+value);
        });

        //增加第二个观察者
        obs.addObserver((ob,value)->{
            System.out.println("2、收到的参数：----->"+value);
        });

        //设置改变的值
        obs.setChanged();


        //通知
        obs.notifyObservers(123456);
    }

    static class MyObs extends Observable{
        @Override
        public void setChanged() {
            super.setChanged();
        }
    }
}


