package me.zhengjie.yuangan.test.factoryAbstract;

public interface ProducingFactory {
    IPhoneProduct producingPhone(); // 生产手机

    IRouterProduct producingRouter(); // 生产路由器
}
