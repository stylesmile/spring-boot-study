package com.example.controller;

import com.example.entity.Email;
import com.example.service.EmailService;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenye
 * @date 2018/11/05
 */

@Controller
@RequestMapping("/email")
@Api(description = "邮件")
@Slf4j
public class EmailController {

    @Autowired
    private EmailService emailService;
    //@Autowired
    //private ActTaskService actTaskService;


    @ApiOperation(value = "进入邮件页面", notes = "进入邮件页面")
    @GetMapping(value = "/insert")
    public String insert(Model model, HttpServletRequest request) {
        model.addAttribute("action", "insert");
        model.addAttribute("url", request.getContextPath() + "/email/");
        model.addAttribute("categories", "");
        return "email/add";
    }
    /**
     * 启动请假流程
     * @param email
     */
    @ApiOperation(value = "启动请假流程", notes = "启动请假流程")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String save(Email email) {
        try {
            Map<String, Object> variables = new HashMap();
            emailService.save(email, variables);
        } catch (Exception e) {
            log.error("启动请假流程失败：", e);
        }
        return "email/list";
    }


    /**
     * 任务列表
     * @param model
     */
//    @ApiOperation(value = "添加流程模型", notes = "添加流程模型")
//    @GetMapping(value = {"/tasklist",""})
//    public String taskList(HttpSession session, Model model) {
//        String userId = "2";
//        List<Email> results = emailService.findTodoTasks(userId);
//
//        model.addAttribute("emails", results);
//        return "email/list";
//    }
    /**
     * 任务列表
     * @param model
     */
//    @GetMapping(value = {"/tasklist2",""})
//    public List<Email> taskList2(String  userId, Model model) {
//        if(StringUtils.isEmpty(userId)){
//            userId="2";
//        }
//        List<Email> results = emailService.findTodoTasks(userId);
//        return results;
//    }

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
