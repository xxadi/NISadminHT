package me.zhengjie.yuangan.mapper;

import me.zhengjie.yuangan.bean.NoteList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: SunKang
 * @Description:
 * @Date: Created in 16:53 2020/9/1
 */
@Mapper
@Repository
public interface NoteMapper {
    int deleteByNoId(Integer noId);
    int totalCount(@Param("noTitle")String noTitle, @Param("startDate") String startDate, @Param("endDate")String endDate, @Param("noState")Integer noState);
    List<NoteList> findAllNotes(@Param("title")String title, @Param("startDate") String startDate, @Param("endDate")String endDate, @Param("state")String state);
    int insertNote(NoteList noteList);
    NoteList findNoteById(@Param("id")Integer id);
    int updateNote(NoteList noteList);
}
