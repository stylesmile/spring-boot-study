package com.futve.common.base;


import com.futve.common.constant.ArtCommonConstant;
import com.futve.common.tools.JsonUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@ToString
public class GlobalResponse<T> {

//    @ApiModelProperty(notes = "默认全部为true")
//    protected boolean success = true;

    @ApiModelProperty(notes = "数据")
    private T data;
    @ApiModelProperty(notes = "不为空。等于200时表示业务成功，其他表示业务失败")
    private int code = 200;
    @ApiModelProperty(notes = "错误信息，如果不为空，展示给用户")
    private String msg;

//    @ApiModelProperty(notes = "系统错误信息，供开发人员问题跟踪使用")
//    private String errorMsg;
//    @ApiModelProperty(notes = "日志跟踪号")
//    protected String traceLogId;

    public GlobalResponse() {

    }

    public GlobalResponse(T data) {
        this.data = data;
        this.msg = "操作成功";
    }

    //
//    public GlobalResponse(T data, String traceLogId,String alertMsg) {
//        this.traceLogId = traceLogId;
//        this.data = data;
//        this.msg=alertMsg;
//    }
//
//    public static <T> GlobalResponse<T> success(T data,String alertMsg) {
//        return new GlobalResponse<>(data, TraceLogIdUtils.getTraceLogId(),alertMsg);
//    }
//
    public static <T> GlobalResponse<T> success(T data) {
        log.debug(JsonUtil.toJson(data));
        return new GlobalResponse<T>(data);
    }

    public static <T> GlobalResponse<T> success(T data, String msg) {
        GlobalResponse<T> resp = new GlobalResponse<T>();
        resp.setData(data);
        resp.setMsg(msg);
        return resp;
    }

    public static <T> GlobalResponse<T> success() {
        GlobalResponse<T> resp = new GlobalResponse<T>();
        resp.setMsg("success");
        return resp;
    }

    public static <T> GlobalResponse<T> successMsg(String msg) {
        GlobalResponse<T> resp = new GlobalResponse<T>();
        resp.setMsg(msg);
        return resp;
    }

    public static <T> GlobalResponse<T> fail(int code, String msg, Object data) {
        log.debug(JsonUtil.toJson(data));
        return new GlobalResponse(data);
    }

    //    public static <T> GlobalResponse<T> fail(String alertMsg){
//        GlobalResponse<T> resp = new GlobalResponse<T>();
//        resp.setCode(GolbalResponseCodeEnum.FAIL.getCode());
//        resp.setTraceLogId(TraceLogIdUtils.getTraceLogId());
//        resp.setSuccess(false);
//        resp.setMsg(Strings.isNullOrEmpty(alertMsg)? GolbalResponseCodeEnum.FAIL.getDesc() :alertMsg);
//        resp.setErrorMsg(GolbalResponseCodeEnum.FAIL.getDesc());
//        return resp;
//    }
//
    public static <T> GlobalResponse<T> exception(Throwable e, String alertMsg) {
        GlobalResponse<T> resp = new GlobalResponse<T>();
//      resp.setCode(GolbalResponseCodeEnum.EXCEPTION.getCode());
//        resp.setMsg(Strings.isNullOrEmpty(alertMsg)? GolbalResponseCodeEnum.EXCEPTION.getDesc() :alertMsg);
//        resp.setTraceLogId(TraceLogIdUtils.getTraceLogId());
//        resp.setSuccess(false);
//      resp.setErrorMsg(Throwables.getStackTraceAsString(Throwables.getRootCause(e)));
        return resp;
    }

    public static <T> GlobalResponse<T> fail(int statusCode, String alertMsg) {
        GlobalResponse<T> resp = new GlobalResponse<T>();
        resp.setCode(statusCode);
        resp.setMsg(alertMsg);
        return resp;
    }

    public static <T> GlobalResponse<T> parameterErrorMessage(String alertMsg) {
        GlobalResponse<T> resp = new GlobalResponse<T>();
        resp.setCode(ArtCommonConstant.ReturnCode.ERROR_PARAMETER_FAIL);
        resp.setMsg(alertMsg);
        return resp;
    }

    public static <T> GlobalResponse<T> exception(Throwable e, String alertMsg, int statusCode) {
        GlobalResponse<T> resp = new GlobalResponse<T>();
        resp.setCode(statusCode);
        resp.setMsg(alertMsg);
//        resp.setTraceLogId(TraceLogIdUtils.getTraceLogId());
        //resp.setErrorMsg(Throwables.getStackTraceAsString(Throwables.getRootCause(e)));
        return resp;
    }
//
//    public static <T> GlobalResponse<T> httpError(Integer httpCode) {
//        Integer code = null == httpCode? GolbalResponseCodeEnum.EXCEPTION.getCode() : httpCode;
//        GlobalResponse<T> resp = new GlobalResponse<T>();
//        resp.setStatusCode(code);
//        resp.setTraceLogId(TraceLogIdUtils.getTraceLogId());
//        resp.setAlertMsg(GolbalResponseCodeEnum.EXCEPTION.getDesc());
//        resp.setErrorMsg("http请求异常，Http statusCode = "+httpCode);
//        return resp;
//    }
}
