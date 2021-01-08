package me.zhengjie.yuangan.mapper;


import me.zhengjie.yuangan.bean.GroupManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 编码值表操作
 *
 * @ClassName IMedEmrCodeMapper
 * @Author zhuzhh
 * @Date 2020/7/22
 */
@Mapper
@Repository
public interface IMedNisGroupManagerMapper {

    /**
     * @author:ZhouW
     * @date: 2020/09/08 14:54
     * @param user
     * @description: TODO 添加组
     * @return:com.medsys.nis.maintain.bean.GroupManager
    */
    boolean addGroup(@Param("groupGname")String user, @Param("groupId")String seq);
    /**
     * @author:ZhouW
     * @date: 2020/09/08 14:54
     * @param user
     * @description: TODO 编辑组
     * @return:com.medsys.nis.maintain.bean.GroupManager
     */
    boolean editGroup(@Param("groupGname")String user, @Param("groupId")String seq);

    List<GroupManager> queryGroupList(@Param("groupName")String groupName);

    /**
     * @author:ZhouW
     * @date: 2020/09/08 14:54
     * @param user
     * @description: TODO 添加组人员
     * @return:com.medsys.nis.maintain.bean.GroupManager
     */
    boolean addUserDetail(GroupManager user);

    String querySeqNum();

    List<Map<String,Object>> queryGroupListById(String groupId);

    /**
     * @return boolean
     * @author Zw
     * @Description groupId 删除组人员
     * @Date 15:48 2020/10/10
     */
    boolean deleteGroupInfo(String groupId);

    /**
     * @return boolean
     * @author Zw
     * @Description groupId 删除组
     * @Date 15:48 2020/10/10
     */
    boolean deleteGroup(String groupId);
}
