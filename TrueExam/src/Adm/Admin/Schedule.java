package Adm.Admin;

import Adm.Movie.*;
import java.util.*;
import Adm.*;
import Date.Date;
public class Schedule {
    public static final int SESSIONS_PER_DAY = 8;
    private Date date;
    private Movie[] list;
    private double[] priceList;
    private Seat[] seat;
    public Schedule(Date date) {
        this.date = date;
        // 初始化排片列表
        list = new Movie[8];
        // 初始化价格列表
        priceList = new double[8];
        // 填充排片列表和价格列表为 null
        seat = new Seat[8];
        for (int i = 0; i < SESSIONS_PER_DAY; i++) {
            list[i]=Movie.m0;
            priceList[i]=0;
            seat[i]=new Seat();
        }
    }

    // 一个实例方法，返回日期对象
    public Date getDate() {
        return date;
    }

    public void OO(int index,Movie movie,double p) {
        list[index]=movie;
        priceList[index]=p;
    }
    // 一个实例方法，根据索引对象，返回该索引对应的影片对象
    public Movie getMovieByIndex(int index) {
        // 如果索引对象有效，返回对应的值
        if (index >= 0 && index < SESSIONS_PER_DAY) {
            return list[index-1];
        }
        // 否则，返回 null
        else {
            return null;
        }
    }

    // 一个实例方法，根据索引对象，返回该索引对应的价格对象
    public double getPriceByIndex(int index) {
        // 如果索引对象有效，返回对应的值
        if (index >= 0 && index < SESSIONS_PER_DAY) {
            return priceList[index-1];
        }
        // 否则，返回零
        else {
            return 0.0;
        }
    }

    // 一个实例方法，根据索引对象和影片对象，设置该索引对应的影片对象，并返回是否成功
    public boolean setMovieByIndex(int index, Movie movie) {
        // 如果索引对象有效，并且该索引对应的影片对象为 null，修改对应的值，并返回真
        if (index >= 0 && index < SESSIONS_PER_DAY) {
            list[index-1]=movie;
            return true;
        }
        // 否则，返回假
        else {
            return false;
        }
    }

    // 一个实例方法，根据索引对象和价格对象，设置该索引对应的价格对象，并返回是否成功
    public boolean setPriceByIndex(int index, double price) {
        // 如果索引对象有效，并且该索引对应的价格对象为 null，修改对应的值，并返回真
        if (index >= 0 && index < SESSIONS_PER_DAY) {
            priceList[index-1]=price;
            return true;
        }
        // 否则，返回假
        else {
            return false;
        }
    }

    // 一个实例方法，根据索引对象和影片对象和价格对象，添加排片信息，并返回是否成功
    public boolean addScheduleByIndex(int index, Movie movie, double price) {
        // 如果索引对象有效，并且该索引对应的影片对象和价格对象都为 null，修改对应的值，并返回真
        if (index >= 0 && index < SESSIONS_PER_DAY) {
            list[index-1]=movie;
            priceList[index-1]=price;
            return true;
        }
        // 否则，返回假
        else {
            return false;
        }
    }

    // 一个实例方法，根据索引对象，删除排片信息，并返回是否成功
    public boolean deleteScheduleByIndex(int index) {
        // 如果索引对象有效，并且该索引对应的影片对象和价格对象都不为 null，修改对应的值为 null，并返回真
        if (index >= 0 && index < SESSIONS_PER_DAY) {
            list[index]=Movie.m0;
            priceList[index]=0;
            return true;
        }
        // 否则，返回假
        else {
            return false;
        }
    }

    // 一个实例方法，显示一天的排片信息
    public void showSchedule() {
        // 输出日期
        System.out.println(date.getDay() + "：");

        int i=0;

        // 输出上午的场次信息
        System.out.println("上午：");
        for ( i = 0; i < 3; i++) {
            // 获取对应的影片对象和价格对象
            Movie movie = list[i];
            Double price = priceList[i];
            System.out.println(movie.getTitle() + " 价格：" + price + " 元");
        }

        // 输出下午的场次信息
        System.out.println("下午：");
        for (; i < 6; i++) {
            // 获取对应的影片对象和价格对象
            Movie movie = list[i];
            Double price = priceList[i];
            // 如果影片对象和价格对象都不为 null，输出影片信息和价格信息
            if (movie != null && price != null) {
                System.out.println(movie.getTitle() + " 价格：" + price + " 元");
            }
        }

        // 输出晚上的场次信息
        System.out.println("晚上：");
        for ( ; i < 8; i++) {
            // 获取对应的影片对象和价格对象
            Movie movie = list[i];
            Double price = priceList[i];
            // 如果影片对象和价格对象都不为 null，输出影片信息和价格信息
            if (movie != null && price != null) {
                System.out.println(movie.getTitle() + " 价格：" + price + " 元");
            }
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Movie[] getList() {
        return list;
    }

    public void setList(Movie[] list) {
        this.list = list;
    }

    public double[] getPriceList() {
        return priceList;
    }

    public void setPriceList(double[] priceList) {
        this.priceList = priceList;
    }

    public Seat[] getSeat() {
        return seat;
    }

    public void setSeat(Seat[] seat) {
        this.seat = seat;
    }
}
