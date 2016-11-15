package cn.lx.resource;

import cn.lx.entity.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import java.util.*;

/**提供学生增删改查的接口服务
 * Created by lxliuxuan on 2016/11/14.
 */
@Path("/student")
public class StudentResource {
    private static Map<String,Student> map = Collections.synchronizedMap(new HashMap<String, Student>());

    /**
     *
     * 获取所有学生信息的方法
     * @return
     */
    @GET
    @Path("/getAll")
    public List<Student> getAll(){
        List<Student> lists = new ArrayList<Student>(map.values());
        return lists;
    }

    /**
     * 根据id获取学生信息
     * @param id
     * @return
     */
    @GET
    @Path("get/{id}")
    public Student getById(@PathParam("id") String id){
        Student student = map.get(id);
        return student;
    }

    /**
     * 添加学生信息 通过json
     * @return
     */
    @POST
    @Path("/addByJson")
    public String addByJson(Student student){
        map.put(student.getId(),student);
        return "success";
    }
    /**
     * 添加学生信息 通过javabean
     * @return
     */
    @POST
    @Path("/addByBean")
    public String addByBean(@BeanParam  Student student){
        map.put(student.getId(),student);
        return "success";
    }

    /**
     * 使用Context获取数据
     * @param ui
     * @return
     */
    @GET
    public String get(@Context UriInfo ui) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
        return "success";
    }
    /**
     * 通过form添加学生信息
     * @param id
     * @param name
     * @param age
     * @return
     */
    @POST
    @Path("/add")
    public String add(@FormParam("id") String id,
                      @FormParam("name") String name,
                      @FormParam("age") Integer age){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        map.put(id,student);
        return "success";
    }
    /**
     * 根据id删除学生信息
     * @param id
     * @return
     */
    @DELETE
    @Path("/delete/{id}")
    public String deleteById(@PathParam("id") String id){
        map.remove(id);
        return "success";
    }
}
