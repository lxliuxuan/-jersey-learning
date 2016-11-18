package cn.lx.application;


import cn.lx.filter.MyRequestFilter;
import cn.lx.filter.MyResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by lxliuxuan on 2016/11/11.
 */
@ApplicationPath("/")
public class Application extends ResourceConfig{
    public Application() {
        /*声明资源包所在位置
        * */
        packages("cn.lx.resource");

        /*注册过滤器
        * */
        register(MyRequestFilter.class);
        register(MyResponseFilter.class);

    }
}
