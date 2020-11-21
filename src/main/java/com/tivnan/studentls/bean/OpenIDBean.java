package com.tivnan.studentls.bean;

/**
 * @project: studentls
 * @description: open id bean
 * @author: tivnan
 * @create: 2020-2020/11/20-下午3:50
 * @version: 1.0
 **/
public class OpenIDBean {
    private String openid;
    private String session_key;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
}
