package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/8/10.
 */

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/10 11:07
 */
public class Permissions {
    private String id;
    private String permissionsName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }
    public Permissions(String id, String permissionsName) {
        this.id = id;
        this.permissionsName = permissionsName;
    }
}
