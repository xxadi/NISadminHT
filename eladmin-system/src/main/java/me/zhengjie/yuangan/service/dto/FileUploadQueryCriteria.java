/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package me.zhengjie.yuangan.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.zhengjie.annotation.Query;

import java.util.Date;

/**
 * @author Zhou Wang
 * 文件上传类
 */
@Data
public class FileUploadQueryCriteria {

    @Query
    @ApiModelProperty(value = "文件名称")
    private String name;
    @Query
    @ApiModelProperty(value = "文章状态")
    private String catagory;
    @Query
    @ApiModelProperty(value = "开始时间")
    private Date createTime;
    @Query
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
}
