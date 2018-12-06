package com.example.entity;

import com.example.util.IdGen;
import lombok.Data;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author chenye
 * @date 2018/11/05
 */
@Data
public class Email implements Serializable {
    private String id;
    private String userId;
    private String name;
    private String content;
    private String processInstanceId;

    //-- 临时属性 --//
    // 流程任务
    private Task task;
    private Map<String, Object> variables;
    // 运行中的流程实例
    private ProcessInstance processInstance;
    // 历史的流程实例
    private HistoricProcessInstance historicProcessInstance;
    // 流程定义
    private ProcessDefinition processDefinition;
    public Email() {
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(){
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        setId(IdGen.uuid());
    }
}
