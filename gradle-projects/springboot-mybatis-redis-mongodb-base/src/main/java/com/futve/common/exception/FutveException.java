package com.futve.common.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 业务异常
 * 异常信息可供前端弹窗提示给用户
 *
 * @author chenye
 */
@NoArgsConstructor
@AllArgsConstructor
public class FutveException extends RuntimeException {

    private static final long serialVersionUID = 6118874524492682160L;

    private String alertMsg;

    private Integer statusCode;

    public FutveException(String alertMsg) {
        super(alertMsg);
        this.alertMsg = alertMsg;
    }

    public FutveException(String alertMsg, String errMsg) {
        super(errMsg);
        this.alertMsg = alertMsg;
    }

    public FutveException(String alertMsg, String errMsg, Throwable e) {
        super(errMsg, e);
        this.alertMsg = alertMsg;
    }

    public FutveException(String alertMsg, Throwable e) {
        super(alertMsg, e);
        this.alertMsg = alertMsg;
    }

    public FutveException(Throwable e) {
        super(e);
    }

    public String getAlertMsg() {
        return alertMsg;
    }

    public Integer getStatusCode() {
        return statusCode;
    }


}
