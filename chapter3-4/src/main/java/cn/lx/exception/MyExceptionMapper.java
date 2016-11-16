package cn.lx.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by lxliuxuan on 2016/11/16.
 */
@Provider//该注解的作用是用于表明该类是javax.ws.rs的一种组件
public class MyExceptionMapper implements ExceptionMapper<Exception>{
    public Response toResponse(Exception e) {
        System.out.println(21);
        if(e instanceof MyException){
            e.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(e.toString()).build();
    }
}
