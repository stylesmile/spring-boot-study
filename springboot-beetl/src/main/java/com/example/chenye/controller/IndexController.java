package com.example.chenye.controller;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index(Model model){
		Map map = new HashMap();
		map.put("name", "李四操");
		model.addAttribute("data", map);
		return "index";
	}
	@RequestMapping("/index")
	public ModelAndView test(Model model){
		ModelAndView view = new ModelAndView("/index");
		Map map = new HashMap();
		map.put("name", "张三");
		view.addObject("data",map);
		return view;
	}
	/**
	 * 测试beetl模板
	 *
	 * @return
	 */
	@RequestMapping("/test")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		log.info("add request");
		modelAndView.addObject("test", "test@111.com");
		modelAndView.setViewName("test");

		return modelAndView;
	}
	
}
