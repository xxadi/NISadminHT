package me.zhengjie.yuangan.test.factoryAbstract;

public class XiaomiRouter implements IRouterProduct {
    @Override
    public void wifi() {
        System.out.println("小米路由器");
    }
}
