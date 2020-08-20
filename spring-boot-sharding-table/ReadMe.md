一. 项目需求

在之前我做项目的时候，数据量比较大,单表千万级别的,需要分库分表，于是在网上搜索这方面的开源框架,最常见的就是mycat,sharding-sphere,最终我选择后者,用它来做分库分表比较容易上手。

二. 简介sharding-sphere

官网地址: https://shardingsphere.apache.org/
ShardingSphere是一套开源的分布式数据库中间件解决方案组成的生态圈，它由Sharding-JDBC、Sharding-Proxy和Sharding-Sidecar（计划中）这3款相互独立的产品组成。 他们均提供标准化的数据分片、分布式事务和数据库治理功能，可适用于如Java同构、异构语言、容器、云原生等各种多样化的应用场景。
ShardingSphere定位为关系型数据库中间件，旨在充分合理地在分布式的场景下利用关系型数据库的计算和存储能力，而并非实现一个全新的关系型数据库。 它与NoSQL和NewSQL是并存而非互斥的关系。NoSQL和NewSQL作为新技术探索的前沿，放眼未来，拥抱变化，是非常值得推荐的。反之，也可以用另一种思路看待问题，放眼未来，关注不变的东西，进而抓住事物本质。 关系型数据库当今依然占有巨大市场，是各个公司核心业务的基石，未来也难于撼动，我们目前阶段更加关注在原有基础上的增量，而非颠覆。

sharding-jdbc 定位为轻量级Java框架，在Java的JDBC层提供的额外服务。 它使用客户端直连数据库，以jar包形式提供服务，无需额外部署和依赖，可理解为增强版的JDBC驱动，完全兼容JDBC和各种ORM框架。
适用于任何基于Java的ORM框架，如：JPA, Hibernate, Mybatis, Spring JDBC Template或直接使用JDBC。 基于任何第三方的数据库连接池，如：DBCP, C3P0, BoneCP, Druid, HikariCP等。 支持任意实现JDBC规范的数据库。目前支持MySQL，Oracle，SQLServer和PostgreSQL。

我这次使用配置文件方式实现分库以及分表
以上配置说明:

逻辑表 user

水平拆分的数据库（表）的相同逻辑和数据结构表的总称。例：用户数据根据主键尾数拆分为2张表，分别是user0到user1，他们的逻辑表名为user。
真实表

在分片的数据库中真实存在的物理表。即上个示例中的user0到user1
分片算法:

Hint分片算法
对应HintShardingAlgorithm，用于处理使用Hint行分片的场景。需要配合HintShardingStrategy使用。
分片策略:

行表达式分片策略 对应InlineShardingStrategy。使用Groovy的表达式，提供对SQL语句中的=和IN的分片操作支持，只支持单分片键。对于简单的分片算法，可以通过简单的配置使用，从而避免繁琐的Java代码开发，如: user$->{id % 2} 表示user表根据id模2，而分成2张表，表名称为user0到user_1。
自增主键生成策略

通过在客户端生成自增主键替换以数据库原生自增主键的方式，做到分布式主键无重复。 采用UUID.randomUUID()的方式产生分布式主键。或者 SNOWFLAKE
4. 实体类

package
 com.xd.springbootshardingtable.entity;

import
 com.baomidou.mybatisplus.annotation.
TableName
;
import
 com.baomidou.mybatisplus.extension.activerecord.
Model
;
import
 groovy.transform.
EqualsAndHashCode
;
import
 lombok.
Data
;
import
 lombok.experimental.
Accessors
;

/**
 * @Classname User
 * @Description 用户实体类
 * @Author 李号东 lihaodongmail@163.com
 * @Date 2019-05-26 17:24
 * @Version 1.0
 */
@Data
@EqualsAndHashCode
(callSuper = 
true
)
@Accessors
(chain = 
true
)
@TableName
(
"user"
)
public
 
class
 
User
 
extends
 
Model
<
User
> {

    
/**
     * 主键Id
     */
    
private
 
int
 id;

    
/**
     * 名称
     */
    
private
 
String
 name;

    
/**
     * 年龄
     */
    
private
 
int
 age;
}
5. dao层

package
 com.xd.springbootshardingtable.mapper;

import
 com.baomidou.mybatisplus.core.mapper.
BaseMapper
;
import
 com.xd.springbootshardingtable.entity.
User
;

