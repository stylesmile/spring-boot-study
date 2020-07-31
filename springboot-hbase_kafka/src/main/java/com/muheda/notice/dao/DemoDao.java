package com.muheda.notice.dao;

import com.muheda.notice.entity.Demo;
import com.muheda.notice.hbase.HBaseDaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Sorin
 * @Descriptions:
 * @Date: Created in 2018/3/21
 */
@Component("demoDao")
public class DemoDao {

    @Autowired
    private HBaseDaoUtil hBaseDaoUtil;

    /**
     * @Descripton:
     * @Author: Sorin
     * @param demo
     * @Date: 2018/3/22
     */
    public void save(Demo demo) {
        hBaseDaoUtil.save(demo);
    }

    /**
     * @Descripton:
     * @Author: Sorin
     * @param demo
     * @param id
     * @Date: 2018/3/22
     */
    public List<Demo> getById(Demo demo, String id) {
        return hBaseDaoUtil.get(demo, id);
    }
}
