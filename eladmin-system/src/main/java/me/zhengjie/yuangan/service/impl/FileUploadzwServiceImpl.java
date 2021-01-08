package me.zhengjie.yuangan.service.impl;

import me.zhengjie.yuangan.bean.FileList;
import me.zhengjie.yuangan.bean.FilePath;
import me.zhengjie.yuangan.mapper.ImedNisFileUploadMapper;
import me.zhengjie.yuangan.service.FileUploadzwService;
import me.zhengjie.yuangan.service.dto.FileUploadQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZhouW
 * @time: 2021/1/4 15:06
 */
@Service
public class FileUploadzwServiceImpl implements FileUploadzwService {
    @Autowired
    private ImedNisFileUploadMapper dao;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addFile(FileList fileList) {
        dao.addFile(fileList);
        System.out.println(fileList.getFileId());
        List<Map<String, String>> filePathList = fileList.getFilePathList();
        for (Map<String,String> map: filePathList) {

            FilePath filePath = new FilePath();
            filePath.setParentId(fileList.getFileId());
            filePath.setPathUserId(map.get("id"));
            filePath.setPathUserName(map.get("name"));
            dao.addFilePerson(filePath);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateFile(FileList fileList) {
        dao.updateFile(fileList);
        System.out.println(fileList.getFileId());
        dao.deleteFilePerson(fileList.getFileId());
        List<Map<String, String>> filePathList = fileList.getFilePathList();
        for (Map<String,String> map: filePathList) {

            FilePath filePath = new FilePath();
            filePath.setParentId(fileList.getFileId());
            filePath.setPathUserId(map.get("id"));
            filePath.setPathUserName(map.get("name"));
            dao.addFilePerson(filePath);
        }
        return true;
    }

    @Override
    public List<FileList> queryFileUploadList(FileUploadQueryCriteria quest) {
        return dao.queryFileUploadList(quest);
    }

    @Override
    public List<FilePath> queryFileUploadPersonListById(String questId) {
        return dao.queryFileUploadListById(questId);
    }
}
