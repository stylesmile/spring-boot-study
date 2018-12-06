package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.UserMapper;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenye
 * @date 2018/11/06
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userDao;

    //http://localhost:8080/getUserList
    @GetMapping("getUserList")
    @ResponseBody
    public List<User> getUserList(){
        return userDao.getUserList();
    }

    //http://localhost:8080/getUserListByName?name=1
    //条件查询
    @GetMapping("getUserListByName")
    @ResponseBody
    public List<User> getUserListByName(String name)
    {
        Map map = new HashMap();
        map.put("name", name);
        return userDao.selectByMap(map);
    }

    //http://localhost:8080/saveUser?name=chenye&password=111
    //保存用户
    @GetMapping("saveUser")
    @ResponseBody
    public String saveUser(String name,String password)
    {
        User user = new User(name,password);
        Integer index = userDao.insert(user);
        if(index>0){
            return "新增用户成功。";
        }else{
            return "新增用户失败。";
        }
    }

    //http://localhost:8080/updateUser?id=5&userName=xiaoli&userPassword=111
    //修改用户
    @GetMapping("updateUser")
    @ResponseBody
    public String updateUser(String id,String name,String password)
    {
        User user = new User(id,name,password);
        Integer index = userDao.updateById(user);
        if(index>0){
            return "修改用户成功，影响行数"+index+"行。";
        }else{
            return "修改用户失败，影响行数"+index+"行。";
        }
    }
    //http://localhost:8080/getUserById?userId=1
    //根据Id查询User
    @GetMapping("getUserById")
    @ResponseBody
    public User getUserById(Integer userId)
    {
        return userDao.selectById(userId);
    }

    //http://localhost:8080/getUserListByPage?pageNumber=1&pageSize=2
    //条件分页查询
//    @GetMapping("getUserListByPage")
//    public List<User> getUserListByPage(Integer pageNumber,Integer pageSize)
//    {
//        Page<User> page =new Page<>(pageNumber,pageSize);
//        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
//        entityWrapper.eq("user_name", "xiaoli");
//        return userDao.selectPage(page,entityWrapper);
//    }
    @GetMapping("getUserListByPage")
    @ResponseBody
    public IPage<User> selectUserPage(Page<User> page, Integer state) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return userDao.selectPageVo(page, state);
    }

}
