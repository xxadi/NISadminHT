package me.zhengjie.yuangan.service;

import me.zhengjie.yuangan.bean.GroupManager;

import java.util.List;
import java.util.Map;

/**
 * Created by Super on 2020/8/10.
 */
public interface GroupManagerService {
    boolean addUser(String user,String seq);
    boolean updateUser(String user,String seq,List<Map<String,Object>> list);
    boolean addUserDetail(GroupManager user);
    List<GroupManager> queryGroupList(String name);
    /**
     * @return String
     * @author Zw
     * @Description 查询seq序列号
     * @Date 16:11 2019/6/11
     * @Param []
     */
    String querySeq();


    List<Map<String,Object>> queryGroupListById(String groupId);
/**
 * @author:ZhouW
 * @date: 2020/10/10 16:15
 * @param groupId

 * @description: TODO
 * @return:boolean
*/
    boolean deleteGroup(String groupId);

}
