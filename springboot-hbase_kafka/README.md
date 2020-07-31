# 系统说明


1、配置文件说明:

    0)、application.yml:系统默认读取配置文件入口
    1)、application-dev.yml:开发环境配置文件
    2)、application-test.yml:测试环境配置文件
    3)、application-pro.yml:生成环境配置文件


2、本地启动:

    0)、修改application-dev.yml中的配置项
    1)、运行NoticeStartApp.java


3、部署与发布:

    0)、部署: cd 项目根目录（和pom.xml同级）
         mvn clean package  -Dmaven.test.skip=true
    1)、启动: java -jar muheda-notice-1.0-SNAPSHOT.jar --spring.profiles.active=test
         *: --spring.profiles.active=test为指定加载配置文件、
         后台启动运行:nohup java -jar muheda-notice-1.0-SNAPSHOT.jar --spring.profiles.active=test &
   
         
4、Hbase地址配置需先设置hosts映射:

    hbase:
      master: hadoop-11:60000
      zookeeper:
        quorum: hadoop-11,hadoop-12,hadoop-13,hadoop-14
   
        
5、HBaseDaoUtil中封装了Hbase基础操作，在dao中注入使用即可


6、通过实体Bean关联Hbase操作，需要在实体Bean类上加@HbaseTable(tableName="")注解，字段名上加@HbaseColumn(family="sorin2", qualifier="conn")注解   


7、Listener中@KafkaListener(topics = {"notice"})注解的方法为一个接口数据来源    


8、

    GitHub地址：https://github.com/susonglin/springboot_hbase_kafka
    码云地址：https://gitee.com/susonglin/springboot_hbase_kafka
    