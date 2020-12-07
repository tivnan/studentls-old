package com.tivnan.studentls.service;

import com.tivnan.studentls.bean.vo.Section;
import com.tivnan.studentls.dao.StudentMapper;
import com.tivnan.studentls.utils.DataAndSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: studentls
 * @description: service for section
 * @author: tivnan
 * @create: 2020-2020/11/22-下午4:05
 * @version: 1.0
 **/
@Service
public class SectionService {

    @Autowired
    StudentMapper studentMapper;


    public List<Section> getSection(List<String> dates, String studentID) {

        Integer beginSlot;
        Integer endSlot;
        ArrayList<Section> sections = new ArrayList<>();

        for (String date : dates) {
            List<Integer> weekAndWeekDay = DataAndSlot.data2slot(date);
            beginSlot = weekAndWeekDay.get(1) * 4 - 3;
            endSlot = weekAndWeekDay.get(1) * 4;
            List<Section> sectionsSin = studentMapper.selectWithSection(Integer.valueOf(studentID), weekAndWeekDay.get(0), beginSlot, endSlot);
            if (sectionsSin != null) {
                sections.addAll(sectionsSin);
            }
        }

        return sections;
    }


}
