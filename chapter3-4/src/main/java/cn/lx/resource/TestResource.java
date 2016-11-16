package cn.lx.resource;



import cn.lx.exception.MyException;
import com.sun.deploy.util.StringUtils;

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
    @Path("/exce")
    public Response getExce(@QueryParam("userId") String userId){
        System.out.println(1);
        if(userId == null){
            throw new MyException("1001","访问参数不合法","错误请求");
        }
        return null;
       // return Response.ok().entity("success").build();
    }

}
