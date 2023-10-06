package User;

import Account.UserAccount;
import Adm.Movie.*;
import Adm.*;
import Adm.Admin.*;
import Shop.Shop;
import Date.Date;
import java.util.Scanner;

public class Shopping {
    private UserAccount user;
    private Movie movie;
    // 排片对象
    private Schedule schedule;
    // 座位对象
    private Seat seat;
    // 扫描器对象
    private Scanner scanner;
    private MovieManager movieManager;
    private ScheduleManager scheduleManager;
    // 构造方法，初始化对象
    public Shopping(MovieManager movieManager, ScheduleManager scheduleManager, UserAccount user) {
        this.movie = null;
        this.schedule = null;
        this.seat = null;
        this.scanner = new Scanner(System.in);
        this.movieManager=movieManager;
        this.scheduleManager=scheduleManager;
        this.user=user;
    }

    // 购买电影票的方法
    public double buyTicket(Date date1, int index) {
        Date date=scheduleManager.dateFindDate(date1);
        movie=scheduleManager.getMovieByDateAndIndex(date,index);
        schedule=scheduleManager.getScheduleByDate(date);
        double fee=scheduleManager.getPriceByDateAndIndex(date,index);
        System.out.println("请选择你想要坐的座位：");
        seat=scheduleManager.getMap().get(date).getSeat()[index];
        seat.showSeat();
        int row ;
        int col ;
        while (true) {
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row < 1 || row > 10 || col < 1 || col > 10) {
                System.out.println("输入错误，请重新选择");
            }
            if (!seat.status[row - 1][col - 1]) {
                System.out.println("该座位已被占用，请重新选择");
            } else {
                seat.buySeat(row,col);
                break;
            }
        }
        Shop shop =new Shop(movie,schedule,index,seat,row,col,fee);
        user.setShop(shop);
        System.out.println("请支付费用"+fee+"元");
        System.out.println("购买成功");
        System.out.println("你选择了 " + row + " 行 " + col + " 列");
        System.out.println("你的订单如下：");
        System.out.println("电影：" + this.movie.getTitle());
        System.out.println("日期：" + this.schedule.getDate().getDay() );
        System.out.println("场次：" + index );
        System.out.println("座位：" + row + " 行 " + col + " 列");
        System.out.println("价格：" + fee);
        return fee;
    }
}
