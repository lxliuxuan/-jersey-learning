package cn.lx.filter;

import cn.lx.entity.SpeedTime;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by lxliuxuan on 2016/11/16.
 */
@Provider
public class MyResponseFilter implements ContainerResponseFilter
{
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        System.out.println("服务器响应完成，花费时间"+(System.currentTimeMillis()- SpeedTime.time.get())+"ms");
    }
}
