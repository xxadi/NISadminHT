package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/8.
 */

import lombok.Data;

import java.util.Date;

/**
 * @description: 用户和角色的关联表
 * @author: ZhouW
 * @time: 2020/9/8 9:14
 */
@Data
public class UserRoles {
    //id
    private String id;
    //权限ID
    private String roleId;
    //用户ID
    private String userId;
    //创建时间
    private Date createdTime;
    //权限类型
    private String rightType;
}
