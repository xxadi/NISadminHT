package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/8.
 */

import lombok.Data;

/**
 * @description: 角色权限关系表
 * @author: ZhouW
 * @time: 2020/9/8 8:55
 */
@Data
public class RolePermission {
    //id
    private String id;
    //角色id
    private String roleId;
    //菜单id
    private String menuId;
    //权限类型
    private String rightType;
    //是否显示
    private String isShow;

}
