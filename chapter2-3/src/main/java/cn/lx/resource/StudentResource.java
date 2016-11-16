package cn.lx.resource;

import cn.lx.entity.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.*;

/**提供学生增删改查的接口服务
 * Created by lxliuxuan on 2016/11/14.
 */
@Path("/student")
@Produces
public class StudentResource {
    private static Map<String,Student> map = Collections.synchronizedMap(new HashMap<String, Student>());

    /**
     *
     * 获取所有学生信息的方法
     * @return
     */
    @GET
    @Path("/getAllByJson")
    public Response getAllJson(){
        List<Student> lists = new ArrayList<Student>();
        lists.add(new Student("1","mayun",23));
        lists.add(new Student("2","mahuateng",24));
        lists.add(new Student("3","zhouhongyi",25));
        JSONObject json = new JSONObject();
        return Response.status(Response.Status.OK).entity( json.toJSONString(lists)).build();
    }
    @GET
    @Path("/getAllBad")
    public Response getAllBad(String userId){

        try {
            if(userId == null){
                //请求参数有误，响应400 错误请求
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            List<Student> lists = new ArrayList<Student>(map.values());
        }catch (Exception e){
            //当服务器抛出异常时会响应500
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //正常响应200
        return Response.status(Response.Status.OK).build();
    }
    @GET
    @Path("/getAll1")
    public Response getAll(){
        List<Student> lists = new ArrayList<Student>(map.values());

        return Response.status(Response.Status.OK).build();
    }

    /**
     * 跳转请求方式变为GET
     * @return
     */
    @GET
    @Path("/jump")
    public Response redict(){
        String url = "http://www.baidu.com";
        return   Response.seeOther(URI.create(url)).build();
    }
    @POST
    @Path("/jump2")
    public Response jump(){
        String url = "http://www.baidu.com";
        return Response.temporaryRedirect(URI.create(url)).build();
    }
}
