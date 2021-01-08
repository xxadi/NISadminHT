package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/10/13.
 */

import lombok.Data;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/10/13 13:27
 */
@Data
public class SystemDic {
    private String dicSeq;		//字典seq
    private String dicId;		//字典id
    private String dicName;		//字典名字
    private String dicDemo;		//字典描述
    private String dicIsShow;		//字典是否可用
    private String dicTypeId;		//字典类型
    private String dicShortCut;		//字典排序
}
