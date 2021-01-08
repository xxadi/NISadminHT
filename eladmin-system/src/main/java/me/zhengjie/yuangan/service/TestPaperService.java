package me.zhengjie.yuangan.service;


import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author: ZhouW
 * @Description:
 * @Date: Created in 11:25 2020/12/25
 */
public interface TestPaperService {
    /**
     * 修改头像
     * @param file 文件
     * @return /
     */
    Map<String, String> updateAvatar(MultipartFile file);
}