/**
 * user dao层
 * @author lihaodong
 */
public
 
interface
 
UserMapper
 
extends
 
BaseMapper
<
User
> {

}
6. service层以及实现类

UserService

package
 com.xd.springbootshardingtable.service;

import
 com.baomidou.mybatisplus.extension.service.
IService
;
import
 com.xd.springbootshardingtable.entity.
User
;

import
 java.util.
List
;

/**
 * @Classname UserService
 * @Description 用户服务类
 * @Author 李号东 lihaodongmail@163.com
 * @Date 2019-05-26 17:31
 * @Version 1.0
 */
public
 
interface
 
UserService
 
extends
 
IService
<
User
> {

    
/**
     * 保存用户信息
     * @param entity
     * @return
     */
    
@Override
    
boolean
 save(
User
 entity);

    
/**
     * 查询全部用户信息
     * @return
     */
    
List
<
User
> getUserList();
}
UserServiceImpl

package
 com.xd.springbootshardingtable.service.
Impl
;

import
 com.baomidou.mybatisplus.core.toolkit.
Wrappers
;
import
 com.baomidou.mybatisplus.extension.service.impl.
ServiceImpl
;
import
 com.xd.springbootshardingtable.entity.
User
;
import
 com.xd.springbootshardingtable.mapper.
UserMapper
;
import
 com.xd.springbootshardingtable.service.
UserService
;
import
 org.springframework.stereotype.
Service
;

import
 java.util.
List
;

/**
 * @Classname UserServiceImpl
 * @Description 用户服务实现类
 * @Author 李号东 lihaodongmail@163.com
 * @Date 2019-05-26 17:32
 * @Version 1.0
 */
@Service
public
 
class
 
UserServiceImpl
 
extends
 
ServiceImpl
<
UserMapper
, 
User
> 
implements
 
UserService
 {
    
@Override
    
public
 
boolean
 save(
User
 entity) {
        
return
 
super
.save(entity);
    }

    
@Override
    
public
 
List
<
User
> getUserList() {
        
return
 baseMapper.selectList(
Wrappers
.<
User
>lambdaQuery());
    }

}
7. 测试控制类

package
 com.xd.springbootshardingtable.controller;

import
 com.xd.springbootshardingtable.entity.
User
;
import
 com.xd.springbootshardingtable.service.
UserService
;
import
 org.springframework.beans.factory.annotation.
Autowired
;
import
 org.springframework.web.bind.annotation.
GetMapping
;
import
 org.springframework.web.bind.annotation.
RestController
;

import
 java.util.
List
;

/**
 * @Classname UserController
 * @Description 用户测试控制类
 * @Author 李号东 lihaodongmail@163.com
 * @Date 2019-05-26 17:36
 * @Version 1.0
 */
@RestController
public
 
class
 
UserController
 {

    
@Autowired
    
private
 
UserService
 userService;

    
@GetMapping
(
"/select"
)
    
public
 
List
<
User
> 
select
() {
        
return
 userService.getUserList();
    }

    
@GetMapping
(
"/insert"
)
    
public
 
Boolean
 insert(
User
 user) {
        
return
 userService.save(user);
    }

}
四. 测试

启动项目
打开浏览器 分别访问:

http://localhost:8080/insert?id=1&name=lhd&age=12
http://localhost:8080/insert?id=2&name=lhd&age=13
http://localhost:8080/insert?id=3&name=lhd&age=14
http://localhost:8080/insert?id=4&name=lhd&age=15
则执行插数据 然后查看控制台日志:



根据分片算法和分片策略 不同的id以及age取模落入不同的库表 达到了分库分表的结果

有的人说 查询的话 该怎么做呢 其实也帮我们做好了 打开浏览器 访问:
http://localhost:8080/select


控制台打印:


分别从ds0数据库两张表和ds1两张表查询结果 然后汇总结果返回

之前有朋友问我单表数据量达千万,想做水平分割,不分库,也可以的吧?
是完全可以的 只要修改配置文件的配置即可 非常灵活

通过代码大家也可以看到,我的业务层代码和平时单表操作是一样的,只需要引入sh配置和逻辑表保持现有的不便即可,使用无侵入我们的代码 可以在原有的基础上改动即可 可以说是非常方便

    后面更新如何读写分离以及分库分表结合使用
    项目地址: https://github.com/LiHaodong888/SpringBootLearn
    
    
    
    
    