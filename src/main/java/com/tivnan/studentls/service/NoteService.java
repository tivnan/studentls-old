package com.tivnan.studentls.service;

import com.tivnan.studentls.bean.*;
import com.tivnan.studentls.bean.vo.NoteWithStuName;
import com.tivnan.studentls.bean.vo.Section;
import com.tivnan.studentls.dao.HitsMapper;
import com.tivnan.studentls.dao.NoteMapper;
import com.tivnan.studentls.dao.ReviewMapper;
import com.tivnan.studentls.dao.SelectedMapper;
import com.tivnan.studentls.utils.SEToDates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    HitsMapper hitsMapper;

    @Autowired
    SelectedMapper selectedMapper;

    @Autowired
    SectionService sectionService;

    @Autowired
    ReviewMapper reviewMapper;

    public int saveNote(Note note) {

        Note note1 = noteMapper.selectByPrimaryKey(note.getNoteId());

        if (note1 != null) {
            return noteMapper.updateByPrimaryKey(note);
        } else {
            return noteMapper.insertSelective(note);
        }


    }

    public Note queryNoteByNoteId(String noteId) {

        Note note = noteMapper.selectByPrimaryKey(noteId);
        return note;
    }

    public List<Note> getSubmitNotes(Integer studentId, int i) {

        NoteExample example = new NoteExample();
        NoteExample.Criteria criteria = example.createCriteria();
        criteria.andStudentIdEqualTo(studentId);
        if (i != 2) {
            criteria.andStateEqualTo(i);
        } else {
            criteria.andStateGreaterThanOrEqualTo(2);
        }

        List<Note> notes = noteMapper.selectByExample(example);

        return notes;
    }

    public Boolean submitNote(Note note, List<String> selectedList) {

        String noteId = UUID.randomUUID().toString().substring(0, 20);

        note.setNoteId(noteId);

        note.setState(selectedList.size() + 1);

//        插入hits
        for (String s : selectedList) {
            hitsMapper.insert(new HitsKey(noteId, Integer.parseInt(s)));
        }

//        插入selected
        for (String s : selectedList) {
            selectedMapper.insert(new Selected(noteId, s));
        }

        int i = saveNote(note);

        if (i != 0) {
            return Boolean.TRUE;
        }


        return Boolean.FALSE;

        //        保存进去note
//        int i = saveNote(note);
//
//
//        String startTime = note.getStartTime();
//        String endTime = note.getEndTime();
//
//        List<String> dates = SEToDates.SEToDates(startTime, endTime);
//
////        获取到的课程小节
//        List<Section> sections = sectionService.getSection(dates, String.valueOf(note.getStudentId()));
//
//        HashSet<Integer> ints = new HashSet<Integer>();
//
////每一个课程最小粒度的请假单id
//        for (Section section : sections) {
//            ints.add(section.getId());
//        }
//
////        插入hits
//        for (Integer anInt : ints) {
//            hitsMapper.insert(new HitsKey(note.getNoteId(), anInt));
//        }
//
////求出涉及的课程数目
//        long NumOfAuditors = noteMapper.countNumOfAuditors(note.getNoteId());
//
//        note.setState(NumOfAuditors + 1);


        //        保存进去note
//        int i = saveNote(note);


    }

    public List<NoteWithStuName> getNotesNeedReview(Integer teacherId) {
        List<NoteWithStuName> notesNeedReview = noteMapper.getNotesNeedReview(teacherId);
        return notesNeedReview;
    }

    public int verifyNote(String noteId, String opinion, Integer id) {
        Note note = noteMapper.selectByPrimaryKey(noteId);

        if ("agree".equals(opinion)) {
            if (note.getState() >= 2) {
                note.setState(note.getState() - 1);

                reviewMapper.insert(new Review(noteId, id));

                return noteMapper.updateByPrimaryKeySelective(note);
            }
        } else {
            note.setState(-1);
            return noteMapper.updateByPrimaryKeySelective(note);
        }


        return 0;
    }
}
