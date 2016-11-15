package cn.lx.resource;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Map;

/**
 * Created by lxliuxuan on 2016/11/15.
 */
@Path("/")
public class Resource {

    @Context
    HttpServletRequest req;

    @Context
    ServletConfig servletConfig;

    @Context
    ServletContext servletContext;

    @GET
    public String get(@Context HttpHeaders hh) {
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        Map<String, Cookie> cookies = hh.getCookies();
        return "success";
    }
}