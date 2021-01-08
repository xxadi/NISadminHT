package me.zhengjie.yuangan.controller;

import io.swagger.annotations.ApiOperation;
import me.zhengjie.utils.SecurityUtils;
import me.zhengjie.yuangan.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @Author: ZhouW
 * @Description:
 * @Date: Created in 11:02 2020/12/25
 */
@RestController
@RequestMapping("api/testPaper")
public class TestPaper {

    @Autowired
    TestPaperService testPaperService;

    @ApiOperation("修改头像")
    @PostMapping(value = "/picture")
    public ResponseEntity<Object> updateAvatar(@RequestParam MultipartFile avatar){
        System.out.println(SecurityUtils.getCurrentUsername());
        testPaperService.updateAvatar(avatar);
        return new ResponseEntity<>(  new HashMap<String, String>(1) {{
            put("avatar", "123");
        }}, HttpStatus.OK);

    }
}
