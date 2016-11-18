package cn.lx.resource;





import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**该类用于测试自定义异常处理类的使用
 * Created by lxliuxuan on 2016/11/16.
 */
@Path("/test")
public class TestResource {
    @GET
    @Path("/filter")
    public Response testFilter(@QueryParam("userId") String userId){
        return Response.ok().entity("success").build();
    }

}
