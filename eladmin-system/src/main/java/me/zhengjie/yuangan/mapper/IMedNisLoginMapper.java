package me.zhengjie.yuangan.mapper;


import me.zhengjie.yuangan.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 编码值表操作
 *
 * @ClassName IMedEmrCodeMapper
 * @Author zhuzhh
 * @Date 2020/7/22
 */
@Mapper
@Repository
public interface IMedNisLoginMapper {

    /**
     * @author:ZhouW
     * @date: 2020/09/08 14:54
     * @param userName
     * @param password
     * @description: TODO
     * @return:com.medsys.nis.maintain.bean.User
    */
    User queryUser(@Param("userName") String userName);


}
