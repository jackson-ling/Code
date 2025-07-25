package common;

import java.io.Serializable;

public class User implements Serializable {
    // 为了防止序列化冲突，这里可以设置一下版本
    private static final long serialVersionUID = 1L;

    private String userId; // 用户名
    private String passwd; // 用户密码

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    // 给出 setter 和 getter 方法

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
