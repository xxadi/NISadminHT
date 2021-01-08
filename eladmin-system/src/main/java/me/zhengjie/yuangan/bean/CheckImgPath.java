package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;

import java.util.Date;

/**
 * @description: 检查图片路径表
 * @author: ZhouW
 * @time: 2020/9/7 21:09
 */
@Data
public class CheckImgPath {
    //图片id
    private String imgId;
    //图片路径
    private String imgPath;
    //创建时间
    private Date imgTime;

}
