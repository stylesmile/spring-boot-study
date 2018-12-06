package com.example.editor.controller;

import com.example.editor.service.DiagramLayoutService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chenye.
 * @createTime: 2018/10/29
 */
@RestController
@Api(description = "设计器布局的前端控制器")
public class DiagramLayoutController extends DiagramLayoutBaseController {

    @Autowired
    DiagramLayoutService diagramLayoutService;

    @ApiOperation(value = "", notes = "")
    @GetMapping("/process-instance/{processInstanceId}/highlights")
    public ObjectNode getHighlighted(@PathVariable String processInstanceId) {
        //Optional.ofNullable(processInstanceId).orElseThrow(() -> new SlifeException(HttpCodeEnum.INVALID_REQUEST));
        return diagramLayoutService.getHighlighted(processInstanceId);
    }

    @ApiOperation(value = "", notes = "")
    @GetMapping("/process-instance/{processInstanceId}/diagram-layout")
    public ObjectNode getDiagramByPid(@PathVariable String processInstanceId) {
        //Optional.ofNullable(processInstanceId).orElseThrow(() -> new SlifeException(HttpCodeEnum.INVALID_REQUEST));
        return getDiagramNode(processInstanceId, null);
    }

    @ApiOperation(value = "", notes = "")
    @GetMapping("/process-definition/{processDefinitionId}/diagram-layout")
    public ObjectNode getDiagramByPdid(@PathVariable String processDefinitionId) {
        //Optional.ofNullable(processDefinitionId).orElseThrow(() -> new SlifeException(HttpCodeEnum.INVALID_REQUEST));
        return getDiagramNode(null, processDefinitionId);
    }
}
