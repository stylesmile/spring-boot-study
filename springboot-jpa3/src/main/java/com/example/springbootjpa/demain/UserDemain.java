package com.example.springbootjpa.demain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDemain {

    private Integer id;
    private String name;
    private String email;

}
