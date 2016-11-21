package cn.lx.application;


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

    }
}
