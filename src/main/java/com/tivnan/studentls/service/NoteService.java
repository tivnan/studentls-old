package com.tivnan.studentls.service;

import com.tivnan.studentls.bean.Note;
import com.tivnan.studentls.bean.NoteExample;
import com.tivnan.studentls.dao.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @project: studentls
 * @description: service for note
 * @author: tivnan
 * @create: 2020-2020/11/23-下午4:08
 * @version: 1.0
 **/
@Service
public class NoteService {

    @Autowired
    NoteMapper noteMapper;

    public void saveNote(Note note) {

        Note note1 = noteMapper.selectByPrimaryKey(note.getNoteId());

        if (note1 != null) {
            noteMapper.updateByPrimaryKey(note);
        } else {
            noteMapper.insertSelective(note);
        }


    }


}
