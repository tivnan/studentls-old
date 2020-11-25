package com.tivnan.studentls.controller;

import com.tivnan.studentls.bean.vo.Section;
import com.tivnan.studentls.bean.vo.SectionWithSlot;
import com.tivnan.studentls.service.SectionService;
import com.tivnan.studentls.utils.SEToDates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: studentls
 * @description: controller for section
 * @author: tivnan
 * @create: 2020-2020/11/22-下午4:04
 * @version: 1.0
 **/
@Controller
public class SectionController {

    @Autowired
    SectionService sectionService;

    //    提供日期和学生信息 拉取课程小节信息
    @ResponseBody
    @RequestMapping("/loadSection")
    public Map<String, Object> loadSection(@RequestParam String startTime,@RequestParam String endTime, @RequestParam("userId") Integer userId) {
//    public Map<String, Object> loadSection(@RequestParam List<String> dates, @RequestParam String id) {

//        System.out.println("studentID = " + studentID);
//        System.out.println("dates = " + dates);

//        yyyy-MM-dd

        String id = String.valueOf(userId);

        List<String> dates = SEToDates.SEToDates(startTime, endTime);


        HashMap<String, Object> map = new HashMap<>();

        List<Section> sections = sectionService.getSection(dates, id);

        ArrayList<SectionWithSlot> sectionWithSlots = new ArrayList<>();

        for (Section section : sections) {
            sectionWithSlots.add(new SectionWithSlot(section));
        }

        map.put("sections", sectionWithSlots);

        return map;
    }

}
