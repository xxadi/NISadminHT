package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;

import java.util.Date;

/**
 * @description: 通知订阅表
 * @author: ZhouW
 * @time: 2020/9/7 22:11
 */
@Data
public class NobkPath {
    //订阅id
    private String nobkId;
    //fileid
    private String parentId;
    //所属人姓名
    private String nobkUserName;
    //所属人id
    private String nobkUserId;
    //是否已读
    private String nobkIsread;
    //创建时间
    private Date nobkTime;
}
