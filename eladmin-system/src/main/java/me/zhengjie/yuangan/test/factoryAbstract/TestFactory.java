package me.zhengjie.yuangan.test.factoryAbstract;

public class TestFactory {
    public static void main(String[] args) {
        //华为系列产品
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        IPhoneProduct huaweiPhone = huaweiFactory.producingPhone();
        huaweiPhone.call();
        huaweiPhone.end();

        IRouterProduct huaweiRouter = huaweiFactory.producingRouter();
        huaweiRouter.wifi();

        //小米系列产品
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        IPhoneProduct xiaomiPhone = xiaomiFactory.producingPhone();
        xiaomiPhone.call();

        IRouterProduct xiaomiRouter = xiaomiFactory.producingRouter();
        xiaomiRouter.wifi();
    }
}
