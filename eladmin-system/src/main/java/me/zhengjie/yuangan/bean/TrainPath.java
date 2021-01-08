package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/8.
 */

import lombok.Data;

/**
 * @description: 培训订阅表
 * @author: ZhouW
 * @time: 2020/9/8 9:27
 */
@Data
public class TrainPath {
    //培训订阅id
    private String pathId;
    //培训id
    private String parentId;
    //培训所属人
    private String pathUserName;
    //培训所属人id
    private String pathUserId;
    //培训时间
    private String pathTime;
    //完成状态 0未参加1已参加2已完成
    private String pathState;
    //操作时间
    private String operTime;
}
