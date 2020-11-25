package com.tivnan.studentls.bean;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + id +
                ", name='" + name + '\'' +
                ", openId='" + openId + '\'' +
                '}';
    }

    private Integer id;

    private String name;

    private String openId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }
}