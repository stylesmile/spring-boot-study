package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * common
 *
 * @Author StyleSmile
 */
public interface BaseService<T> extends IService<T> {

    /**
     * 获取 HttpRequest
     *
     * @return HttpRequest
     */
    HttpServletRequest getRequest();

    /**
     * 获取 HttpServletResponse
     *
     * @return HttpServletResponse
     */
    HttpServletResponse getResponse();
}
