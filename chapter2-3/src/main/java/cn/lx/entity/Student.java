package cn.lx.entity;

import javax.ws.rs.FormParam;

/**
 * Created by lxliuxuan on 2016/11/14.
 */
public class Student {
    @FormParam("id")
    private  String id;
    @FormParam("name")
    private String name;
    @FormParam("age")
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
