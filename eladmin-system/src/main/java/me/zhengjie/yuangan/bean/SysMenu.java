package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/8.
 */

import lombok.Data;

/**
 * @description: 菜单表
 * @author: ZhouW
 * @time: 2020/9/8 9:02
 */
@Data
public class SysMenu {
    //菜单id
    private String menuId;
    //是否展示
    private String isShow;
    //菜单等级
    private String menuGrade;
    //菜单图片
    private String menuIcon;
    //菜单名称
    private String menuName;
    //菜单路径
    private String menuUrl;
    //父节点id
    private String parentId;
    //排序
    private String sortId;
}
