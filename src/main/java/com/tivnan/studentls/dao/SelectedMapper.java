package com.tivnan.studentls.dao;

import com.tivnan.studentls.bean.HitsExample;
import com.tivnan.studentls.bean.HitsKey;
import com.tivnan.studentls.bean.Review;
import com.tivnan.studentls.bean.Selected;

import java.util.List;

/**
 * @project: studentls
 * @description:
 * @author: tivnan
 * @create: 2020-2020/11/25-下午4:08
 * @version:
 **/
public interface SelectedMapper {

    int insert(Selected record);

    List<String> selectByNoteId(String noteId);
}
