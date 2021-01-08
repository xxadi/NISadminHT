package me.zhengjie.yuangan.test;

import me.zhengjie.yuangan.bean.GroupManager;
import me.zhengjie.yuangan.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


public class UnsafeList {
    @Autowired //将狗狗自动注入进来
            Dog dog;

    @Autowired
    private User1Service userService;


    public  void contextLoads() {
        System.out.println(dog); //打印看下狗狗对象
    }
    @GetMapping("extPatMsg")
    public String extPatMsg(GroupManager map, Pageable pageable) {
        System.out.println("----");
        userService.queryUserList("","","","");
        return "ResultAnalyseUtil.CUDAnalyse(resultBean)";
    }

}
