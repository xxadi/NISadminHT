package me.zhengjie.yuangan.test.factory;

public class Consumer {
    public static void main(String[] args) {
        Car hq =  new CarFactory().getHongQi();
        hq.getName();
        Car tsl = CarFactory.getTesla();
        tsl.getName();
    }
}
