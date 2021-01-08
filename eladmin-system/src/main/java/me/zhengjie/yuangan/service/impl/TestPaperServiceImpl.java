package me.zhengjie.yuangan.service.impl;

import lombok.RequiredArgsConstructor;
import me.zhengjie.config.FileProperties;
import me.zhengjie.utils.FileUtil;
import me.zhengjie.yuangan.service.TestPaperService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

/**
 * @Author: ZhouW
 * @Description:
 * @Date: Created in 11:26 2020/11/26
 */
@Service
@RequiredArgsConstructor
public class TestPaperServiceImpl implements TestPaperService {
    private final FileProperties properties;

    @Override
    public Map<String, String> updateAvatar(MultipartFile multipartFile) {
        File file = FileUtil.upload(multipartFile, properties.getPath().getAvatar());
        System.out.println(file);
        return null;
    }
}
