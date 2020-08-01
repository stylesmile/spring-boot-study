package com.futve.common.exception;

import com.futve.common.base.GlobalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 全局异常处理
 *
 * @author chenye
 * @date 2020-0312
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 在controller里面内容执行之前，校验一些参数不匹配啊，Get post方法不对啊之类的
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {
        System.out.println("错误");
        return new ResponseEntity<Object>("出错了", HttpStatus.NOT_EXTENDED);
    }


    @ExceptionHandler(value = FutveException.class)
    @ResponseBody
    public GlobalResponse<String> futveExceptionHandler(HttpServletRequest request, FutveException futveException) throws Exception {
        return GlobalResponse.fail(futveException.getStatusCode(), futveException.getAlertMsg());
    }

//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public GlobalResponse<String> jsonHandler(HttpServletRequest request, Exception e) throws Exception {
//        return GlobalResponse.fail(ArtCommonConstant.ExceptionReturnCode.ERROR_DEAL_FAIL, "发生异常");
//    }


    private void log(Exception ex, HttpServletRequest request) {
        logger.error("************************异常开始*******************************");
        logger.error(ex);
        logger.error("请求地址：" + request.getRequestURL());
        Enumeration enumeration = request.getParameterNames();
        logger.error("请求参数");
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement().toString();
            logger.error(name + "---" + request.getParameter(name));
        }

        StackTraceElement[] error = ex.getStackTrace();
        for (StackTraceElement stackTraceElement : error) {
            logger.error(stackTraceElement.toString());
        }
        logger.error("************************异常结束*******************************");
    }

//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultHandler(HttpServletRequest request, Exception e) throws Exception {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", e);
//        modelAndView.addObject("url", request.getRequestURL());
//        modelAndView.setViewName("error");
//        return modelAndView;
//    }
}