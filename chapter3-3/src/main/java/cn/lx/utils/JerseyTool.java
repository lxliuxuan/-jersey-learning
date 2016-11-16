//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lx.utils;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


public class JerseyTool {


    public static Response returnUnauthorized() {
        return Response.status(Status.UNAUTHORIZED).build();
    }

    public static Response returnAbort(String errorJson) {
        return Response.status(Status.BAD_REQUEST).entity(errorJson).type("application/json").build();
    }

    public static Response returnServerError(String errorJson) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorJson).type("application/json").build();
    }

    public static Response returnSuccess(String json) {
        return json != null?Response.status(Status.OK).entity(json).type("application/json").build():Response.status(Status.OK).build();
    }

    public static Response returnSuccess() {
        return Response.status(Status.OK).build();
    }
}
