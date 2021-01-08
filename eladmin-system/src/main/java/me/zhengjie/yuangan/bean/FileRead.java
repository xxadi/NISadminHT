package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;

/**
 * @description: 文件是否已读
 * @author: ZhouW
 * @time: 2020/9/7 21:58
 */
@Data
public class FileRead {
    //文件id
    private String fileId;
    //订阅id
    private String pathId;
    //是否已读
    private String pathIsread;
}
