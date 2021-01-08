package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;

/**
 * @description: 文件订阅表
 * @author: ZhouW
 * @time: 2020/9/7 21:55
 */
@Data
public class FilePath extends User{
    //订阅id
    private String pathId;
    //fileid
    private String parentId;
    //文件所属人
    private String pathUserName;
    //文件所属人id
    private String pathUserId;
    //是否已读
    private String pathIsread;
    //是否下载
    private String pathIsdown;
}
