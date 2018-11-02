package com.myplay.eventprogram.before9;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.EventListener;
import java.util.EventObject;

/**
 * 事件监听demo
 *
 * {@link java.util.EventObject} 标准事件对象
 * {@link EventListener} 标准的事件监听对象
 * @author baihe
 * @Date: 2018/10/31 14:13
 *
 */
public class EventListenerDemo {

    public static void main(String[] args) {
        Person person=new Person();
        //PropertyChangeEvent changeEvent = new PropertyChangeEvent(person,"name",null,"test");
        PropertyChangeSupport changeSupport=new PropertyChangeSupport(person);
        changeSupport.addPropertyChangeListener("name",(event)->{
            System.out.println("new value----->"+event.getNewValue());
            System.out.println("old value----->"+event.getOldValue());
        });

        changeSupport.firePropertyChange("name",null,"nihao");

    }


    /**
     *pojo getter/setter
     */
    private static class Person{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
