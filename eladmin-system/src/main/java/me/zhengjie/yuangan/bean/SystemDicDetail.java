package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/10/13.
 */

import lombok.Data;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/10/14 11:27
 */
@Data
public class SystemDicDetail {
    private String dicdId;		//字典id
    private String dicdName;		//字典名字
    private String dicdDemo;		//字典描述
    private String dicdIsShow;		//字典是否可用
    private String dicdShortCut;		//字典是否可用
}
