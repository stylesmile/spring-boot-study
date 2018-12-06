package com.example.util;

import lombok.Data;

/**
 * @author: felix.
 * @createTime: 2017/12/11.
 */
@Data
public class ProcessDefDTO {

    public String category;
    public String processonDefinitionId;
    public String key;
    public String name;
    public Integer revision;
    public Long deploymentTime;
    public String xmlName;
    public String picName;
    public String deploymentId;
    public Boolean suspend;
    public String description;
}
