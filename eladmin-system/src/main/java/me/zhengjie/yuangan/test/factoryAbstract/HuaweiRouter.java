package me.zhengjie.yuangan.test.factoryAbstract;

public class HuaweiRouter implements IRouterProduct{
    @Override
    public void wifi() {
        System.out.println("华为路由器");
    }
}
