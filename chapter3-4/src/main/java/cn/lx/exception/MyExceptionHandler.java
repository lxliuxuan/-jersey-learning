package cn.lx.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by lxliuxuan on 2016/11/16.
 */
@Provider
public class MyExceptionHandler  implements ExceptionMapper<MyException>{

    public Response toResponse(MyException e) {
        System.out.println(24);
        return Response.status(Response.Status.BAD_REQUEST).entity(e.toString()).build();
    }
}
