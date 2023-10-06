package Manager;

import Account.*;
import Adm.Admin.Schedule;
import Shop.Shop;
import Date.Date;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private AccountManager accountManager;
    public UserManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }
    public void addUser(UserAccount user) {
        accountManager.addAccount(user);
    }
    public void listUsers() {
        System.out.println("All users:");
        for (UserAccount account : accountManager.getAccounts()) {
            System.out.println("用户名: " + account.getUsername());
            System.out.println("用户共消费: "+ allFee(account.getUsername()) + "元");
            System.out.println("共购买 " +account.getShopList().size()+"张电影票");
        }
    }

    // 用户管理类中可以定义一个方法，用于删除用户信息
    public void deleteUser(String username) {
        Scanner scanner=new Scanner(System.in);
        int index = accountManager.findIndex(username);
        if (index != -1) { // 如果索引位置不等于 -1，表示存在该用户名对应的账户对象
            System.out.println("确认删除？输入yes或no");
            String bb=scanner.nextLine();
            if (bb.equals("yes")) {
                accountManager.getAccounts().remove(index);
            }
        } else { // 否则
            System.out.println("此用户不存在");
        }
    }

    // 用户管理类中可以定义一个方法，用于查询用户信息
    public void queryUser(String username) { // 查询用户的方法，参数为用户名
        int index = accountManager.findIndex(username);
        UserAccount account;
        List<Shop> shop;
        if (index != -1) { // 如果索引位置不等于 -1，表示存在该用户名对应的账户对象
            account=accountManager.getAccounts().get(index);
            shop=account.getShopList();
            System.out.println("用户名: " + account.getUsername());
            System.out.println("用户共消费: "+ allFee(account) + "元");
            System.out.println("共购买 " +account.getShopList().size()+"张电影票");
            if (!shop.isEmpty()) {
                for (Shop s:shop) {
                System.out.println("*******************************");
                System.out.println("电影名称: " +s.getMovie().getTitle());
                System.out.println("日期 :"+s.getSchedule().getDate().getDay()+"价格: "+s.getFee());
                System.out.println("座位: "+s.getRow()+" "+s.getCol());
                }
            }
        } else { // 否则
            System.out.println("此用户不存在"); // 打印查询失败和不存在该用户的信息
        }
    }

    public double allFee(String name) {
        int i=accountManager.findIndex(name);
        return allFee(accountManager.getAccounts().get(i));
    }
    public double allFee(UserAccount user) {
        double fee=0;
        if (user.getShopList().isEmpty()) {
            return 0;
        }
        for (Shop s:user.getShopList()) {
            fee+=s.getFee();
        }
        return fee;
    }
}
