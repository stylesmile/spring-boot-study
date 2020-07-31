package com.muheda.notice.controller;

import com.google.common.collect.ImmutableMap;
import com.muheda.notice.entity.Demo;
import com.muheda.notice.service.DemoService;
import com.muheda.notice.utils.BaseController;
import com.muheda.notice.utils.ResultData;
import com.muheda.notice.utils.ResultType;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.IdentityMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Sorin
 * @Descriptions:
 * @Date: Created in 2018/3/21
 */
@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @Autowired
    private DemoService demoService;

    @ApiOperation(value="测试controller", notes="")
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    /**
     * @Descripton: 保存
     * @Author: Sorin
     * @param demo
     * @Date: 2018/3/22
     */
    @ApiOperation(value="保存数据接口", notes="保存数据接口")
    @PostMapping("/save")
    public ResultData save(Demo demo){
        try {
            demoService.save(demo);
            return setResponseEntity(ResultType.SUCCESS.getDescription(), ResultType.SUCCESS.getCode(),null,true);
        } catch (Exception e) {
            e.printStackTrace();
            return setResponseEntity(ResultType.SERVER_ERROR.getDescription(),ResultType.SERVER_ERROR.getCode(),null,false);
        }
    }

    /**
     * @Descripton: 根据id查询
     * @Author: Sorin
     * @param id
     * @Date: 2018/3/22
     */
    @ApiOperation(value="根据id查询数据接口", notes="根据id查询数据接口")
    @GetMapping("/get/{id}")
    public ResultData getBean(@PathVariable String id){
        try {
            List<Demo> apples = demoService.getById(new Demo(), id);
            return setResponseEntity(ResultType.SUCCESS.getDescription(), ResultType.SUCCESS.getCode(), ImmutableMap.of("date", apples),true);
        } catch (Exception e) {
            e.printStackTrace();
            return setResponseEntity(ResultType.SERVER_ERROR.getDescription(),ResultType.SERVER_ERROR.getCode(),null,false);
        }
    }
}
