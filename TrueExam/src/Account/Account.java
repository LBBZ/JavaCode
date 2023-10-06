package Account;

public abstract class Account {
    // 抽象类中可以定义变量和常量
    private String username; // 账户名
    private String password; // 密码
    // 抽象类中可以定义构造器
    public Account(String username, String password) { // 创建账户的构造器
        this.username = username;
        this.password = password;
    }

    // 抽象类中可以定义非抽象方法
    public String getUsername() { // 获取账户名的方法
        return username;
    }

    public void setUsername(String username) { // 设置账户名的方法
        this.username = username;
    }

    public String getPassword() { // 获取密码的方法
        return password;
    }

    public void setPassword(String password) { // 修改密码的方法
        this.password = password;
    }

    // 抽象类中可以定义抽象方法
    public abstract boolean login(String username, String password); // 登录账户的抽象方法，返回布尔值表示是否登录成功
}
