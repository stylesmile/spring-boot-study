package com.futve.common.exception;

import com.futve.common.base.GlobalResponse;
import com.futve.common.constant.ArtCommonConstant;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在进入Controller之前，譬如请求一个不存在的地址，404错误
 *
 * @author by chenye on 2020-0312.
 */
@RestController
public class FinalExceptionHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public Object error(HttpServletResponse resp, HttpServletRequest req) {
        // 错误处理逻辑
        //return "url错误";
        return GlobalResponse.fail(ArtCommonConstant.ExceptionReturnCode.ERROR_DEAL_FAIL, "业务处理失败");
    }
}
