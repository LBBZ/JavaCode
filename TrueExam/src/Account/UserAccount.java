package Account;

import Shop.Shop;

import java.util.LinkedList;
import java.util.List;

public class UserAccount extends Account {
    List<Shop> shopList;//储存已购的票
    public UserAccount(String username, String password) { // 创建用户账户的构造器
        super(username, password);
        shopList=new LinkedList<Shop>();
    }

    // 子类中必须重写父类的抽象方法
    @Override
    public boolean login(String username, String password) { // 重写登录账户的方法，返回布尔值表示是否登录成功
        if (username.equals(getUsername()) && password.equals(getPassword())) { // 如果用户名和密码匹配
            System.out.println("用户 " + username + " 登陆成功"); // 打印登录成功的信息
            return true; // 返回 true 表示登录成功
        } else { // 否则
            System.out.println("登录失败"); // 打印登录失败的信息
            return false; // 返回 false 表示登录失败
        }
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShop(Shop shop) {
        shopList.add(shop);
    }
}
