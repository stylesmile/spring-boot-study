package com.lht.demoSrping.service.impl;

import com.lht.demoSrping.MyAutowired;
import com.lht.demoSrping.MyComponent;
import com.lht.demoSrping.service.AService;
import com.lht.demoSrping.service.BService;

@MyComponent
public class AServiceImpl implements AService {

    @MyAutowired
    private BService bService;

    @Override
    public String a() {
        return bService.b()+"aaaaaaaaa";
    }
}
