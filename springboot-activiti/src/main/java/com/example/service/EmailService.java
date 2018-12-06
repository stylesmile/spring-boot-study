package com.example.service;

import com.example.dao.EmailMapper;
import com.example.entity.Email;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
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
public class EmailService  {

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
    /**
     * 启动流程
     * @param email
     */
    @Transactional(readOnly = false)
    public void save(Email email, Map<String, Object> variables) {

        // 保存业务数据
        if (StringUtils.isBlank(email.getId())){
            email.preInsert();
            emailMapper.insert(email);
        }else{
            //emailMapper.update(emailMapper);
        }
        log.debug("save entity: {}", email);

        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        //identityService.setAuthenticatedUserId(email.getUserId());
        identityService.setAuthenticatedUserId(email.getName());

        // 启动流程
        String businessKey = email.getId();
        variables.put("type", "email");
        variables.put("busId", businessKey);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PD_EMAIL[0], businessKey, variables);
        //email.setProcessInstance(processInstance);

        // 更新流程实例ID
        email.setProcessInstanceId(processInstance.getId());
        emailMapper.updateProcessInstanceId(email);

        log.debug("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[] {
                PD_EMAIL[0], businessKey, processInstance.getId(), variables });

    }
    /**
     * 查询待办任务
     * @param userId 用户ID
     * @return
     */
    public List<Email> findTodoTasks(String userId) {

        List<Email> results = new ArrayList<Email>();
        List<Task> tasks = new ArrayList<Task>();
        // 根据当前人的ID查询
        List<Task> todoList = taskService.createTaskQuery().processDefinitionKey(PD_EMAIL[0]).taskAssignee(userId).active().orderByTaskPriority().desc().orderByTaskCreateTime().desc().list();
        // 根据当前人未签收的任务
        List<Task> unsignedTasks = taskService.createTaskQuery().processDefinitionKey(PD_EMAIL[0]).taskCandidateUser(userId).active().orderByTaskPriority().desc().orderByTaskCreateTime().desc().list();
        // 合并
        tasks.addAll(todoList);
        tasks.addAll(unsignedTasks);
        // 根据流程的业务ID查询实体并关联
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
            String businessKey = processInstance.getBusinessKey();
            Email email = emailMapper.getByProcessInstanceId(businessKey);
            email.setTask(task);
            email.setProcessInstance(processInstance);
            email.setProcessDefinition(repositoryService.createProcessDefinitionQuery().processDefinitionId((processInstance.getProcessDefinitionId())).singleResult());
            results.add(email);
        }
        return results;
    }

//    public Page<Email> find(Page<Email> page, Email email) {
//
//        email.getSqlMap().put("dsf", dataScopeFilter(email.getCurrentUser(), "o", "u"));
//
//        email.setPage(page);
//        page.setList(emailDao.findList(email));
//
//        for(Email item : page.getList()) {
//            String processInstanceId = item.getProcessInstanceId();
//            Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).active().singleResult();
//            item.setTask(task);
//            HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
//            if(historicProcessInstance!=null) {
//                item.setHistoricProcessInstance(historicProcessInstance);
//                item.setProcessDefinition(repositoryService.createProcessDefinitionQuery().processDefinitionId(historicProcessInstance.getProcessDefinitionId()).singleResult());
//            } else {
//                ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
//                if (processInstance != null){
//                    item.setProcessInstance(processInstance);
//                    item.setProcessDefinition(repositoryService.createProcessDefinitionQuery().processDefinitionId(processInstance.getProcessDefinitionId()).singleResult());
//                }
//            }
//        }
//        return page;
//    }
}
