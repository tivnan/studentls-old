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
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/login")
    public Map<String, Object> login(@RequestParam("code") String code) throws IOException {
        String openID = getOpenID(code).getOpenid();

        Student student = studentService.login(openID);
        Teacher teacher = teacherService.login(openID);

        HashMap<String, Object> map1 = new HashMap<>();

        if (student != null) {
            map1.put("isAuthenticated", Boolean.TRUE);
            map1.put("user", student);
        } else if (teacher != null) {
            map1.put("isAuthenticated", Boolean.TRUE);
            map1.put("user", teacher);
        } else {
            map1.put("isAuthenticated", Boolean.FALSE);
            Student student1 = new Student();
            student1.setOpenId(openID);
            map1.put("user", student1);
        }

        return map1;

    }


    @ResponseBody
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public Map<String, Object> authentication(@RequestBody Map<String, Object> map) throws IOException {

//        , @RequestParam("code") String code,
//        @RequestParam("identity") String identity,
//        @RequestParam("id") Integer id

//        String code = (String) map.get("code");
        String identity = (String) map.get("identify");
        Integer id = (Integer) map.get("id");


//        String openID = getOpenID(code).getOpenid();
        String openID = (String) map.get("openId");
//        String openID = code;

//        System.out.println("openID = " + openID);
//        System.out.println("id = " + id);
//        System.out.println("identity = " + identity);

//        System.out.println("code = " + code);

        Map<String, Object> loginData = new HashMap<>();

        if ("student".equals(identity)) {
            Student student = studentService.login(openID, id);
            loginData.put("user", student);
            loginData.put("type", "student");
        } else if ("teacher".equals(identity)) {
            Teacher teacher = teacherService.login(openID, id);
            loginData.put("user", teacher);
            loginData.put("type", "teacher");
        } else {
            loginData.put("user", null);

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
