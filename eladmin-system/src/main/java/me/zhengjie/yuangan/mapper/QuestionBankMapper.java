package me.zhengjie.yuangan.mapper;

import me.zhengjie.yuangan.bean.QuestionBank;
import me.zhengjie.yuangan.service.dto.QuestionQueryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: SunKang
 * @Description:
 * @Date: Created in 9:27 2020/9/22
 */
@Mapper
@Repository
public interface QuestionBankMapper  {
    int insertQuestion(QuestionBank questionBank);
    int updateQuestion(QuestionBank questionBank);
    List<QuestionBank> findAllQuestion(String name, String attribute, String catagory, String questDifficulty,
                                       String state);
    int stopUse(String questId);
    int deleteQuestion(String questId);
    int startUse(String questId);
    int insertQuestionAnswer(@Param("list") List<Object> list, @Param("id") String id);
    int deleteQuestionAnswer(@Param("id") String id);

    QuestionBank questQuestionById(QuestionQueryCriteria quest);

    List<Map<String,Object>> questQuestionAnswerById(QuestionQueryCriteria quest);
}
