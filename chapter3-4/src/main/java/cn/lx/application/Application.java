package cn.lx.application;

import cn.lx.exception.MyExceptionHandler;
import cn.lx.exception.MyExceptionMapper;
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
        /*注册异常处理类
        * */
        // 当一个异常有多种处理方式的时候，按照异常处理类的顺序，先注册的捕获处理该异常，
        register(MyExceptionHandler.class);
        register(MyExceptionMapper.class);
        /*声明异常包所在的位置
        * */
        packages("cn.lx.exception");
    }
}
