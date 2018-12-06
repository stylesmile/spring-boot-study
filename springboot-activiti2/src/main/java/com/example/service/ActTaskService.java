package com.example.service;

import com.example.dao.EmailMapper;
import com.example.entity.Email;
import com.example.util.StringUtils;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chenye
 * @date 2018/11/04
 */
@Slf4j
@Service
public class ActTaskService {

    /**
     * 定义流程定义KEY，必须以“PD_”开头
     * 组成结构：string[]{"流程标识","业务主表表名"}
     */
    public static final String[] PD_EMAIL = new String[]{"email", "oa_email"};

    @Autowired
    EmailMapper emailMapper;

    @Autowired
    IdentityService identityService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    ProcessService processService;
    /**
     * 查询待办任务
     * @param userId 用户ID
     * @return
     */
    public List<Email> findTodoTasks(String userId) {

        List<Email> results = new ArrayList<Email>();
        List<Task> tasks = new ArrayList<Task>();
        //根据角色去查看可领取的任务
        List<Task> list2 = taskService.createTaskQuery().taskCandidateUser(userId).list();
        List<Task> list11 = taskService.createTaskQuery().taskCandidateGroup("leader").list();//根据角色去查看可领取的任务
        for (Task task : list11) {
            taskService.claim(task.getId(), userId);//拾取任务
        }
        List<Task> toDoTasks = taskService.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().list();//拾取后才能查出该用户的代办流程
//        List<LeaveItem> leaveItems = new ArrayList<>();//待办流程显示的是业务的信息，而非真正的任务信息
//        for (Task task : toDoTasks) {
//            List leaveItem = processService.getLeaveItemByPiId(task.getProcessInstanceId());
//        }
        ////////////////
        // 根据当前人的ID查询
        //List<Task> todoList = taskService.createTaskQuery().processDefinitionKey(PD_EMAIL[0]).taskAssignee(userId).active().orderByTaskPriority().desc().orderByTaskCreateTime().desc().list();

        // 根据当前人未签收的任务
        //List<Task> unsignedTasks = taskService.createTaskQuery().processDefinitionKey(PD_EMAIL[0]).taskCandidateUser(userId).active().orderByTaskPriority().desc().orderByTaskCreateTime().desc().list();
        // 合并
        //tasks.addAll(todoList);
        //tasks.addAll(unsignedTasks);
        tasks.addAll(toDoTasks);
        // 根据流程的业务ID查询实体并关联
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
            //String businessKey = processInstance.getBusinessKey();
            Email email = emailMapper.getByProcessInstanceId(processInstanceId);
            email.setTaskId(task.getId());
            //email.setProcessInstance(processInstance);
            //email.setProcessDefinition(repositoryService.createProcessDefinitionQuery().processDefinitionId((processInstance.getProcessDefinitionId())).singleResult());
            results.add(email);
        }
        return results;
    }

    /**
     * 提交任务, 并保存意见
     * @param taskId 任务ID
     * @param procInsId 流程实例ID，如果为空，则不保存任务提交意见
     * @param comment 任务提交意见的内容
     * @param vars 任务变量
     */
    @Transactional(readOnly = false)
    public void complete(String taskId, String procInsId, String comment, Map<String, Object> vars){
        complete(taskId, procInsId, comment, "", vars);
    }

    /**
     * 提交任务, 并保存意见
     * @param taskId 任务ID
     * @param procInsId 流程实例ID，如果为空，则不保存任务提交意见
     * @param content 任务提交意见的内容
     * @param title			流程标题，显示在待办任务标题
     * @param vars 任务变量
     */
    @Transactional(readOnly = false)
    public void complete(String taskId, String procInsId, String content, String title, Map<String, Object> vars){
        // 添加意见
        if (StringUtils.isNotBlank(procInsId) && StringUtils.isNotBlank(content)){
            taskService.addComment(taskId, procInsId, content);
        }

        // 设置流程变量
        if (vars == null){
            vars = Maps.newHashMap();
        }

        // 设置流程标题
        if (StringUtils.isNotBlank(title)){
            vars.put("title", title);
        }

        // 提交任务
        taskService.complete(taskId, vars);
    }
}
