package com.example.controller;

import com.example.service.SysUserService;
import com.example.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
/**
 * @author chenye
 * @date 2018/11/18
 */
@Slf4j
@Controller
public class IndexController {
	@Autowired
	SysUserService sysUserService;

	//*首页
	@RequestMapping("/")
	public String login(){
		return "login.html";
	}

	/**
	 * 后台首页
	 * @param loginName
	 * @param password
	 * @return
	 */
	@PostMapping("/login.json")
	@ResponseBody
	public Result<String> login(String loginName,String password){
		Result<String> result = sysUserService.getSysUserByNameAndPassword(loginName,password);
		return result;
	}
	//后台首页
	@RequestMapping("/index.html")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("/index.html");
		Map map = new HashMap();
		map.put("name", "张三");
		view.addObject("data",map);
		return view;
	}
}
