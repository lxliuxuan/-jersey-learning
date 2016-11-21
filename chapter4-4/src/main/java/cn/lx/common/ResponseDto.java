package cn.lx.common;

import com.alibaba.fastjson.JSONObject;

/**用于响应返回结果的dto
 * Created by lxliuxuan on 2016/11/18.
 */
public class ResponseDto {
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResponseDto(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("code",getCode());
        json.put("msg",getMsg());
        return json.toString();
    }
}
