package me.zhengjie.yuangan.service;

import me.zhengjie.yuangan.bean.FileList;
import me.zhengjie.yuangan.bean.FilePath;
import me.zhengjie.yuangan.bean.QuestionBank;
import me.zhengjie.yuangan.service.dto.FileUploadQueryCriteria;

import java.util.List;

/**
 * Created by Super on 2021/1/4.
 */
public interface FileUploadzwService {
    boolean addFile(FileList fileList);
    boolean updateFile(FileList quest);
    List<FileList> queryFileUploadList(FileUploadQueryCriteria quest);
    List<FilePath> queryFileUploadPersonListById(String quest);
}
