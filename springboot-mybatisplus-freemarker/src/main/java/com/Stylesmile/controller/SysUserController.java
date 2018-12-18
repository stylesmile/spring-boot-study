package com.Stylesmile.controller;

import com.Stylesmile.entity.SysUser;
import com.Stylesmile.service.SysUserService;
import com.Stylesmile.util.Result;
import com.Stylesmile.util.UUIDUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author chenye
 * @date 2018/12/08
 */
@RestController
public class SysUserController {

    final String model = "/user";
    @Autowired
    private SysUserService sysUserService;

    @GetMapping(model + "/index.html")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/system/sysUser/index");
        return view;
    }

    @RequestMapping(model + "/list.json")
    @ResponseBody
    public Result<List<SysUser>> list() {
        List<SysUser> list = sysUserService.geList();
        return Result.success(list);
    }

    @RequestMapping(model + "/add.html")
    @ResponseBody
    public ModelAndView add() {
        ModelAndView view = new ModelAndView("/system/sysUser/add");
        return view;
    }

    @RequestMapping(model + "/add.json")
    @ResponseBody
    public Result add(SysUser user) {
        user.setId(UUIDUtil.getUUID());
        Boolean b = sysUserService.saveOrUpdate(user);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @RequestMapping(model + "/edit.html")
    public ModelAndView edit(String id) {
        ModelAndView view = new ModelAndView("/system/sysUser/add");
        SysUser user = sysUserService.getById(id);
        view.addObject("user", user);
        return view;
    }

    @RequestMapping(model + "/edit.json")
    @ResponseBody
    public Result edit(SysUser user) {
        Boolean b = sysUserService.saveOrUpdate(user);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    //http://localhost:8080/getUserList
    @GetMapping("getUserList")
    @ResponseBody
    public List<SysUser> getUserList() {
        return sysUserService.geList();
    }

    @GetMapping("selectUserPage")
    public IPage<SysUser> selectUserPage(Page<SysUser> page, Integer state) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return sysUserService.getUserList(page, state);
    }
//
//    //http://localhost:8080/getUserListByName?name=1
//    //条件查询
//    @GetMapping("getUserListByName")
//    @ResponseBody
//    public List<SysUser> getUserListByName(String name)
//    {
//        Map map = new HashMap();
//        map.put("name", name);
//        return userDao.selectByMap(map);
//    }
//
//    //http://localhost:8080/saveUser?name=chenye&password=111
//    //保存用户
//    @GetMapping("saveUser")
//    @ResponseBody
//    public String saveUser(String name,String password)
//    {
//        SysUser user = new SysUser(name,password);
//        Integer index = userDao.insert(user);
//        if(index>0){
//            return "新增用户成功。";
//        }else{
//            return "新增用户失败。";
//        }
//    }
//
//    //http://localhost:8080/updateUser?id=5&userName=xiaoli&userPassword=111
//    //修改用户
//    @GetMapping("updateUser")
//    @ResponseBody
//    public String updateUser(Integer id,String name,String password)
//    {
//        SysUser user = new SysUser(id,name,password);
//        Integer index = userDao.updateById(user);
//        if(index>0){
//            return "修改用户成功，影响行数"+index+"行。";
//        }else{
//            return "修改用户失败，影响行数"+index+"行。";
//        }
//    }
//    //http://localhost:8080/getUserById?userId=1
//    //根据Id查询User
//    @GetMapping("getUserById")
//    @ResponseBody
//    public SysUser getUserById(Integer userId)
//    {
//        return userDao.selectById(userId);
//    }
//
//    //http://localhost:8080/getUserListByPage?pageNumber=1&pageSize=2
//    //条件分页查询
////    @GetMapping("getUserListByPage")
////    public List<User> getUserListByPage(Integer pageNumber,Integer pageSize)
////    {
////        Page<User> page =new Page<>(pageNumber,pageSize);
////        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
////        entityWrapper.eq("user_name", "xiaoli");
////        return userDao.selectPage(page,entityWrapper);
////    }
//    @GetMapping("getUserListByPage")
//    @ResponseBody
//    public IPage<SysUser> selectUserPage(Page<SysUser> page, Integer state) {
//        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
//        // page.setOptimizeCountSql(false);
//        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
//        // 要点!! 分页返回的对象与传入的对象是同一个
//        return userDao.selectPageVo(page, state);
//    }

}
