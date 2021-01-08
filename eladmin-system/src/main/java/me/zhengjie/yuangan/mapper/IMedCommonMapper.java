package me.zhengjie.yuangan.mapper;


import me.zhengjie.yuangan.bean.SystemDic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Super on 2020/10/10.
 */
@Mapper
@Repository
public interface IMedCommonMapper {
    /**
     * @author:ZhouW
     * @date: 2020/10/13 14:44
     * @param dic

     * @description: TODO 创建字典
     * @return:boolean
     */
    boolean saveDic(SystemDic dic);
/**
 * @author:ZhouW
 * @date: 2020/10/13 16:46
 * @param dicName

 * @description: TODO 查询字典
 * @return:java.util.List<com.medsys.nis.maintain.bean.SystemDic>
*/
    List<SystemDic> queryDicList(@Param("dicName")String dicName);
    /**
     * @author:ZhouW
     * @date: 2020/10/13 14:44
     * @param dic

     * @description: TODO 修改字典
     * @return:boolean
     */
    boolean updateDic(SystemDic dic);
    /**
     * @author:ZhouW
     * @date: 2020/10/13 14:44
     * @param dic

     * @description: TODO 创建字典详情
     * @return:boolean
     */
    boolean saveDicDetails(SystemDic dic);
    /**
     * @author:ZhouW
     * @date: 2020/10/13 16:46
     * @param dicTypeId

     * @description: TODO 查询字典详情
     * @return:java.util.List<com.medsys.nis.maintain.bean.SystemDic>
     */
    List<SystemDic> queryDicDetailsList(@Param("dicTypeId")String dicTypeId);
    /**
     * @author:ZhouW
     * @date: 2020/10/13 14:44
     * @param dic

     * @description: TODO 修改字典详情
     * @return:boolean
     */
    boolean updateDicDetails(SystemDic dic);

    /**
     * @author:ZhouW
     * @date: 2020/10/14 19:44
     * @param seq

     * @description: TODO 删除字典
     * @return:boolean
     */
    boolean deteleDic(String seq);
    /**
     * @author:ZhouW
     * @date: 2020/10/13 16:46
     * @param dicSeq

     * @description: TODO 查询字典详情By Seq
     * @return:java.util.List<com.medsys.nis.maintain.bean.SystemDic>
     */
    List<SystemDic> queryDicDetailsBySeq(@Param("dicSeq")String dicSeq);
}
