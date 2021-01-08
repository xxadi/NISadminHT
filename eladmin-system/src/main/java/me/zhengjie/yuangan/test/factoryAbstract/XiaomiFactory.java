package me.zhengjie.yuangan.test.factoryAbstract;

public class XiaomiFactory implements ProducingFactory {
    @Override
    public IPhoneProduct producingPhone() {
        return new XiaomiPhone();
    }

    @Override
    public IRouterProduct producingRouter() {
        return new XiaomiRouter();
    }
}