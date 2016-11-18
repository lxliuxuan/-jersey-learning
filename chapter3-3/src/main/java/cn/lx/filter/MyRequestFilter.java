package cn.lx.filter;

import cn.lx.entity.SpeedTime;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**请求过滤器
 * Created by lxliuxuan on 2016/11/16.
 */
@PreMatching
@Provider
public class MyRequestFilter implements ContainerRequestFilter{


    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        //请求开始，记录开始时间
        SpeedTime.time.set(System.currentTimeMillis());
        System.out.println("客户端请求"+containerRequestContext.getUriInfo().getPath());

    }
}
