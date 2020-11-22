package com.tivnan.studentls.controller;

import com.tivnan.studentls.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Map<String, Object> loadSection(String date, String studentID) {

        HashMap<String, Object> sections = new HashMap<>();

//        List<Map<String, Object>> section = sectionService.getSection(date, studentID);

        List<Map<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        sections.put("sections", list);


        return sections;
    }

}
