package me.zhengjie.yuangan.service;

import me.zhengjie.yuangan.bean.GroupManager;
import me.zhengjie.yuangan.bean.QuestionBank;
import me.zhengjie.yuangan.service.dto.QuestionAnswerQueryCriteria;
import me.zhengjie.yuangan.service.dto.QuestionQueryCriteria;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: SunKang
 * @Description:
 * @Date: Created in 9:41 2020/9/22
 */
public interface QuestionBankService {
    List<QuestionBank> findAllQuestion(Integer pageNum,
                                       Integer pageSize,
                                       String name, String attribute, String catagory, String level,
                                       String state);

    boolean insertQuestion(QuestionBank quest);
    boolean updateQuestion(QuestionBank quest);
    boolean deleteQuestion(String questId);
    boolean stopUse(String questId);
    boolean startUse(String questId);
    boolean deleteQuestionState(String questId);
    QuestionBank queryQuestionListById(QuestionQueryCriteria quest);

}
