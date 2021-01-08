package me.zhengjie.yuangan.service.impl; /**
 * Created by Super on 2020/8/10.
 */


import me.zhengjie.yuangan.bean.GroupManager;
import me.zhengjie.yuangan.mapper.IMedNisGroupManagerMapper;
import me.zhengjie.yuangan.orclmapper.IMedNisCommonMapper;
import me.zhengjie.yuangan.service.GroupManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/10 11:09
 */
@Service
public class GroupManagerServiceImpl implements GroupManagerService {

    @Autowired
    private IMedNisGroupManagerMapper dao;

    @Autowired
    private IMedNisCommonMapper iMedNisCommonMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean  addUser(String user,String seq) {
        System.out.println("GroupManagerImp"+user +seq);

         return   dao.addGroup(user,seq);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(String groupName, String seq,List<Map<String,Object>> personList) {
if(  dao.editGroup(groupName,seq))
        {
            if(dao.deleteGroupInfo(seq))
            {
                for (int i = 0; i < personList.size(); i++) {
                    GroupManager groupManager = new GroupManager();
                    groupManager.setGroupGname(groupName);
                    groupManager.setGroupId(seq);
                    groupManager.setGroupName(personList.get(i).get("name").toString());
                    groupManager.setGroupNameCpde(personList.get(i).get("id").toString());
                    dao.addUserDetail(groupManager);
                }
            }
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addUserDetail(GroupManager user) {
        return dao.addUserDetail(user);
    }

    @Override
    public List<GroupManager> queryGroupList(String groupName) {

        return dao.queryGroupList(groupName);
//        return iMedNisCommonMapper.queryAnti();
    }
    /**
     * @return String
     * @author Zw
     * @Description 查询seq序列号
     * @Date 16:10 2020/10/9
     * @Param []
     */
    @Override
    public String querySeq() {
        return dao.querySeqNum();
    }

    @Override
    public List<Map<String, Object>> queryGroupListById(String groupId) {
        return dao.queryGroupListById(groupId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteGroup(String groupId) {
        return dao.deleteGroup(groupId);
    }
}
