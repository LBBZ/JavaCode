package User;

import java.util.Scanner;
import Adm.Admin.*;
import Adm.Movie.*;

// 一个表示展示的类，包含电影管理器对象，排片管理器对象，扫描器对象，以及展示的方法
public class Display {
    // 电影管理器对象
    private MovieManager movieManager;
    // 排片管理器对象
    private ScheduleManager scheduleManager;
    // 扫描器对象
    private Scanner scanner;

    // 构造方法，初始化对象
    public Display(MovieManager movieManager, ScheduleManager scheduleManager) {
        this.movieManager = movieManager;
        this.scheduleManager = scheduleManager;
        this.scanner = new Scanner(System.in);
    }

    // 查询所有场次的方法
    public void displayAllSchedules() {
        System.out.println("以下是所有场次：");
        scheduleManager.showAllSchedules();
    }

    // 查询已上映的电影的方法
    public void displayReleasedMovies() {
        System.out.println("以下是已上映的电影：");
        movieManager.listMovies();
    }
}