package me.zhengjie.yuangan.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class TestController {

    public static void main(String[] args) {
//        Accont accont = new Accont(1000,"结婚基金");
//        Drawing you = new Drawing(accont,50,"你");
//        Drawing girlFriend = new Drawing(accont,100,"女朋友");
//
//        you.start();
//        girlFriend.start();
        //邮件设置1：一个简单的邮件

    }
}

class Accont{
        int money;
        String name;

    public Accont(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
class Drawing extends Thread{
        Accont account;// 账户

    int drawing ;// 取了多少钱
    int nowMoney ;  // 现在手里有多少钱
    public Drawing(Accont accont,int drawingMoney,String name){
        super(name);
        this.account = accont;
        this.drawing = drawingMoney;
    }

    @Override
    public void  run(){

        synchronized (account){
            if(account.money -drawing<0){
                System.out.println(Thread.currentThread().getName()+" 钱不够了");
                return ;
            }
            //sleep 可以方法问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 卡内余额
            account.money = account.money - drawing;
            // 你手里的钱
            nowMoney = nowMoney +drawing;

            System.out.println(account.name + "余额：" + account.money);

            System.out.println(this.getName() + "手里的钱："+nowMoney);
        }

    }
}
