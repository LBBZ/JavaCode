package Adm.Movie;

import Date.Date;
public class Movie {
    // 私有属性
    private String title; // 片名
    private String director; // 导演
    private String cast; // 主演
    private String genre; // 电影类型
    private String plot; // 剧情信息
    private int duration; // 电影时长（分钟）

    public static Movie m0 =new Movie("空白","","","","",0);
    // 构造方法
    public Movie(String title, String director, String cast, String genre, String plot, int duration) {
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.genre = genre;
        this.plot = plot;
        this.duration = duration;
    }

    // 公共方法
    // 获取片名
    public String getTitle() {
        return title;
    }

    // 修改片名
    public void setTitle(String title) {
        this.title = title;
    }

    // 获取导演
    public String getDirector() {
        return director;
    }

    // 修改导演
    public void setDirector(String director) {
        this.director = director;
    }

    // 获取主演
    public String getCast() {
        return cast;
    }

    // 修改主演
    public void setCast(String cast) {
        this.cast = cast;
    }

    // 获取电影类型
    public String getGenre() {
        return genre;
    }

    // 修改电影类型
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // 获取剧情信息
    public String getPlot() {
        return plot;
    }

    // 修改剧情信息
    public void setPlot(String plot) {
        this.plot = plot;
    }

    // 获取电影时长
    public int getDuration() {
        return duration;
    }

    // 修改电影时长
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
