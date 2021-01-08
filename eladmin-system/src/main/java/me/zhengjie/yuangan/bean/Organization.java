package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;

import java.util.Date;

/**
 * @description: 组织架构表
 * @author: ZhouW
 * @time: 2020/9/7 22:18
 */
@Data
public class Organization {
    //组织id
    private String ogId;
    //父节点id
    private String parentId;
    //角色职责
    private String ogRoleduty;
    //人员id
    private String personId;
    //创建时间
    private Date ogTime;
}
