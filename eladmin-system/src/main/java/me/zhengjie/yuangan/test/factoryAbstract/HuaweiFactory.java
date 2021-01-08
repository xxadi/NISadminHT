package me.zhengjie.yuangan.test.factoryAbstract;

public class HuaweiFactory implements ProducingFactory {
    @Override
    public IPhoneProduct producingPhone() {
        return new HuaweiPhone();
    }

    @Override
    public IRouterProduct producingRouter() {
        return new HuaweiRouter();
    }
}