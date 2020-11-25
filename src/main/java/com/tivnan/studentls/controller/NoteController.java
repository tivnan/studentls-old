package com.tivnan.studentls.controller;

import com.tivnan.studentls.bean.Note;
import com.tivnan.studentls.bean.vo.NoteWithStuName;
import com.tivnan.studentls.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: studentls
 * @description: controller for note
 * @author: tivnan
 * @create: 2020-2020/11/23-下午4:07
 * @version: 1.0
 **/
@Controller
public class NoteController {

    @Autowired
    NoteService noteService;

//    请假单状态state
//    0: 审核拒绝
//    1： 审核通过
//    >=2: 提交，正在审核
//    -1：未完成的请假单


    //    保存未完成的请假单
    @ResponseBody
    @RequestMapping(value = "/student/note/{noteId}", method = RequestMethod.POST)
    public HashMap<String, Object> saveNote(@RequestBody Note note) {
//    public HashMap<String, Object> saveNote(@RequestParam("id") Integer id,
//                                            @RequestParam("startTime") String startTime,
//                                            @RequestParam("endTime") String endTime,
//                                            @RequestParam("content") String content,
//                                            @RequestParam("type") Integer type,
//                                            @RequestParam("noteId") String noteId) {
//
//        Note note = new Note(noteId, startTime, endTime, content, 0, type, id);


        //传过来学生studetId，开始时间startTime,结束时间endTime,请假内容content，请假类型type
        //note_id,start_time,end_time,content,state,type,student_id

        note.setState(-1);

//        System.out.println(note);

        HashMap<String, Object> map = new HashMap<>();

        noteService.saveNote(note);
        map.put("isSavedSuccess", Boolean.TRUE);
        return map;


//        if (note.getNoteId() == null) {
////            完全新的请假单
//            String s = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
//            note.setNoteId(s);
//            noteService.saveNote(note);
//            map.put("noteId", s);
//            return map;
//        } else {
//            noteService.updateNote(note);
//            map.put("noteId", note.getNoteId());
//            return map;
//        }

    }

    //    提交请假单
    @ResponseBody
    @RequestMapping(value = "/student/note", method = RequestMethod.POST)
    public HashMap<String, Object> submitNote(@RequestBody Map<String, Object> map) {
//    public HashMap<String, Object> saveNote(@RequestParam("id") Integer id,
//                                            @RequestParam("startTime") String startTime,
//                                            @RequestParam("endTime") String endTime,
//                                            @RequestParam("content") String content,
//                                            @RequestParam("type") Integer type,
//                                            @RequestParam("noteId") String noteId) {
//
//        Note note = new Note(noteId, startTime, endTime, content, 0, type, id);

        String startTime = (String) map.get("startTime");
        String endTime = (String) map.get("endTime");
        String content = (String) map.get("content");
        Integer type = (Integer) map.get("type");
        Integer studentId = (Integer) map.get("studentId");

        List<String> selectedList = (List<String>) map.get("selectedList");


        Note note = new Note(startTime, endTime, content, type, studentId);

        Boolean aBoolean = noteService.submitNote(note,selectedList);


        HashMap<String, Object> map1 = new HashMap<>();
        //传过来学生studetId，开始时间startTime,结束时间endTime,请假内容content，请假类型type
        //note_id,start_time,end_time,content,state,type,student_id

//        note.setState(1);

//        System.out.println(note);


        map.put("isSubmitSuccess", aBoolean);
        return map1;


//        if (note.getNoteId() == null) {
////            完全新的请假单
//            String s = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
//            note.setNoteId(s);
//            noteService.saveNote(note);
//            map.put("noteId", s);
//            return map;
//        } else {
//            noteService.updateNote(note);
//            map.put("noteId", note.getNoteId());
//            return map;
//        }

    }

    //    获取之前保存且未提交的请假单
    @ResponseBody
    @RequestMapping(value = "/student/note/{noteId}", method = RequestMethod.GET)
    public HashMap<String, Object> loadUnfinishedNote(@PathVariable String noteId) {

        Note note = noteService.queryNoteByNoteId(noteId);

        HashMap<String, Object> map = new HashMap<>();

//        System.out.println(note);


        map.put("unfinishedList", note);

        return map;


    }


    //    获取学生提交过的请假单
    @ResponseBody
    @RequestMapping(value = "/student/note/{id}", method = RequestMethod.PUT)
    public HashMap<String, Object> loadSubmitedNotes(@PathVariable Integer id) {

//        正在审核
        List<Note> notesUnderReview = noteService.getSubmitNotes(id, 2);
//        审核通过
        List<Note> notesWithPassed = noteService.getSubmitNotes(id, 1);
//        审核拒绝
        List<Note> notesWithRejected = noteService.getSubmitNotes(id, 0);

        HashMap<String, Object> map = new HashMap<>();
        map.put("notesUnderReview", notesUnderReview);
        map.put("notesWithPassed", notesWithPassed);
        map.put("notesWithRejected", notesWithRejected);

        return map;
    }

    //    获取需要审核的请假单
//    还有问题，不能多位老师审核确认
    @ResponseBody
    @RequestMapping(value = "/teacher/note", method = RequestMethod.GET)
    public HashMap<String, List<NoteWithStuName>> loadRequestListForTeacher(@RequestParam("teacherId") Integer teacherId) {

        HashMap<String, List<NoteWithStuName>> map = new HashMap<>();

        List<NoteWithStuName> notesNeedReview = noteService.getNotesNeedReview(teacherId);

        for (NoteWithStuName noteWithStuName : notesNeedReview) {
            if (map.get(noteWithStuName.getCourseName()) == null) {
                ArrayList<NoteWithStuName> list = new ArrayList<>();
                map.put(noteWithStuName.getCourseName(), list);
                list.add(noteWithStuName);
            } else {
                map.get(noteWithStuName.getCourseName()).add(noteWithStuName);
            }
        }


        return map;
    }

    //    审核
    @ResponseBody
    @RequestMapping(value = "/teacher/note/{noteId}", method = RequestMethod.GET)
    public HashMap<String, Object> verifNote(@PathVariable String noteId,
                                             @RequestParam("opinion") String opinion,
                                             @RequestParam("id") Integer id) {

        int i = noteService.verifyNote(noteId, opinion, id);

        HashMap<String, Object> map = new HashMap<>();

        if (i != 0) {
            map.put("isReviewSuccess", Boolean.TRUE);
        } else {
            map.put("isReviewSuccess", Boolean.FALSE);
        }
        return map;
    }


}
