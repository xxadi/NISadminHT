package me.zhengjie.yuangan.test.factory;

public class CarFactory {
    static Car getHongQi() {
        return new HongQi();
    }

    static Car getTesla() {
        return new Tesla();
    }
}
