package cn.lx;



import cn.lx.application.Application;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;

/**
 * Created by lxliuxuan on 2016/11/11.
 */
public class Main {
    //本地启动服务
    public static final String BASE_URI = "http://localhost:8080/";
    public static void main(String[] args) throws IOException {
        //启动服务
        HttpServer httpServer = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                        + "%sapplication.wadl\nHit enter to stop it...",
                BASE_URI, BASE_URI));
        System.in.read();
        httpServer.shutdown();
    }
    public static HttpServer startServer()
    {
        System.out.println("start server...");
        Application config = new Application();
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
    }
}
