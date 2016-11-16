package cn.lx.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by lxliuxuan on 2016/11/16.
 */
public class MyException extends RuntimeException {
    private String code;
    private String description;
    private String message;

    public MyException(String code, String description, String message) {
        this.code = code;
        this.description = description;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 转换为json格式
     * @return
     */
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("description",description);
        json.put("message",message);
        return json.toString();
    }

}
