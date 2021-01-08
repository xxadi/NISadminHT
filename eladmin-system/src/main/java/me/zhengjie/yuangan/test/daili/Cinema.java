package me.zhengjie.yuangan.test.daili;

public class Cinema implements Movie{
    RealMovie realMovie;

    public Cinema(RealMovie realMovie){
        this.realMovie = realMovie;
    }
    @Override
    public void play() {
        BeforeMovie();
        realMovie.play();
        AfterMovie();
    }

    public void BeforeMovie(){
        System.out.println("饮料，矿泉水了");
    }

    public void AfterMovie(){
        System.out.println("饮料，矿泉水了,带回家");
    }
}
