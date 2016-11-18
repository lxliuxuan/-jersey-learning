package cn.lx.resource;

import cn.lx.common.ResponseDto;
import cn.lx.entity.User;
import cn.lx.service.UserService;
import cn.lx.utils.JerseyTool;
import com.alibaba.fastjson.JSON;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by lxliuxuan on 2016/11/18.
 */
@Component//resource转换为spring组件
@Path("/user")
public class UserResource {
    @Resource
    private UserService userService;

    @Path("/add")
    @POST
    public Response add(@FormParam("id") String id,
                        @FormParam("name") String name,
                        @FormParam("age") int age){

        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setId(id);
        userService.insert(user);

        return  JerseyTool.returnSuccess(new ResponseDto("OK","添加用户成功").toString());
    }

    /**
     *
     * 查询所有用户信息
     * @return
     */
    @GET
    @Path("/getAll")
    public Response getAll(){
        List<User> users = userService.selectAll();
        return JerseyTool.returnSuccess(JSON.toJSONString(users));
    }

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    @GET
    @Path("/getById")
    public Response getById(@QueryParam("id") String id){
        User user = userService.selectById(id);
        return JerseyTool.returnSuccess(JSON.toJSONString(user));
    }

    /**
     * 更新用户信息
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PUT
    @Path("update")
    public Response update(@FormParam("id") String id,
                           @FormParam("name") String name,
                           @FormParam("age") int age){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setId(id);
        userService.update(user);

        return  JerseyTool.returnSuccess(new ResponseDto("OK","添加用户成功").toString());

    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @DELETE
    @Path("/delete")
    public Response deleteById(@QueryParam("id") String id){
        userService.delete(id);
        return  JerseyTool.returnSuccess(new ResponseDto("OK","删除用户成功").toString());
    }
}
