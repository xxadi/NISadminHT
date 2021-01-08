package me.zhengjie.yuangan.service.impl; /**
 * Created by Super on 2020/8/10.
 */


import me.zhengjie.yuangan.bean.User;
import me.zhengjie.yuangan.mapper.IMedNisAddUserMapper;
import me.zhengjie.yuangan.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/10 11:09
 */
@Service
public class User1ServiceImpl implements User1Service {

    @Autowired
    private IMedNisAddUserMapper dao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<Object> addUser(User user) {
        System.out.println(user);
        try {
            dao.addUser(user);
            return new ResponseEntity<Object>(user, HttpStatus.OK );
        } catch (Exception e) {
            boolean isThrow = true;
            Throwable cause = e.getCause();
            if (cause instanceof java.sql.SQLIntegrityConstraintViolationException) {
                isThrow = false;
                return new ResponseEntity<Object>(user.getUserId(), HttpStatus.ALREADY_REPORTED);
            }
            if (isThrow) {
                return new ResponseEntity<Object>(201, HttpStatus.EXPECTATION_FAILED);
            }
            return new ResponseEntity<Object>(201, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public List<User> queryUserList(String user, String dept, String role, String job) {
        return dao.queryUserList(user,dept,role,job);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUser(String userid) {
        return dao.deleteUser(userid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }

//    /**
//     * 模拟数据库查询
//     * @param userName
//     * @return
//     */
//    private User getMapByName(String userName){
//        //共添加两个用户，两个用户都是admin一个角色，
//        //wsl有query和add权限，zhangsan只有一个query权限
//        Permissions permissions1 = new Permissions("1","user:update");
//        Permissions permissions2 = new Permissions("2","user:add");
//        Set<Permissions> permissionsSet = new HashSet<>();
//        permissionsSet.add(permissions1);
//        permissionsSet.add(permissions2);
//        Role role = new Role("1","admin",permissionsSet);
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.add(role);
//        User user = new User("1","wsl","123456",roleSet);
//        Map<String ,User> map = new HashMap<>();
//        map.put(user.getUserName(), user);
//
//        Permissions permissions3 = new Permissions("3","query");
//        Set<Permissions> permissionsSet1 = new HashSet<>();
//        permissionsSet1.add(permissions3);
//        Role role1 = new Role("2","user",permissionsSet1);
//        Set<Role> roleSet1 = new HashSet<>();
//        roleSet1.add(role1);
//        User user1 = new User("2","zhangsan","123456",roleSet1);
//        map.put(user1.getUserName(), user1);
//        return map.get(userName);
//    }
}
