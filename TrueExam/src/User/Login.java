package User;


import Account.*;
import java.util.*;

public class Login {
    // 账户管理器对象，用于查找账户
    private AccountManager accountManager;
    // 扫描器对象，用于接收用户输入
    private Scanner scanner;

    // 构造器
    public Login(AccountManager accountManager) {
        this.accountManager = accountManager; // 初始化账户管理器对象
        this.scanner = new Scanner(System.in); // 初始化扫描器对象
    }

    // 登录方法，返回一个账户对象
    public boolean login(String name,String password) {
        UserAccount adm =accountManager.findAccount(name);
        if (adm != null) {
            return adm.login(name, password);
        } else {
            System.out.println("账户不存在");
        }
        return false;
    }
}