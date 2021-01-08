package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;

/**
 * @description: 检查管理表
 * @author: ZhouW
 * @time: 2020/9/7 21:21
 */
@Data
public class CheckManager {
    //检查id
    private String ckId;
    //被查科室
    private String ckDept;
    //二级扣分项id
    private String ckTwolevel;
    //提交时间
    private String ckCreatetime;
    //备注
    private String ckDemo;
    //提交人
    private String ckName;
    //问题描述
    private String ckProblem;
    //图片路径id
    private String ckImgpathid;
    //验收信息id
    private String ckBakid;
    //审核人姓名
    private String ckCheckname;
    //审核人id
    private String ckCheckid;
    //审核时间
    private String ckChecktime;
    //审核状态
    private String ckState;
    //驳回原因
    private String ckReason;

}
