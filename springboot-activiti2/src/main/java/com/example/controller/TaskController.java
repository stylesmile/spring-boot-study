package com.example.controller;

import com.example.entity.Email;
import com.example.service.ActTaskService;
import com.example.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenye
 * @date 2018/11/05
 */

@Controller
@RequestMapping("/task")
@Api(description = "任务")
@Slf4j
public class TaskController {

    @Autowired
    private ActTaskService actTaskService;


    /**
     * 任务列表
     * @param model
     */
//    @ApiOperation(value = "添加流程模型", notes = "添加流程模型")
//    @GetMapping(value = {"/taskPage"})
//    public String taskList(HttpSession session, Model model) {
//        String userId = "2";
//        List<Email> results = emailService.findTodoTasks(userId);
//
//        model.addAttribute("emails", results);
//        return "email/list";
//    }
    /**
     * 待办任务列表
     * @param userId 用户id
     */
    @ApiOperation(value = "待办任务列表", notes = "待办任务列表")
    @GetMapping(value = {"/tasklist",""})
    @ResponseBody
    public List<Email> taskList(String  userId) {
        if(StringUtils.isEmpty(userId)){
            userId="1";
        }
        List<Email> results = actTaskService.findTodoTasks(userId);
        return results;
    }
    /**
     * 完成任务
     //     * @param taskId 任务ID
     //     * @param processInstanceId 流程实例ID，如果为空，则不保存任务提交意见
     //     * @param content 任务提交意见的内容
     //     * @param map 任务流程变量，如下
     * 		vars.keys=flag,pass
     * 		vars.values=1,true
     * 		vars.types=S,B  @see com.thinkgem.jeesite.modules.act.utils.PropertyType
     */
    @RequestMapping(value = "complete")
    @ResponseBody
    public String complete(Email email) {
        Map map = new HashMap();
        try{
            actTaskService.complete(email.getTaskId(), email.getProcessInstanceId(), email.getContent(), map);
        }catch (Exception e){
            return "0";
        }
        return "1";
    }

    /**
     * 读取所有流程
     * @return
     */
//    @RequestMapping(value = {"list"})
//    public String list(Email email, HttpServletRequest request, HttpServletResponse response, Model model) {
//        Page<Email> page = emailService.find(new Page<Email>(request, response), email);
//        model.addAttribute("page", page);
//        return "modules/oa/emailList";
//    }
    /**
     * 获取待办列表
     */
//    @ApiOperation(value = "代办任务", notes = "代办任务")
//    @RequestMapping(value = {"todo", ""})
//    public String todoList(Act act, HttpServletResponse response, Model model) throws Exception {
//        List<Act> list = actTaskService.todoList(act);
//        model.addAttribute("list", list);
////        if (UserUtils.getPrincipal().isMobileLogin()){
////            return renderString(response, list);
////        }
//        return "modules/act/actTaskTodoList";
//    }
//    @ApiOperation(value = "代办任务list", notes = "代办任务")
//    @RequestMapping(value = {"todo1", ""})
//    public List<Act> todoList2(Act act) {
//        List<Act> list = actTaskService.todoList(act);
//        return list;
//    }

}
