package Manager;

import Account.*;
import Adm.Admin.Schedule;
import java.util.Scanner;

public class PasswordManager {
    // 密码管理类中可以定义一个账户管理器对象，用于调用账户管理器类的方法
    private AccountManager accountManager; // 账户管理器对象
    private Scanner scanner ;
    // 密码管理类中可以定义一个构造器，用于初始化账户管理器对象
    public PasswordManager(AccountManager accountManager) { // 创建密码管理类的构造器
        this.accountManager = accountManager; // 创建一个账户管理器对象
        scanner=new Scanner(System.in);
    }

    // 密码管理类中可以定义一个方法，用于添加管理员账户对象到账户链表中
    public void addAdmin(AdminAccount admin) { // 添加管理员的方法，参数为管理员账户对象
        accountManager.addAdmAccount(admin); // 调用账户管理器的添加账户的方法，将管理员账户对象添加到链表中
    }

    public void resetPassword(String adminUsername) {
        AdminAccount account=accountManager.findAdmAccount(adminUsername);
        if (account != null) {
            System.out.println("确定要重置密码？请输入yes或no");
            String no_yes=scanner.nextLine();
            if (no_yes.equals("yes")) {
                account.setPassword("123456");
            } else {
                System.out.println("密码未重置");
            }
        } else {
            System.out.println("此管理员账户不存在");
        }
    }

    // 密码管理类中可以定义一个方法，用于修改管理员自身账户密码
    public void changePassword(String adminUsername, String oldPassword, String newPassword) { // 修改管理员密码的方法，参数为管理员用户名，旧密码和新密码
        AdminAccount account=accountManager.findAdmAccount(adminUsername);
        if (account != null) {
            if (account.getPassword().equals(oldPassword)) {
                account.setPassword(newPassword);
            } else {
                System.out.println("管理员 " + adminUsername + " 密码修改失败，旧密码输入错误");
            }
        } else {
            System.out.println("此管理员账户不存在");
        }
    }
}
