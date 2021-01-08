package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 文件详细信息表
 * @author: ZhouW
 * @time: 2020/9/7 21:35
 */
@Data
public class FileList {
    //文件id
    private String fileId;
    //文件名称
    private String fileName;
    //文件路径
    private String filePath;
    //文件后缀
    private String fileSuffix;
    //后端返回格式
    private String contentType;
    //文件路径id
    private String pathId;
    //文件大小
    private String  fileSize;
    //上传时间
    private Date uploadTime;
    //文件拥有者id
    private String fileUserId;
    //是否分享
    private String fileIsshare;
    //发布时间
    private Date filePublish;
    //是否全员可见
    private String fileIsall;
    //是否可下载
    private String fileIsdownload;
    //文章状态 0隐藏1可见
    private String fileState;
    // 可见人数
    private String fileNum;


    private List<Map<String,String>> filePathList;
}
