//package com.futve.common.interceptor;
//
//import com.alibaba.fastjson.JSONObject;
//import com.futve.common.constant.ArtCommonConstant;
//import com.futve.common.constant.RedisPrefixConstant;
//import com.futve.common.redis.RedisUtil;
//import com.futve.vo.loginuser.AccountTokenInfo;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.annotation.Resource;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.OutputStream;
//
///**
// * @author chenye
// */
//@Slf4j
//@Component
//public class AppInterceptor extends HandlerInterceptorAdapter {
//
//    @Resource
//    private RedisUtil redisUtil;
//
//    private static final String USER_LOGIN_TOKEN = RedisPrefixConstant.UserConstant.USER_LOGIN_TOKEN + RedisPrefixConstant.KEY_SPLIT + "%s" + RedisPrefixConstant.KEY_SPLIT + "%s";
//
//    public AppInterceptor() {
//        System.out.println("切面初始化，RedisHelper is " + redisUtil);
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        log.debug(request.getContextPath());
//        Cookie[] cookies = request.getCookies();
//        String appType = request.getParameter("appType");
//        String p = request.getParameter("p");
//        String accessToken = "";
//        boolean tokenCheck = false;
//        AccountTokenInfo userToken = new AccountTokenInfo();
//        if (null == cookies) {
//            return super.preHandle(request, response, handler);
//        }
//        for (Cookie cookie : cookies) {
//            switch (cookie.getName()) {
//                case "accessToken":
//                    accessToken = cookie.getValue();
//                    break;
//                default:
//                    break;
//            }
//        }
//        String method = request.getParameter("method");
//        String modular = request.getParameter("modular");
//        if (modular.equals("user") && (method.equals("login") || method.equals("logout"))) {
//            return true;
//        }
//        if (modular.equals("textTasks") && (method.equals("updateTextTaskCount"))) {
//            return true;
//        }
//        if (StringUtils.isNotEmpty(accessToken)) {
//            userToken = (AccountTokenInfo) redisUtil.get(
//                    String.format(USER_LOGIN_TOKEN, appType, accessToken)
//            );
//
//            if (null != userToken) {
//                redisUtil.set(String.format(USER_LOGIN_TOKEN, appType, userToken.getAccountToken()), userToken, RedisPrefixConstant.USER_TOKEN_EXPIRE_SECONDS);
////                redisHelper.setSerializeDataEx();
//                request.setAttribute("userInfo", userToken);
//                tokenCheck = true;
//                log.debug("method:" + method +
//                        ",modular:" + modular +
//                        ",appType:" + appType +
//                        ",p:" + p
//                );
//            }
//        }
//
//        if (!tokenCheck) {
//            log.debug("method:" + method + ",modular:" + method + ",username2:");
//            JSONObject jsonObj = new JSONObject();
//            jsonObj.put("code", ArtCommonConstant.ExceptionReturnCode.ERROR_TOKEN_TIMEOUT);
//            jsonObj.put("msg", "长时间未操作，自动退出");
//            OutputStream outputStream = response.getOutputStream();
//            log.debug("tokenCheck:" + tokenCheck);
//            log.debug("tokenCheck:" + tokenCheck);
//            outputStream.write(jsonObj.toJSONString().getBytes("UTF-8"));
//            return false;
//        }
//
////        if (!interfacesService.checkInfIsLimit(modular, method, userToken.getLoginUser().getRoles())) {
////            JSONObject jsonObj = new JSONObject();
////            jsonObj.put("code", ArtCommonConstant.ExceptionReturnCode.ERROR_NOT_LIMIT);
////            jsonObj.put("msg", "无接口访问权限");
////            OutputStream outputStream = response.getOutputStream();
////            outputStream.write(jsonObj.toJSONString().getBytes("UTF-8"));
////            return false;
////        }
//
//        // 更新token 超时时间
//        //userService.updateTokenTime(appType, userToken);
//        return super.preHandle(request, response, handler);
//    }
//}
