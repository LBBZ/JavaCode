package Account;

import java.util.LinkedList;

public class AccountManager {
    // 账户管理器中可以定义一个链表，用于存储多个账户对象
    private LinkedList<AdminAccount> admAccounts;//管理员
    private LinkedList<UserAccount> accounts; //用户

    // 账户管理器中可以定义一个构造器，用于初始化账户链表
    public AccountManager() { // 创建账户管理器的构造器
        accounts = new LinkedList<UserAccount>();
        admAccounts = new LinkedList<AdminAccount>(){{
            add(new AdminAccount("admin","ynuadmin"));
        }};
    }

    // 账户管理器中可以定义一个方法，用于添加账户对象到链表中
    public void addAccount(UserAccount account) { // 添加账户的方法，参数为账户对象
        accounts.add(account); // 将账户对象添加到链表末尾
        System.out.println("账户 " + account.getUsername() + " 成功建立"); // 打印添加成功的信息
    }

    public void addAdmAccount(AdminAccount account) { // 添加账户的方法，参数为账户对象
        admAccounts.add(account); // 将账户对象添加到链表末尾
        System.out.println("账户 " + account.getUsername() + " 成功建立"); // 打印添加成功的信息
    }

    public int findIndex(String username) {
        for (int i = 0; i < accounts.size(); i++) { // 遍历链表中的元素
            if (accounts.get(i).getUsername().equals(username)) { // 如果找到匹配的用户名
                return i;
            }
        }
        return -1;
    }

    public UserAccount findAccount(String username) {
        int j=0;
        for (int i = 0; i < accounts.size();j++, i++) { // 遍历链表中的元素
            if (accounts.get(i).getUsername().equals(username)) { // 如果找到匹配的用户名
                break;
            }
        }
        // 判断账户映射表中是否包含该用户名
        if (j!=-1) {
            // 返回该用户名对应的账户对象
            return accounts.get(j);
        } else {
            // 返回空值
            return null;
        }
    }

    public AdminAccount findAdmAccount(String username) {
        int j=0;
        for (int i = 0; i < admAccounts.size();j++, i++) { // 遍历链表中的元素
            if (admAccounts.get(i).getUsername().equals(username)) { // 如果找到匹配的用户名
                break;
            }
        }
        // 判断账户映射表中是否包含该用户名
        if (j!=admAccounts.size()) {
            // 返回该用户名对应的账户对象
            return admAccounts.get(j);
        } else {
            // 返回空值
            return null;
        }
    }
    public LinkedList<UserAccount> getAccounts() {//返回用户账户链表
        return accounts;
    }
}