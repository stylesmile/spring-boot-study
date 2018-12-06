package com.example.controller;

import com.example.service.ModelService;
import com.example.util.DataTable;
import com.example.util.ModelForm;
import com.example.util.ReturnDTO;
import com.example.util.ReturnDTOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author: chenye.
 * @createTime: 2018/11/1
 */

@Controller
@RequestMapping("/model")
@Api(description = "流程模型前端控制器")
@Slf4j
public class ModelController {

    @Autowired
    ModelService modelService;

    @ApiOperation(value = "进入模型管理页面", notes = "进入模型管理页面")
    @RequestMapping(value = "" , method = RequestMethod.GET)
    public String list(org.springframework.ui.Model model, HttpServletRequest request) {
        log.debug(request.getContextPath()+"/model/");
        System.out.println(request.getContextPath()+"/model/");
        //model.addAttribute("url", request.getContextPath()+"/model/");
        model.addAttribute("url", "/model/");
        return "model/list";
    }
    @ApiOperation(value = "进入模型管理页面2", notes = "进入模型管理页面2")
    @GetMapping(value = "/list2")
    public String list2(org.springframework.ui.Model model, HttpServletRequest request) {
        log.debug(request.getContextPath()+"/model/");
        System.out.println(request.getContextPath()+"/model/");
        model.addAttribute("url", request.getContextPath()+"/model/");
        return "model-list";
    }

    @ApiOperation(value = "进入模型管理页面", notes = "进入模型管理页面")
    @GetMapping(value = "/insert")
    public String insert(org.springframework.ui.Model model, HttpServletRequest request) {
        model.addAttribute("action", "insert");
        model.addAttribute("url", request.getContextPath() + "/model/");
        model.addAttribute("categories", "");
        return "model/add";
    }

    @ApiOperation(value = "添加流程模型", notes = "添加流程模型")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnDTO insertForm(@Valid ModelForm form) {
        modelService.create(form.getName(), form.getKey(), form.getDesc(), form.getCategory());
        return ReturnDTOUtil.success();
    }

    @ApiOperation(value = "添加流程模型", notes = "添加流程模型")
    @PostMapping("")
    @ResponseBody
    public String createModel(@RequestParam String name, @RequestParam String key,
                              @RequestParam String desc, @RequestParam String category) {
        if (null == name || null == key || null == category) {
            //throw new SlifeException(HttpCodeEnum.INVALID_REQUEST);
        }
        Model model = modelService.create(name, key, desc, category);
        return model.getId();
    }

    @ApiOperation(value = "获取模型列表数据", notes = "获取模型列表数据:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<Model> list(@RequestBody DataTable dt) {
        if (null == dt) {
            return null;
        }
        return modelService.getMadelByPage(dt);
    }

    @ApiOperation(value = "批量删除日志记录", notes = "批量删除日志记录传入日志ids")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<String> ids) {
        if (null == ids) {
            return ReturnDTOUtil.fail();
        }
        modelService.delete(ids);
        return ReturnDTOUtil.success();

    }

    @ApiOperation(value = "部署流程", notes = "部署流程")
    @PostMapping("/deploy")
    @ResponseBody
    public ReturnDTO deploy(@RequestParam("id") String id) {
        modelService.deploy(id);
        return ReturnDTOUtil.success();
    }
}