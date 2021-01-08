package me.zhengjie.yuangan.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;
import me.zhengjie.annotation.Query;

import java.util.List;
import java.util.Map;

/**
 * @description: 题库表
 * @author: ZhouW
 * @time: 2020/9/7 22:21
 */
@Data
public class QuestionBank {
    //id
    private String questId;
    //题目
    private String questName;
    //操作人id
    private String questOperId;
    //操作人姓名
    private String questOperName;
    //操作时间
    private String questOperTime;
    //属性（0:选择 1:判断 2:填空）
    private String questType;
    //分类
    private String questTitle;
    //难度
    private String questDifficulty;
    //状态
    private String questState;
    //结果
    private String questResult;
    //创建时间
    private String createTime;
    //分析
    private String questAnalysis;
    //答案列表
    private List<Object> questItem;
    @Query
    private List<Object> correctArray;

    @Query
    private String score;

}
