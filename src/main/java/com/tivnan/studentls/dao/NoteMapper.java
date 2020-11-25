package com.tivnan.studentls.dao;

import com.tivnan.studentls.bean.Note;
import com.tivnan.studentls.bean.NoteExample;

import java.util.List;

import com.tivnan.studentls.bean.vo.NotesNeedReview;
import org.apache.ibatis.annotations.Param;

public interface NoteMapper {
    long countByExample(NoteExample example);

    int deleteByExample(NoteExample example);

    int deleteByPrimaryKey(String noteId);

    int insert(Note record);

    int insertSelective(Note record);

    List<Note> selectByExample(NoteExample example);

    Note selectByPrimaryKey(String noteId);

    int updateByExampleSelective(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByExample(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);

    long countNumOfAuditors(String noteId);

//    List<NoteWithStuName> getNotesNeedReview(Integer teacherId);

    List<NotesNeedReview> getNotesNeedReview(Integer teacherId);

//  int insertWithSelectedList(Note record);
}