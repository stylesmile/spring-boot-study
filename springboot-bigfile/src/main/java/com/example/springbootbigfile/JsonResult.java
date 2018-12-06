package com.example.springbootbigfile;

/**
 * 描述: json格式数据返回对象，使用CustomJsonResultSerializer 来序列化
 * @author : lijiazhi
 */
public class JsonResult<T> {
  
    private String code;
    private String msg;
    private T data;

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
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "code=" + code + " message=" + msg + " data=" + data;
    }

    public static <T> JsonResult<T> fail() {
    	JsonResult<T> ret = new JsonResult<T>();
    	ret.setCode("201");
    	ret.setMsg("失败");
        return ret;
    }
    
    public static <T> JsonResult<T> fail(T data) {
	    	JsonResult<T> ret = JsonResult.fail();
	    	ret.setData(data);
        return ret;
    }
    
    public static <T> JsonResult<T> failMessage(String msg) {
	    	JsonResult<T> ret = JsonResult.fail();
	    	ret.setMsg(msg);
        return ret;
    }
    public static <T> JsonResult<T> successMessage(String msg) {
	    	JsonResult<T> ret = JsonResult.success();
	    	ret.setMsg(msg);
	    return ret;
    }

    public static <T> JsonResult<T> success() {
    	JsonResult<T> ret = new JsonResult<T>();
    	ret.setCode("200");
    	ret.setMsg("");
        return ret;
    }

    public static <T> JsonResult<T> success(T data) {
	    	JsonResult<T> ret = JsonResult.success();
	    	ret.setData(data);
        return ret;
    }
    
    public static <T> JsonResult<T> http404(T data) {
	    	JsonResult<T> ret = new JsonResult<T>();
	    	ret.setCode("404");
	    	ret.setMsg("");
	    	ret.setData(data);
        return ret;
    }
    
    public static <T> JsonResult<T> http403(T data) {
	    	JsonResult<T> ret = new JsonResult<T>();
	    	ret.setCode("403");
	    	ret.setMsg("");
	    	ret.setData(data);
        return ret;
    }

}
