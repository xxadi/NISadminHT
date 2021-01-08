package me.zhengjie.yuangan.mapper;

import me.zhengjie.yuangan.bean.FileList;
import me.zhengjie.yuangan.bean.FilePath;
import me.zhengjie.yuangan.service.dto.FileUploadQueryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文件上传操作
 *
 * @ClassName ImedNisFileUploadMapper
 * @Author zhouw
 * @Date 2021/1/4
 */
@Mapper
@Repository
public interface ImedNisFileUploadMapper {
    /**
     * @author:ZhouW
     * @date: 2021/01/04 15:11
     * @param fileList
     * @description: TODO 添加文件
     * @return:com.medsys.nis.maintain.bean.FileList
     */
    boolean addFile(FileList fileList);
    /**
     * @author:ZhouW
     * @date: 2021/01/7 15:11
     * @param fileList
     * @description: TODO 修改文件
     * @return:com.medsys.nis.maintain.bean.FileList
     */
    boolean updateFile(FileList fileList);

    /**
     * @author:ZhouW
     * @date: 2021/01/7 15:11
     * @param id
     * @description: TODO 删除文件人员
     * @return:com.medsys.nis.maintain.bean.FileList
     */
    int deleteFilePerson(@Param("id") String id);
    /**
     * @author:ZhouW
     * @date: 2021/01/04 15:11
     * @param filePath
     * @description: TODO 添加文件可见人员
     * @return:com.medsys.nis.maintain.bean.GroupManager
     */
    boolean addFilePerson(FilePath filePath);
    /**
     * @author:ZhouW
     * @date: 2021/01/17 13:46
     * @param criteria
     * @description: TODO 查询上传文件列表
     * @return:com.medsys.nis.maintain.bean.GroupManager
     */
    List<FileList> queryFileUploadList(FileUploadQueryCriteria criteria);
    /**
     * @author:ZhouW
     * @date: 2021/01/04 15:11
     * @param id
     * @description: TODO 查询文件上传人员byid
     * @return:com.medsys.nis.maintain.bean.GroupManager
     */
    List<FilePath> queryFileUploadListById(String id);
}
