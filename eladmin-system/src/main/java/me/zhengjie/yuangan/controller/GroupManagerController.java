package me.zhengjie.yuangan.controller; /**
 * Created by Super on 2020/8/10.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.zhengjie.modules.system.service.dto.DeptDto;
import me.zhengjie.modules.system.service.dto.RoleDto;
import me.zhengjie.utils.JsonDataUtils;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.yuangan.bean.GroupManager;
import me.zhengjie.yuangan.service.GroupManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/10 10:58
 */
@RestController
@RequestMapping("api/groupManager")
public class GroupManagerController {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(me.zhengjie.yuangan.controller.GroupManagerController.class);
    @Autowired
    private GroupManagerService groupManagerService;

    @GetMapping("/queryGroupList")
    public ResponseEntity<Object> queryGroupList(GroupManager map,Pageable pageable){
        logger.info("queryGroupList",map);
        System.out.println("map" +map);
        PageHelper.startPage(pageable.getPageNumber()+1,pageable.getPageSize());
        String userName =  map.getGroupGname()==""?"":map.getGroupGname();
        System.out.println("userName"+ userName);
        PageInfo<GroupManager> list = new PageInfo<>(groupManagerService.queryGroupList(userName));
        System.out.println(list);
        return new ResponseEntity<Object>( PageUtil.toPage(list.getList(),list.getTotal()), HttpStatus.OK);
    }

    @PostMapping("/saveGroup")
    public ResponseEntity<Object> toAdd(@RequestBody Map<String,Object> map) throws Exception {
        System.out.println(map);
        boolean flag;
        String personList1 = JsonDataUtils.getJson(map);
        List<GroupManager> jsonArray = JSON.parseArray(JSON.parseObject(personList1).getString("personList"), GroupManager.class);
        System.out.println(jsonArray.get(0));
        String groupName = "";
        groupName = map.get("name").toString();
        List<Map<String,Object>> personList = (List<Map<String,Object>>) map.get("personList");
         if(personList != null && personList.size()>0){
             System.out.println(personList.get(0));
             String str = JSON.toJSONString(personList);
            String seq = GroupManagerController.generateUUID();
             flag = groupManagerService.addUser(groupName,seq);
             if (!flag) {
                 logger.info("组管理保存失败：" + groupName);
                 return new ResponseEntity<Object>("", HttpStatus.EXPECTATION_FAILED);
             }
             // 1. 普通遍历方式
             for (int i = 0; i < personList.size(); i++) {

                 GroupManager groupManager = new GroupManager();
                 groupManager.setGroupGname(groupName);
                 groupManager.setGroupId(seq);
                 groupManager.setGroupName(personList.get(i).get("name").toString());
                 groupManager.setGroupNameCpde(personList.get(i).get("id").toString());
                 groupManagerService.addUserDetail(groupManager);
             }
         }

        return new ResponseEntity<Object>(PageUtil.toPage("","","保存成功"), HttpStatus.OK);
    }

    @PostMapping("/editGroup")
    public ResponseEntity<Object> toUpdate(@RequestBody Map<String,Object> map){
        System.out.println(map);
        boolean flag;
        String personList1 = JsonDataUtils.getJson(map);
        List<GroupManager> jsonArray = JSON.parseArray(JSON.parseObject(personList1).getString("personList"), GroupManager.class);
        System.out.println(jsonArray.get(0));
        String groupName = "";
        groupName = map.get("name").toString();
        List<Map<String,Object>> personList = (List<Map<String,Object>>) map.get("personList");
        if(personList != null && personList.size()>0){
            System.out.println(personList.get(0));
            String str = JSON.toJSONString(personList);
            String seq  = map.get("groupId").toString();
            flag = groupManagerService.updateUser(groupName,seq,personList);
            if (!flag) {
                logger.info("组管理修改失败：" + groupName);
                return new ResponseEntity<Object>( HttpStatus.EXPECTATION_FAILED);
            }
        }
        return new ResponseEntity<Object>( HttpStatus.OK);
    }

    @RequestMapping("/queryGroupListById")
    public ResponseEntity<Object> queryGroupListById( GroupManager map){
        System.out.println(map);
        String userName =  map.getGroupId()==""?"":map.getGroupId();
        System.out.println(userName);
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        list= groupManagerService.queryGroupListById(userName);


        JSONObject result = new JSONObject();
        result.put("employees",list);
        return new ResponseEntity<Object>(PageUtil.toPage(result,result.size()), HttpStatus.OK);
    }

    @RequestMapping("/deleteGroup")
    public ResponseEntity<Object> deleteUser( @RequestBody Long ids){
        System.out.println(ids);

        boolean flag = groupManagerService.deleteGroup(ids.toString());
        if(flag){
            return  new ResponseEntity<Object>(HttpStatus.OK);
        }
        return  new ResponseEntity<Object>(HttpStatus.EXPECTATION_FAILED);
    }


    static int number1 = 0;
    public static String generateUUID() throws Exception {
        String string = null;
        try {
            String date = String.valueOf(System.currentTimeMillis());
            number1++;
            String num = "00000" + String.valueOf(number1);
            num = num.substring(num.length() - 5, num.length());
            string = date + num;
            if (number1 == 99999) {
                number1 = 0;
            }
        } catch (Exception e) {
            logger.error(e.toString());
            throw new Exception(e.getMessage());
        }
        System.out.println(string);
        return string;
    }
}
