package cn.lx.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by lxliuxuan on 2016/11/11.
 */
@Path("hello")
public class HelloResource {
    @Path("/hello")
    @GET
    public String hello(){
        return "Hello World";
    }
}
