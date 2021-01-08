package me.zhengjie.yuangan.orclmapper;


import me.zhengjie.config.DataSource;
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
public interface IMedNisCommonMapper {

    @DataSource("orclDb")
    List<GroupManager> queryAnti();

}
