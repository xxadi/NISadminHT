package me.zhengjie.yuangan.service;

import me.zhengjie.yuangan.bean.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by Super on 2020/8/10.
 */
public interface User1Service {
    ResponseEntity<Object> addUser(User user);

    List<User> queryUserList(String user, String dept, String role, String job);

    boolean updateUser(User user);

    boolean deleteUser(String userid);
}
