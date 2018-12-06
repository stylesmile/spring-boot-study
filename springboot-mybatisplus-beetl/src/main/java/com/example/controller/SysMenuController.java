package com.example.controller;

import com.example.entity.SysMenu;
import com.example.service.SysMenuService;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/24
 */
@RestController
public class SysMenuController {

    final String model = "/menu";
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping(model+"/index.html")
    @ResponseBody
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("/system/sysMenu/index.html");
        return view ;
    }    @GetMapping(model+"/index2.html")
    @ResponseBody
    public ModelAndView index2(){
        ModelAndView view = new ModelAndView("/system/sysMenu/index2.html");
        return view ;
    }
    @RequestMapping(model+"/list.json")
    @ResponseBody
    public Result<List<SysMenu>> list(){
        List<SysMenu> list = sysMenuService.geList();
        return Result.success(list);
    }
    @RequestMapping(model+"/add.html")
    @ResponseBody
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("/system/sysMenu/add.html");
        return view ;
    }
    @RequestMapping(model+"/add.json")
    @ResponseBody
    public Result add(SysMenu user){
        Boolean b = sysMenuService.saveOrUpdate(user);
        if(b){
            return Result.success();
        }else{
            return Result.fail();
        }
    }
    @RequestMapping(model+"/edit.html")
    @ResponseBody
    public ModelAndView edit(int id){
        ModelAndView view = new ModelAndView("/system/sysMenu/add.html");
        SysMenu user = sysMenuService.getById(id);
        view.addObject("user",user);
        return view ;
    }

//    //http://localhost:8080/getMenuList
    @GetMapping("getMenuList")
    @ResponseBody
    public List<SysMenu> getMenuList(){
        return sysMenuService.geList();
    }


}
