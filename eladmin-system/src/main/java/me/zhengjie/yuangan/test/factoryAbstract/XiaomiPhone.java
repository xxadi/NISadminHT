package me.zhengjie.yuangan.test.factoryAbstract;

public class XiaomiPhone implements IPhoneProduct{
    @Override
    public void start() {
        System.out.println("小米手机开机");
    }

    @Override
    public void end() {
        System.out.println("小米手机关机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void sendMessage() {
        System.out.println("小米手机发短信");
    }
}
