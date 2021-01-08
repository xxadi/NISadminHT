package me.zhengjie.yuangan.mapper;

import me.zhengjie.config.DataSource;
import me.zhengjie.yuangan.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 编码值表操作
 *
 * @ClassName IMedEmrCodeMapper
 * @Author zhuzhh
 * @Date 2020/7/22
 */
@Mapper
@Repository
public interface IMedNisAddUserMapper {

    /**
     * @author:ZhouW
     * @date: 2020/09/08 14:54
     * @param user
     * @description: TODO 添加账号
     * @return:com.medsys.nis.maintain.bean.User
    */
    boolean addUser(User user);
    /**
     * @author:ZhouW
     * @date: 2020/09/21 14:44
     * @param

     * @description: TODO 查询所有人员
     * @return:boolean
     */
    List<User> queryUserList(@Param("user")String user, @Param("deptcode")String dept, @Param("role")String role, @Param("job")String job);
    /**
     * @author:ZhouW
     * @date: 2020/09/21 14:44
     * @param user

     * @description: TODO 修改账号
     * @return:boolean
    */
    boolean updateUser(User user);

    /**
     * @author:ZhouW
     * @date: 2020/09/21 14:44
     * @param userid

     * @description: TODO 删除账号
     * @return:boolean
     */
    boolean deleteUser(String userid);
}
