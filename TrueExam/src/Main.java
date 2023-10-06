import Account.*;
import Adm.*;
import Adm.Movie.*;
import Adm.Admin.*;
import Manager.*;
import Manager.PasswordManager;
import User.*;
import Shop.*;
import Date.Date;
import User.Login;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        MovieManager movieManager = new MovieManager();
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Date date ;

        Map<Date,Schedule> mapt;
        Schedule sc;
        boolean exit = false;
        String date1 ;
        double price;
        String name;
        int i;

        System.out.println("输入电影，进行排片");
        System.out.println("首先是电影管理系统");
        while (!exit) {
            System.out.println("1. 添加影片");
            System.out.println("2. 修改影片");
            System.out.println("3. 电影查询");
            System.out.println("4. 退出程序");

            int option = scanner.nextInt();
            switch (option) {
                case 1: // 添加影片
                    movieManager.addMovie();
                    break;
                case 2: // 修改影片
                    movieManager.modifyMovie();
                    break;
                case 3: // 电影列表
                    movieManager.listMovies();
                    break;
                case 4: // 退出程序
                    exit = true;
                    System.out.println("已退出程序");
                    break;
                default: // 其他无效选项
                    System.out.println("无效的选项，请重新输入。"); // 输出提示信息
                    break;
            }

            System.out.println(movieManager.getMovieByTitle("s").getDirector());

        }

        System.out.println("场次管理系统");
        ScheduleManager scheduleManager =new ScheduleManager(movieManager) ;
        exit=false;
        while (!exit) {
            System.out.println("1. 添加排片");
            System.out.println("2. 删除排片");
            System.out.println("3. 场次列表");
            System.out.println("4. 退出程序");

            int option = scanner.nextInt();

            switch (option) {
                case 1: // 添加排片
                    System.out.println("输入日期，格式yyyy-mm-dd");
                    date1=input.nextLine();
                    date=new Date(date1);
                    scheduleManager.newSchedule(date) ;
                    if (scheduleManager.getMap().get(date)==null) {
                        System.out.println("shit");
                    }
                    for (i=0;i<8;i++) {
                        System.out.println("输入电影，不安排电影请输入no.第 "+ i +" 场");
                        name=input.nextLine();
                        sc=scheduleManager.getMap().get(date);
                        if (name.equals("no")) {
                            continue ;
                        } else {
                            System.out.println("输入价格");
                            price=input.nextDouble();
                            input.nextLine();

                            scheduleManager.getMap().get(date).OO(i,movieManager.getMovieByTitle(name),price);
                        }
                    }
                    break;
                case 2: // 删除排片
                    System.out.println("输入日期，格式yyyy-mm-dd");
                    date1=input.nextLine();
                    date=new Date(date1);
                    System.out.println("输入电影节点");
                    i = input.nextInt();
                    input.nextLine();
                    scheduleManager.getScheduleByDate(date).OO(i-1,Movie.m0,0.0);
                    break;
                case 3:
                    scheduleManager.showAllSchedules();
                    break;
                case 4: // 退出程序
                    exit = true;
                    System.out.println("已退出程序");
                    break;
                default: // 其他无效选项
                    System.out.println("无效的选项，请重新输入。"); // 输出提示信息
                    break;
            }
        }

        UserAccount userAccount1=new UserAccount("haha","11211");
        UserAccount userAccount2=new UserAccount("huhu","22222");
        accountManager.addAccount(userAccount1);
        accountManager.addAccount(userAccount2);
        //用来展示管理员功能

        exit=false;
        while (!exit) {
            System.out.println("1. 修改管理员密码");
            System.out.println("2. 重置管理员密码");
            System.out.println("3. 列出用户信息");
            System.out.println("4. 删除用户信息");
            System.out.println("5. 查询用户信息");
            System.out.println("6. 退出登录");
            int option = scanner.nextInt();
            PasswordManager passwordManager=new PasswordManager(accountManager);
            UserManager userManager=new UserManager(accountManager);
            switch (option) {
                case 1:
                    System.out.println("输入新密码");
                    String ps =input.nextLine();
                    passwordManager.changePassword("admin","ynuadmin",ps);
                    break;
                case 2:
                    passwordManager.resetPassword("admin");
                    break;
                case 3:
                    userManager.listUsers();
                    break;
                case 4:
                    System.out.println("输入用户名");
                    String nn=input.nextLine();
                    userManager.deleteUser(nn);
                    break;
                case 5:
                    System.out.println("输入用户名");
                    String nd=input.nextLine();
                    userManager.queryUser(nd);
                    break;
                case 6: // 退出程序
                    exit = true;
                    System.out.println("已退出登录");
                    break;
                default: // 其他无效选项
                    System.out.println("无效的选项，请重新输入。"); // 输出提示信息
                    break;
            }
        }

        UserAccount hasLogin=new UserAccount("","");

        exit=false;
        while (!exit) {
            System.out.println("1. 登录");
            System.out.println("2. 注册");
            Login log=new Login(accountManager);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("输入账户");
                    String namer= input.nextLine();
                    System.out.println("输入密码");
                    String pass=input.nextLine();
                    if(log.login(namer,pass)) {
                        hasLogin = accountManager.findAccount(namer);
                        if (hasLogin==null) {
                            System.out.println("shit");
                        }
                        exit = true;
                    }

                    break;
                case 2:
                    System.out.println("输入账户");
                    String namert= input.nextLine();
                    System.out.println("输入密码");
                    String passt=input.nextLine();
                    UserAccount us=new UserAccount(namert,passt);
                    accountManager.addAccount(us);
                    System.out.println("创建成功");
                    break;
                default: // 其他无效选项
                    System.out.println("无效的选项，请重新输入。"); // 输出提示信息
                    break;
            }
        }

            exit = false;
            while (!exit) {
                System.out.println("1. 查询已上映的电影");
                System.out.println("2. 查询所有场次");
                System.out.println("3. 购买电影票");
                System.out.println("4. 修改密码");
                System.out.println("5. 重置密码");
                System.out.println("6. 购物城查询");
                System.out.println("7. 退出登录");
                int option = scanner.nextInt();
                PasswordManager2 passwordManager2 = new PasswordManager2(hasLogin);
                Shopping shopping = new Shopping(movieManager,scheduleManager,hasLogin);
                switch (option) {
                    case 1:
                        movieManager.listMovies();
                        break;
                    case 2:
                        scheduleManager.showAllSchedules();
                        break;
                    case 3:
                        System.out.println("输入日期，yyyy-mm-dd");
                        String a= input.nextLine();
                        Date ddea=new Date(a);
                        System.out.println("输入场次");
                        int b=input.nextInt();
                        input.nextLine();
                        shopping.buyTicket(ddea,b);
                        break;
                    case 4:
                        System.out.println("输入旧密码");
                        String older= input.nextLine();
                        System.out.println("输入新密码");
                        String unolder=input.nextLine();
                        passwordManager2.changePassword(older,unolder);
                        break;
                    case 5:
                        passwordManager2.resetPassword();
                        break;
                    case 6:
                        if (hasLogin.getShopList().isEmpty()) {
                            System.out.println("无购物记录");
                            break;
                        }
                        for (Shop shop:hasLogin.getShopList()){
                            System.out.println("***************************");
                            System.out.println("电影："+shop.getMovie().getTitle());
                            System.out.println("场次："+shop.getIndex());
                            System.out.println("座位："+shop.getRow()+" "+shop.getCol());
                            System.out.println("价格："+shop.getFee());
                        }
                        break;
                    case 7: // 退出程序
                        exit = true;
                        System.out.println("已退出登录");
                        break;
                    default: // 其他无效选项
                        System.out.println("无效的选项，请重新输入。"); // 输出提示信息
                        break;
                }
            }
    }
}
