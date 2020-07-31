package com.example.demo;

import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 */
@SpringBootTest
public class HbaseTests {
    @Resource
    HBaseService hBaseService;

    @Autowired
    private HbaseTemplate hbaseTemplate;

    @Test
    public void save() {
        List<Mutation> saveOrUpdates = new ArrayList<Mutation>();
        Put put = new Put(Bytes.toBytes("13500001111"));
        put.addColumn(Bytes.toBytes("people"), Bytes.toBytes("name"), Bytes.toBytes("test"));
        saveOrUpdates.add(put);
        //hbaseTemplate.put("people_table", "test");
    }

    @Test
    public void get() {
        String startRow = "";
        String stopRow = "";
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(stopRow));
        scan.setCaching(5000);
        List<City> dtos = this.hbaseTemplate.find("people_table", scan, new CityRowMapper());
        System.out.println(dtos.toString());
    }
}
