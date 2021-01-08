package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/8/20.
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/20 15:24
 */
@Data
public class FileResult implements Serializable {
    //判断结果
    private boolean success;
    //返回信息
    private String message;
    //文件地址
    private String fileAddress;

    private String start;

    public FileResult(boolean success, String message,String fileAddress) {
        this.success = success;
        this.message = message;
        this.fileAddress = fileAddress;
    }

    public boolean isSuccess() {
        return success;
    }
}
