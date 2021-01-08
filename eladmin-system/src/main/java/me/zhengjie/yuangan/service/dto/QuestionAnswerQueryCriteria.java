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

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author Zhou Wang
 * 公共查询类
 */
@Data
public class QuestionAnswerQueryCriteria {

    @Query
    private Long id;
    @Query
    private Long qid;
    @Query
    private String context;
    @Query
    private String sort;
    @Query
    private String remark;
    @Query
    private String state;
    @Query
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @Query
    private Date update_time;
}
