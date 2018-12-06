package com.example.util;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author: felix.
 * @createTime: 2017/12/11.
 */
@Data
public class ModelForm {
    private String category;
    @NotBlank
    private String name;
    @NotBlank
    private String key;
    @NotBlank
    private String desc;
}
