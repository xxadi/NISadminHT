package me.zhengjie.yuangan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.domain.UserDetails;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.val;
import me.zhengjie.utils.JsonDataUtils;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.SecurityUtils;
import me.zhengjie.yuangan.bean.GroupManager;
import me.zhengjie.yuangan.bean.QuestionBank;
import me.zhengjie.yuangan.mapper.QuestionBankMapper;
import me.zhengjie.yuangan.service.QuestionBankService;
import me.zhengjie.yuangan.service.dto.QuestionQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: SunKang
 * @Description:
 * @Date: Created in 9:42 2020/9/22
 */
@Service
public class QuestionBankServiceImpl implements QuestionBankService {
    @Autowired
    private QuestionBankMapper questionBankMapper;

    @Override
    public List<QuestionBank> findAllQuestion(Integer pageNum, Integer pageSize,String name,String attribute,String catagory,String level,
                                  String state) {
        if (name != null && name.length() != 0){
            name = "%" + name + "%";
        }
//        PageHelper.startPage(pageNum+1,pageSize);
        List<QuestionBank> questions = questionBankMapper.findAllQuestion(name, attribute, catagory, level, state);
        PageInfo<QuestionBank> page = new PageInfo<>(questions);
        String json = JsonDataUtils.getJson(page);
        return questions;
    }
    @RequestMapping("/queryQuestionListById")
    public QuestionBank queryQuestionListById(QuestionQueryCriteria quest){
        System.out.println(quest);
       QuestionBank list = null;
        list= questionBankMapper.questQuestionById(quest);
       List<Map<String,Object>> listAnswer =  questionBankMapper.questQuestionAnswerById(quest);
        System.out.println(listAnswer);
        System.out.println(list.getCorrectArray());
//       list.setCorrectArray(Collections.singletonList(listAnswer));
       list.setQuestItem(Collections.singletonList(listAnswer));
        return list;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertQuestion(QuestionBank questionBank) {
        System.out.println(questionBank);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        questionBank.setCreateTime(sdf.format(new Date()));
        questionBank.setQuestOperTime(sdf.format(new Date()));
        String str = "";
        Iterator<Object> iter = questionBank.getCorrectArray().iterator();
        System.out.println(iter);
        while (iter.hasNext()) {
            Object s = (Object) iter.next();
            if(str == ""){
                str = s.toString();
            }else {
                str +=  "," + s ;
            }

        }
        System.out.println(str);
        org.springframework.security.core.userdetails.UserDetails currentUser1 = SecurityUtils.getCurrentUser();
        questionBank.setQuestOperId(currentUser1.getUsername());

        System.out.println(SecurityUtils.getCurrentUsername());
        System.out.println(SecurityUtils.getCurrentUserId());
        questionBank.setQuestState("1");
        int result = questionBankMapper.insertQuestion(questionBank);
        System.out.println("----");
        System.out.println(questionBank);
        System.out.println(questionBank.getQuestId());
        questionBankMapper.insertQuestionAnswer(questionBank.getQuestItem(),questionBank.getQuestId());
        if (result != 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateQuestion(QuestionBank questionBank) {
        System.out.println(questionBank);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        questionBank.setCreateTime(sdf.format(new Date()));
        questionBank.setQuestOperTime(sdf.format(new Date()));
        String str = "";
        Iterator<Object> iter = questionBank.getCorrectArray().iterator();
        System.out.println(iter);
        while (iter.hasNext()) {
            Object s = (Object) iter.next();
            if(str == ""){
                str = s.toString();
            }else {
                str +=  "," + s ;
            }

        }
        System.out.println(str);
        System.out.println(SecurityUtils.getCurrentUsername());
        System.out.println(SecurityUtils.getCurrentUserId());
        questionBank.setQuestState("1");
        questionBankMapper.updateQuestion(questionBank);

        questionBankMapper.deleteQuestionAnswer(questionBank.getQuestId());
        questionBankMapper.insertQuestionAnswer(questionBank.getQuestItem(),questionBank.getQuestId());
        return false;
    }

    @Override
    public boolean stopUse(String questId) {
        int i = questionBankMapper.stopUse(questId);
        if (i != 0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean deleteQuestion(String questId) {
        int i = questionBankMapper.deleteQuestion(questId);
        if (i != 0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean startUse(String questId) {
        int i = questionBankMapper.startUse(questId);
        if (i != 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteQuestionState(String questId) {
        return false;
    }


}
