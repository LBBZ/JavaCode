package Adm.Admin;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import Adm.Movie.*;
import Date.Date;
public class ScheduleManager {
    // 私有属性
    public Map<Date, Schedule> map;
    public Scanner input;
    public MovieManager movieManager;
    public ScheduleManager(MovieManager movieManager) {
        map = new HashMap<>();
        input=new Scanner(System.in);
        this.movieManager=movieManager;
    }

    public Schedule newSchedule(Date date) {
        Date d=date;
        Schedule schedule =new Schedule(d);
        map.put(d,schedule);
        return map.get(date);
    }
    public Schedule newSchedule(String date) {
        Date date1=new Date(date);
        newSchedule(date1);
        return map.get(date);
    }

    // 根据日期对象，返回该日期对应的 Schedule 对象
    public Schedule getScheduleByDate(Date date) {
        // 如果映射对象包含该日期的键，返回对应的值
        for (Date d:map.keySet()) {
            if (d.getDay().equals(date.getDay())) {
                return map.get(d);
            }
        }
        // 否则，返回 null
            return null;
    }

    // 一个实例方法，根据日期对象和索引对象，返回该日期和索引对应的影片对象
    public Movie getMovieByDateAndIndex(Date date, int index) {
        // 获取该日期对应的 Schedule 对象
        Schedule schedule = getScheduleByDate(date);
        // 如果 Schedule 对象不为 null，调用其实例方法，返回该索引对应的影片对象
        if (schedule != null) {
            return schedule.getMovieByIndex(index);
        }
        // 否则，返回 null
        else {
            return null;
        }
    }

    public Date dateFindDate(Date date) {
        for (Date da:map.keySet()) {
            if (da.getDay().equals(date.getDay())) {
                return da;
            }
        }
        return null;
    }
    public Date dateFindDate(String date) {
        for (Date da:map.keySet()) {
            if (da.getDay().equals(date)) {
                return da;
            }
        }
        return null;
    }
    // 一个实例方法，根据日期对象和索引对象，返回该日期和索引对应的价格对象
    public double getPriceByDateAndIndex(Date date, int index) {
        // 获取该日期对应的 Schedule 对象
        Schedule schedule = getScheduleByDate(date);
        // 如果 Schedule 对象不为 null，调用其实例方法，返回该索引对应的价格对象
        if (schedule != null) {
            return schedule.getPriceByIndex(index);
        }
        // 否则，返回零
        else {
            return 0.0;
        }
    }

    public void setScheduleForAll(Date date) {
        Schedule schedule=map.get(date);
        int j;
        for (int i=0;i<8;i++) {
            j=i+1;
            System.out.println("输入电影，不安排电影请输入no.第 "+ j +" 场");
            String name=input.nextLine();
            if (name.equals("no")) {
                continue ;
            } else {
                System.out.println("输入价格");
                double price=input.nextDouble();
                input.nextLine();
                Movie movie=movieManager.getMovieByTitle(name);
                schedule.OO(i,movie,price);
            }
        }
    }
    public void setScheduleForAll(String  date) {
        Date date1 = new Date(date);
        setScheduleForAll(date1);
    }
    // 一个实例方法，根据日期对象和索引对象和影片对象，设置该日期和索引对应的影片对象，并返回是否成功
    public boolean setMovieByDateAndIndex(Date date, int index, Movie movie, double price) {
        // 获取该日期对应的 Schedule 对象
        Schedule schedule = getScheduleByDate(date);
        // 如果 Schedule 对象不为 null，调用其实例方法，设置该索引对应的影片对象，并返回结果
        if (schedule != null) {
            setPriceByDateAndIndex(date,index,price);
            return schedule.setMovieByIndex(index, movie);
        }
        // 否则，返回假
        else {
            return false;
        }
    }

    // 一个实例方法，根据日期对象和索引对象和价格对象，设置该日期和索引对应的价格对象，并返回是否成功
    public boolean setPriceByDateAndIndex(Date date, int index, double price) {
        // 获取该日期对应的 Schedule 对象
        Schedule schedule = getScheduleByDate(date);
        // 如果 Schedule 对象不为 null，调用其实例方法，设置该索引对应的价格对象，并返回结果
        if (schedule != null) {
            return schedule.setPriceByIndex(index, price);
        }
        // 否则，返回假
        else {
            return false;
        }
    }

    // 添加排片信息，并返回是否成功
    public boolean addScheduleByDateAndIndex(Date date, int index, Movie movie, double price) {
        // 获取该日期对应的 Schedule 对象
        Schedule schedule = getScheduleByDate(date);

        // 如果 Schedule 对象为 null，创建一个新的 Schedule 对象，并将日期和 Schedule 对象作为键值对添加到映射对象中
        if (schedule == null) {
            schedule = new Schedule(date);
            map.put(date, schedule);
        }

        // 调用 Schedule 对象的实例方法，添加排片信息，并返回结果
        return schedule.addScheduleByIndex(index, movie, price);
    }

    // 一个实例方法，根据日期对象和索引对象，删除排片信息，并返回是否成功
    public void deleteScheduleByDateAndIndex(Date date, int index) {
        // 获取该日期对应的 Schedule 对象
        map.get(date).OO(index,Movie.m0,0.0);
    }

    // 一个实例方法，显示所有的排片信息
    public void showAllSchedules() {
        // 如果映射对象为空，输出提示信息
        if (map.isEmpty()) {
            System.out.println("暂无任何排片信息。");
        }
        // 否则，遍历映射对象的值集合
        else {
            for (Schedule schedule : map.values()) {
                // 调用每个 Schedule 对象的实例方法，显示一天的排片信息
                schedule.showSchedule();
            }
        }
    }

    public Map<Date, Schedule> getMap() {
        return map;
    }
}