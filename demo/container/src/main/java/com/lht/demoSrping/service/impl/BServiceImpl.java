package com.lht.demoSrping.service.impl;

import com.lht.demoSrping.MyAutowired;
import com.lht.demoSrping.MyComponent;
import com.lht.demoSrping.service.AService;
import com.lht.demoSrping.service.BService;

@MyComponent
public class BServiceImpl implements BService {

//    @MyAutowired
//    private AService aService;

    public String b() {
        return "bbbbbbbbb";
    }
}
