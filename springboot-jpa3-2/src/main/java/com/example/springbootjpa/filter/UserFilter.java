package com.example.springbootjpa.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenye
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFilter {

    private String id;
    private String name;
}
