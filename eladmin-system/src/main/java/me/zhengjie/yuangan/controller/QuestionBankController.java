package me.zhengjie.yuangan.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.SecurityUtils;
import me.zhengjie.yuangan.bean.GroupManager;
import me.zhengjie.yuangan.bean.QuestionBank;
import me.zhengjie.yuangan.service.QuestionBankService;
import me.zhengjie.yuangan.service.dto.QuestionAnswerQueryCriteria;
import me.zhengjie.yuangan.service.dto.QuestionQueryCriteria;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: SunKang
 * @Description:
 * @Date: Created in 9:40 2020/9/22
 */
@RestController
@RequestMapping("api/quest")
public class QuestionBankController {
    @Autowired
    private QuestionBankService questionBankService;

    @GetMapping("/queryQuestionListById")
    public ResponseEntity<Object> queryQuestionListById(QuestionQueryCriteria map, Pageable pageable){
        System.out.println(map.getName()+ map.getAttribute());
        PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());
        QuestionBank questDtos =  questionBankService.queryQuestionListById(map);
        return new ResponseEntity<Object>(questDtos, HttpStatus.OK);
    }

    @GetMapping("/findAllQuestion")
    public ResponseEntity<Object> findAllNotes(QuestionQueryCriteria map, Pageable pageable){
        System.out.println(map.getName()+ map.getAttribute());
        PageHelper.startPage(pageable.getPageNumber()+1,pageable.getPageSize());
        List<QuestionBank> questDtos =  questionBankService.findAllQuestion(pageable.getPageNumber(),pageable.getPageSize(),map.getName(),map.getAttribute(),map.getCatagory(),map.getQuestDifficulty(),map.getState());
        PageInfo<QuestionBank> page = new PageInfo<>(questDtos);
        return new ResponseEntity<Object>(PageUtil.toPage(page.getList(),page.getTotal()), HttpStatus.OK);
    }
    
    @PostMapping("/stopUse")
    public boolean stopUse(@PathVariable  String questId){
        return questionBankService.stopUse(questId);
    }

    @PostMapping("/insert")
    public ResponseEntity<Object> insertQuestion(@RequestBody QuestionBank quest){
        System.out.println(quest);
        if (null == quest.getQuestId()) {
            questionBankService.insertQuestion(quest);
        } else {
            questionBankService.updateQuestion(quest);
        }
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @GetMapping("/stop")
    public ResponseEntity<Object> stop( QuestionBank quest) {
        System.out.println(quest);
         questionBankService.stopUse(quest.getQuestId());
        return new  ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/delete")
    public ResponseEntity<Object> delete( QuestionBank quest) {
        System.out.println(quest);
        questionBankService.deleteQuestion(quest.getQuestId());
        return new  ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/start")
    public ResponseEntity<Object> start( QuestionBank quest) {
        System.out.println(quest);
        questionBankService.startUse(quest.getQuestId());
        return new  ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
