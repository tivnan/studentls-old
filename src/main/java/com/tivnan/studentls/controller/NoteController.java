package com.tivnan.studentls.controller;

import com.tivnan.studentls.bean.Note;
import com.tivnan.studentls.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

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
//    0: 未完成的请假单
//    1： 提交，正在审核
//    >2: 审核通过
//    -1：审核拒绝


    @ResponseBody
    @RequestMapping(value = "/note/{noteId}", method = RequestMethod.POST)
    public HashMap<String, Object> saveNote(@RequestBody Note note) {
//    public HashMap<String, Object> saveNote(@RequestParam("studentId") Integer studentId,
//                                            @RequestParam("startTime") String startTime,
//                                            @RequestParam("endTime") String endTime,
//                                            @RequestParam("content") String content,
//                                            @RequestParam("type") Integer type,
//                                            @RequestParam("noteId") String noteId) {
//
//        Note note = new Note(noteId, startTime, endTime, content, 0, type, studentId);

        System.out.println(note);

        //传过来学生studetId，开始时间startTime,结束时间endTime,请假内容content，请假类型type
        //note_id,start_time,end_time,content,state,type,student_id

        note.setState(0);

        HashMap<String, Object> map = new HashMap<>();

        noteService.saveNote(note);
        map.put("noteId", note);
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

}
