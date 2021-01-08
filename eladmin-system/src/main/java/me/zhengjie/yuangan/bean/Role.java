package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/8/10.
 */


import lombok.Data;

import java.util.Set;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/10 11:07
 */
@Data
public class Role {
    //ID
    private String id;
    //角色名称
    private String roleName;
    //父级角色ID
    private String parentId;
    //是否可用
    private String activity;



    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    /**
     * 角色对应权限集合
     */

    private Set<Permissions> permissions;

    public Role(String id, String roleName, Set<Permissions> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.permissions = permissions;
    }


}
