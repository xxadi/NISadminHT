
package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/8/10.
 */

import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/10 11:06
 */
@Data
public class User {
    private String userId;
    private String userName;
    private String passWord;
    private String deptname;
    private String sex;
    private String birthday;
    private String phone;
    private String email;
    private String activity;
    private String usertype;
    private Date loginTime;
    private Date lastTime;
    private String count;
    private String professional;
    private String role;
    private String indate;
    private String deptcode;



    /**
     * 用户对应的角色集合
     */
    public Set<Role> getRoles() {
        return roles;
    }
    private Set<Role> roles;
    public User(String id, String userName, String password, Set<Role> roles) {
        this.userId = id;
        this.userName = userName;
        this.passWord = password;
        this.roles = roles;
    }

    public User(){

    }
}
