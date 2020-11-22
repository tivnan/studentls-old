package com.tivnan.studentls.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tivnan.studentls.bean.vo.OpenIDBean;
import com.tivnan.studentls.bean.Student;
import com.tivnan.studentls.bean.Teacher;
import com.tivnan.studentls.service.StudentService;
import com.tivnan.studentls.service.TeacherService;
import com.tivnan.studentls.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @project: studentls
 * @description: in charge of login
 * @author: tivnan
 * @create: 2020-2020/11/20-下午2:21
 * @version: 1.0
 **/
@Controller
public class LoginController {

    private String appID = "";
    private String appSecret = "";

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    @RequestMapping("/login")
    public Map<String, Object> Login(@RequestParam("code") String code,
                                     @RequestParam("identity") String identity,
                                     @RequestParam("ID") Integer id) throws IOException {

        String openID = getOpenID(code).getOpenid();

        Map<String, Object> loginData = new HashMap<>();

        if ("student".equals(identity)) {
            Student student = studentService.login(openID, id);
            loginData.put("user", student);
        } else {
            Teacher teacher = teacherService.login(openID, id);
            loginData.put("user", teacher);
        }

        return loginData;

//
//        Student student = studentService.login(openID);
//        Teacher teacher = teacherService.login(openID);

        /*未完成，遇到了一点问题
        现在是，如果数据库有openid的话，就可以进行比对确认，
        但是如果没有的话，我还需要插入用户，但是按照叶某的接口，不能确认该插教师还是学生
        * */

        /*Student student = studentService.login(code);
        Teacher teacher = teacherService.login(code);

        Map<String, Object> loginData = new HashMap<>();
        Map<String, Object> userData = new HashMap<>();

        if (student != null) {

            loginData.put("isAuthenticated", Boolean.TRUE);

            userData.put("id", student.getStudentId());
            userData.put("name", student.getName());
            userData.put("type", "student");
            userData.put("openId", student.getOpenId());

        } else if (teacher != null) {
            loginData.put("isAuthenticated", Boolean.TRUE);

            userData.put("id", teacher.getTeacherId());
            userData.put("name", teacher.getName());
            userData.put("type", "teacher");
            userData.put("openId", teacher.getOpenId());

        } else {
            loginData.put("isAuthenticated", Boolean.FALSE);
        }

        loginData.put("user", userData);


        return loginData;*/
    }


    /**
     * 用于获取openid和seesionkey
     *
     * @param code
     * @return
     * @throws IOException
     */
    public OpenIDBean getOpenID(String code) throws IOException {
        String result = "";
        try {
            //请求微信服务器，用code换取openid。
            // HttpUtil是工具类，后面会给出实现，Configure类是小程序配置信息，后面会给出代码
            result = HttpUtil.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session"
                            + "?appid=" + this.appID
                            + "&secret=" + this.appSecret
                            + "&js_code=" + code
                            + "&grant_type=authorization_code", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        OpenIDBean openIDBean = mapper.readValue(result, OpenIDBean.class);
        return openIDBean;
    }


}
