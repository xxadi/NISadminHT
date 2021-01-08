package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;

import java.util.Date;

/**
 * @description: 扣分项管理
 * @author: ZhouW
 * @time: 2020/9/7 20:46
 */
@Data
public class AddPointsManager {
    //扣分id
    private String apId;
    //父节点id
    private String parentId;
    //扣分项
    private String apName;
    //扣分值
    private String apNumber;
    //创建时间
    private Date apTime;
}
