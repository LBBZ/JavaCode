package Account;

public class AdminAccount extends Account {
    // 子类中可以定义自己的构造器
    public AdminAccount(String username, String password) { // 创建管理员账户的构造器
        super(username, password); // 调用父类的构造器
    }

    // 子类中必须重写父类的抽象方法
    @Override
    public boolean login(String username, String password) { // 重写登录账户的方法，返回布尔值表示是否登录成功
        if (username.equals(getUsername()) && password.equals(getPassword())) { // 如果用户名和密码匹配
            System.out.println("管理员 " + username + " 登陆成功"); // 打印登录成功的信息
            return true; // 返回 true 表示登录成功
        } else { // 否则
            System.out.println("管理员登录失败"); // 打印登录失败的信息
            return false; // 返回 false 表示登录失败
        }
    }
}
