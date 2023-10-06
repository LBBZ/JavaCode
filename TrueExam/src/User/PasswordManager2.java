package User;

import Account.*;
import java.util.*;

public class PasswordManager2 {
    private UserAccount userAccount;
    private Scanner scanner;

    // 构造器
    public PasswordManager2(UserAccount userAccount) {
        this.userAccount = userAccount; // 初始化用户账户对象
        this.scanner = new Scanner(System.in); // 初始化扫描器对象
    }

    // 修改密码方法
    public void resetPassword() {
        System.out.println("确定要重置密码？请输入yes或no");
        String no_yes=scanner.nextLine();
        if (no_yes.equals("yes")) {
            userAccount.setPassword("123456");
        } else {
            System.out.println("密码未重置");
        }
    }

    // 密码管理类中可以定义一个方法，用于修改管理员自身账户密码
    public void changePassword(String oldPassword, String newPassword) { // 修改管理员密码的方法，参数为管理员用户名，旧密码和新密码
        if (userAccount.getPassword().equals(oldPassword)) {
            userAccount.setPassword(newPassword);
        } else {
            System.out.println("用户 " + userAccount.getUsername() + " 密码修改失败，旧密码输入错误");
        }
    }
}
