package com.tivnan.studentls.controller;

import com.tivnan.studentls.bean.Note;
import com.tivnan.studentls.bean.vo.FinishedNote;
import com.tivnan.studentls.bean.vo.NotesNeedReview;
import com.tivnan.studentls.bean.vo.UNFinishedNote;
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


/*    //    保存未完成的请假单
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

    }*/

/*    //    获取之前保存且未提交的请假单
    @ResponseBody
    @RequestMapping(value = "/student/note/{noteId}", method = RequestMethod.GET)
    public HashMap<String, Object> loadUnfinishedNote(@PathVariable String noteId) {

        Note note = noteService.queryNoteByNoteId(noteId);

        HashMap<String, Object> map = new HashMap<>();

//        System.out.println(note);


        map.put("unfinishedList", note);

        return map;


    }*/

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

//        System.out.println("selectedList = " + selectedList);

        Note note = new Note(startTime, endTime, content, type, studentId);

//        System.out.println("note = " + note);

//        System.out.println("note = " + note);

        Boolean aBoolean = noteService.submitNote(note, selectedList);


        HashMap<String, Object> map1 = new HashMap<>();
        //传过来学生studetId，开始时间startTime,结束时间endTime,请假内容content，请假类型type
        //note_id,start_time,end_time,content,state,type,student_id

//        note.setState(1);

//        System.out.println(note);


        map1.put("isSubmitSuccess", aBoolean);
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

    //    拉取已完成请假单
    @ResponseBody
    @RequestMapping(value = "/student/note/loadFinishedRequest", method = RequestMethod.GET)
    public HashMap<String, Object> loadFinishedRequest(@RequestParam Integer id) {

//        审核通过的或者拒绝的
        List<Note> notesWithPassed = noteService.getSubmitNotes(id, 1);

        ArrayList<FinishedNote> finishedList = new ArrayList<>();
        for (Note note : notesWithPassed) {
            finishedList.add(new FinishedNote(note));
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("finishedList", finishedList);

        return map;
    }

    //    拉取未完成请假单
    @ResponseBody
    @RequestMapping(value = "/student/note/loadUnfinishedRequest", method = RequestMethod.GET)
    public HashMap<String, Object> loadUnfinishedRequest(@RequestParam Integer id) {

//        正在审核的
        List<Note> notesUnderReview = noteService.getSubmitNotes(id, 2);

        ArrayList<UNFinishedNote> unfinishedList = new ArrayList<>();
        for (Note note : notesUnderReview) {
            unfinishedList.add(new UNFinishedNote(note));
        }


        HashMap<String, Object> map = new HashMap<>();
        map.put("unfinishedList", unfinishedList);

        return map;
    }


    //    教师获取需要审核的请假单
    @ResponseBody
    @RequestMapping(value = "/teacher/note/loadRequestListForTeacher", method = RequestMethod.GET)
    public HashMap<String, List<NotesNeedReview>> loadRequestListForTeacher(@RequestParam("id") Integer teacherId) {

        HashMap<String, List<NotesNeedReview>> map = new HashMap<>();

        List<NotesNeedReview> notesNeedReview = noteService.getNotesNeedReview(teacherId);

        for (NotesNeedReview needReview : notesNeedReview) {
            String weekXtime = needReview.getSectionTime();

        }

//        for (NotesNeedReview noteWithStuName : notesNeedReview) {
//            if (map.get(noteWithStuName.getCourseName()) == null) {
//                ArrayList<NotesNeedReview> list = new ArrayList<>();
//                map.put(noteWithStuName.getCourseName(), list);
//                list.add(noteWithStuName);
//            } else {
//                map.get(noteWithStuName.getCourseName()).add(noteWithStuName);
//            }
//        }

        map.put("list", notesNeedReview);

        return map;
    }

    //    审核
    @ResponseBody
    @RequestMapping(value = "/teacher/note/verifyRequest", method = RequestMethod.GET)
    public HashMap<String, Object> verifNote(@RequestParam("noteId") String noteId,
                                             @RequestParam("opinion") String opinion,
                                             @RequestParam("id") Integer id,
                                             @RequestParam("sectionId") Integer timesId) {

        int i = noteService.verifyNote(noteId, opinion, id, timesId);

        HashMap<String, Object> map = new HashMap<>();

        if (i != 0) {
            map.put("isReviewSuccess", Boolean.TRUE);
        } else {
            map.put("isReviewSuccess", Boolean.FALSE);
        }
        return map;
    }


}
