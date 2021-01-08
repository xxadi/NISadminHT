package me.zhengjie.yuangan.test.daili;

public class MovieTest {
    public static void main(String[] args) {
        RealMovie realMovie = new RealMovie();
        Cinema cinema = new Cinema(realMovie);
        cinema.play();
    }
}
