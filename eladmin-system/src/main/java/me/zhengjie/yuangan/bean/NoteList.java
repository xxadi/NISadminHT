package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;

/**
 * @description: 通知详情表
 * @author: ZhouW
 * @time: 2020/9/7 22:15
 */
@Data
public class NoteList {
    //通知id
    private Integer noId;
    //通知标题
    private String noTitle;
    //通知内容
    private String noContent;
    //发布时间
    private String noTime;
    //创建时间
    private String operTime;
    //通知状态
    private Integer noState;
}
