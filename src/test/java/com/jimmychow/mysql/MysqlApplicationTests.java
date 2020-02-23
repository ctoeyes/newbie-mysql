package com.jimmychow.mysql;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class MysqlApplicationTests {

    @Autowired
    private InnoDB InnoDB;

    @Autowired
    private MyISAM MyISAM;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS");
    private String time;

    @Test
    public void create() throws Exception {

        Integer tableRecordNum = 50000;

        System.out.println("清空表");
        InnoDB.deleteAll();
        MyISAM.deleteAll();

        //InnoDB
        System.out.println("InnoDB 开始插入");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("开始时间："+time);

        for(int i=0;i<tableRecordNum;i++) {
            InnoDB.create("a", i, "b", i);
        }

        System.out.println("InnoDB 插入结束");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("结束时间："+time);

        Assert.assertEquals(tableRecordNum.intValue(), InnoDB.getAll().intValue());

        //MyISAM
        System.out.println("MyISAM 开始插入");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("开始时间："+time);

        for(int i=0;i<tableRecordNum;i++) {
            MyISAM.create("a", i, "b", i);
        }

        System.out.println("MyISAM 插入结束");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("结束时间："+time);

        Assert.assertEquals(tableRecordNum.intValue(), MyISAM.getAll().intValue());
    }

    @Test
    public void retrieve() throws Exception {

        Integer retrieveNum = 10000;

        //InnoDB
        System.out.println("InnoDB 开始查询");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("开始时间："+time);

        for(int i=0;i<retrieveNum;i++) {
            InnoDB.retrieve(i);
        }

        System.out.println("InnoDB 查询结束");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("结束时间："+time);

        //MyISAM
        System.out.println("MyISAM 开始查询");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("开始时间："+time);

        for(int i=0;i<retrieveNum;i++) {
            MyISAM.retrieve(i);
        }

        System.out.println("MyISAM 查询结束");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("结束时间："+time);
    }

    @Test
    public void retrieveByIndex() throws Exception {

        Integer retrieveNum = 10000;

        //InnoDB
        System.out.println("InnoDB 开始查询 by Index");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("开始时间："+time);

        for(int i=0;i<retrieveNum;i++) {
            InnoDB.retrieveByIndex(i);
        }

        System.out.println("InnoDB 查询结束 by Index");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("结束时间："+time);

        //MyISAM
        System.out.println("MyISAM 开始查询 by Index");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("开始时间："+time);

        for(int i=0;i<retrieveNum;i++) {
            MyISAM.retrieveByIndex(i);
        }

        System.out.println("MyISAM 查询结束 by Index");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("结束时间："+time);
    }

}
