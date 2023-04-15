# SpringCloud第二季
1. 课程内容(springCloud+springCloud alibaba)
2. 技术要求
    java8 + maven + git / github + Nginx + RabbitMQ + SpringBoot2.0

### 分布式服务技术
- 服务注册与发现
- 服务调用
- 服务熔断
- 负载均衡
- 服务降级
- 服务消息队列
- 配置中心管理
- 服务网关
- 服务监控
- 全链路追踪
- 自动化构建部署
- 服务定时任务调度操作


### SpringCloud = 分布式微服务架构的一站式解决方案，是多种微服务架构落地技术的集合体。

### 关于Cloud各种组件的停更/升级/替换
- 停更不停用
    1. 被动修复bugs
    2. 不再接受合并请求
    3. 不再发布新版本
- Cloud升级 明细条目
    1. 服务注册中心：
        - Eureka (放弃)
        - Zookeeper (技术保守推荐)
        - Consul (不推荐)
        - Nacos (重要)
    2. 服务调用
        - Ribbon (轻度放弃)
        - LoadBalancer (Ribbon替换者，还不成熟)
    3. 服务调用2
        - Feign (放弃)
        - OpenFegin 
    4. 服务降级
        - Hystrix (放弃，但是还是用有很多公司使用)
        - resilience4j (官网推荐，国内很少使用)
        - sentinel (强烈推荐)
    5. 服务网关
        - Zuul (放弃)
        - Zuul2 (未出现)
        - gateway (主流)
    6. 服务配置
        - Config (放弃)
        - Nacos (推荐)
    7. 服务总线
        - Bus (放弃)
        - Nacos (推荐)
### 开始项目


### 微服务架构编码构建
#### 约定 > 配置 > 编码
#### idea新建project工作空间
##### 微服务cloud整体聚合父工程Project
###### 父工程步骤
1. New Project
    1. 选择工程 Maven -> site
2. 聚合总父工程名字
3. Maven选版本
    - 3.5以上
4. 工程名字
5. 字符编码
    - 设置 -> General -> File Encodings(此处可修改编码，一般全部都是utf-8)
    - ![Image text](images/image-1.png)
6. 注解生效激活
    - ![Image text](images/image-2.png)
7. java编译版本选8
8. File Type过滤
- Setting -> File Types下过滤不想看见的文件  
9. 父工程pom
```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cn.cyuxuan</groupId>
    <artifactId>learn-1</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>

    <modules>

    </modules>

    <!-- 统一管理jar包版本 -->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <junit.version>4.12</junit.version>
        <log4j.version>1.2.17</log4j.version>
        <lombok.version>1.16.18</lombok.version>
        <mysql.version>5.1.47</mysql.version>
        <druid.version>1.1.16</druid.version>
        <mybatis.spring.boot.version>1.3.0</mybatis.spring.boot.version>
    </properties>

    <!-- dependencyManagement 子模块继承之后，提供作用：锁定版本+子modlue不用写groupId和version  -->
    <dependencyManagement>
        <dependencies>
            <!--spring boot 2.2.2-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.2.2.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!--spring cloud Hoxton.SR1-->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Hoxton.SR1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!--spring cloud alibaba 2.1.0.RELEASE-->
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>2.1.0.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.version}</version>
            </dependency>
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>${druid.version}</version>
            </dependency>
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>${mybatis.spring.boot.version}</version>
            </dependency>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>${junit.version}</version>
            </dependency>
            <dependency>
                <groupId>log4j</groupId>
                <artifactId>log4j</artifactId>
                <version>${log4j.version}</version>
            </dependency>
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>${lombok.version}</version>
                <optional>true</optional>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <fork>true</fork>
                    <addResources>true</addResources>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```
10. Maven工程细节
- Maven中的dependencyManagement与dependency
    - 使用pom.xml中的dependencyManagement元素能让所有子项目中引用一个依赖而不用显示的列出版本号。Maven 会沿着父子层次向上走，直到找到一个拥有dependencyManagement元素的项目，然后它就会使用这个dependencyManagement元素中指定的版本号。
    - dependencyManagement中只是定义，真正的引入依赖还是在子工程中
- Maven中跳过单元测试
    - 取消Maven闪电标志
- 父工程创建完成执行 ``mvn:install`` 将父工程发布到仓库方便子工程继承
    - [Maven配置参考](https://blog.csdn.net/weixin_44005516/article/details/108293228)
#### Rest微服务工程构建
##### 构建步骤
###### cloud-provider-payment-8001
1. 建cloud-provider-payment-8001
2. 改POM
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>learn-1</artifactId>
        <groupId>cn.cyuxuan</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-provider-payment-8001</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <!--包含了sleuth+zipkin-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zipkin</artifactId>
        </dependency>
        <!--eureka-client-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
        <!--数据库连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.10</version>
        </dependency>
        <!--mysql-connector-java-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!--jdbc-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```
3. 写YML
```
server:
  port: 8001

spring:
  application:
    name: cloud-payment-service #微服务名称
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource  #当前数据源操作类型
    driver-class-name: org.gjt.mm.mysql.Driver #mysql驱动包
    url: jdbc:mysql://cyuxuan.cn:3306/springcloud-learn-1-db?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: root
    password: 123456

mybatis:
  mapper-locations: classpath:mapper/*.xml #mybatis mapper文件扫描位置
  type-aliases-package: cn.cyuxuan.entites #所有Entity别名类所在包
```
4. 主启动
5. 业务类
6. 测试
*** 
linux 安装mysql
- [linux安装Mysql参考](https://blog.csdn.net/qq_41510551/article/details/110731610)
- [ARM64架构下面安装mysql](https://blog.csdn.net/littleluoli/article/details/104796805/)
- [linux安装mysql参考](https://blog.csdn.net/sinat_15946141/article/details/105314944)->该博客在修改远程连接时要选择mysql数据库 use mysql
- 本机  root密码：2tj&Pax9XkQg(随机生成)

###### cloud-consumer-order-80
1. RestTemplate提供了多种便捷访问远程Http服务的方法。是一种简单便捷的restful服务模板类，是spring提供的用于访问Rest服务的客户端模板工具类。



### Eureka
#### Eureka基础知识
1. 什么是服务治理
    - Spring Cloud 封装了 Netflix 公司开发的 Eureka 模块来实现服务治理在传统的rpc远程调用框架中，管理每个服务与服务之间依赖关系比较复杂，管理比较复杂，所以需要使用服务治理，管理服务于服务之间依赖关系，可以实现服务调用、负载均衡、容错等，实现服务发现与注册。
2. 什么是服务注册
    - Eureka采用了CS的设计架构，Eureka Server 作为服务注册功能的服务器，它是服务注册中心。而系统中的其他微服务，使用 Eureka的客户端连接到Eureka Server并维持心跳连接。这样系统的维护人员就可以通过 Eureka Server 来监控系统中各个微服务是否正常运行。在服务注册与发现中，有一个注册中心。当服务器启动的时候，会把当前自己服务器的信息 比如 服务地址通讯地址等以别名方式注册到注册中心上。另一方（消费者|服务提供者），以该别名的方式去注册中心上获取到实际的服务通讯地址，然后再实现本地RPC调用RPC远程调用框架核心设计思想：在于注册中心，因为使用注册中心管理每个服务与服务之间的一个依赖关系(服务治理概念)。在任何rpc远程框架中，都会有一个注册中心(存放服务地址相关信息(接口地址))
    - 下左图是Eureka系统架构，右图是Dubbo的架构，请对比  
    - ![Image text](images/image-4.png)
3. Eureka两个组件
    - Eureka包含两个组件：Eureka Server和Eureka Client
    - Eureka Server提供服务注册服务
    - 各个微服务节点通过配置启动后，会在EurekaServer中进行注册，这样EurekaServer中的服务注册表中将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观看到。
    - EurekaClient通过注册中心进行访问
    - 是一个Java客户端，用于简化Eureka Server的交互，客户端同时也具备一个内置的、使用轮询(round-robin)负载算法的负载均衡器。在应用启动后，将会向Eureka Server发送心跳(默认周期为30秒)。如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，EurekaServer将会从服务注册表中把这个服务节点移除（默认90秒）
#### 单机
1. 说明
    ```
    <!-- 以前的老版本（当前使用2018） -->
    <dependency> 
        <groupId>
            org.springframework.cloud
        </groupId> 
        <artifactId>
            spring-cloud-starter-eureka
        </artifactId> 
    </dependency>

    <!-- 现在新版本（当前使用2020.2） -->
    <dependency> 
        <groupId>
            org.springframework.cloud
        </groupId> 
        <artifactId>
            spring-cloud-starter-netflix-eureka-server
        </artifactId> 
    </dependency>
    ```

2. 服务注册中心启动类中写 @EnableEurekaServer
    ```
    <!--eureka-server-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
    ```
    ```
    # yml文件中，注意缩进
    eureka:
        instance:
            hostname: eureka7001.com #eureka服务端的实例名称
        client:
            register-with-eureka: false     #false表示不向注册中心注册自己。
            fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
            service-url:
            #集群指向其它eureka
            #defaultZone: http://eureka7002.com:7002/eureka/
            #单机就是7001自己
            defaultZone: http://eureka7001.com:7001/eureka/
        #server:
            #关闭自我保护机制，保证不可用服务被及时踢除
            #enable-self-preservation: false
            #eviction-interval-timer-in-ms: 2000
    ```
3. 服务消费者/提供者启动类中写 @EnableEurekaClient
    ```
    <!-- pom文件引入 -->
    <dependency> 
        <groupId>
            org.springframework.cloud
        </groupId> 
        <artifactId>
            spring-cloud-starter-netflix-eureka-client
        </artifactId> 
    </dependency>
    ```
    ```
    # yml中配置，注意缩进
    eureka:
        client:
            #表示是否将自己注册进EurekaServer默认为true。
            register-with-eureka: true
            #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
            fetchRegistry: true
            service-url:
            #单机
            defaultZone: http://localhost:7001/eureka
            # 集群
            # defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka  # 集群版
    ```
#### 集群
1. ![Image text](images/image-5.png)
2. 问题：微服务RPC远程服务调用最核心的是什么
    - 高可用，试想你的注册中心只有一个only one， 它出故障了那就呵呵(￣▽￣)"了，会导致整个为服务环境不可用，所以
    - 解决办法：搭建Eureka注册中心集群 ，实现负载均衡+故障容错

### Zookeeper
#### Zookeeper安装
1. [参考](https://www.tpyyes.com/a/linux/886.html)
2. 配置文件中
```
spring:
  application:
    name: cloud-consumer-order
  cloud:
    #注册到zookeeper地址
    zookeeper:
      connect-string: server3.clocal.cn:2181
```
```
        <!-- SpringBoot整合zookeeper客户端 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
        </dependency>
        <!--添加zookeeper3.7.0版本-->
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.7.0</version>
        </dependency>
```


### Consul
#### 简介
1. [简介](https://www.consul.io/)
2. 能干什么
    - 服务发现 提供HTTP和DNS两种发现方式。
    - 健康监测 支持多种方式，HTTP、TCP、Docker、Shell脚本定制化监控
    - KV存储 Key、Value的存储方式
    - 多数据中心 Consul支持多数据中心
    - 可视化Web界面
#### 安装
1. [安装](https://www.cnblogs.com/fanshuyao/p/14486436.html)



### 三个注册中心的异同


### Ribbon
####  简介
- Spring Cloud Ribbon 是基于Netflix Ribbon实现的一套客户端 负载均衡工具
- 简单的说，Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法和服务调用。
- Ribbon客户端组件提供一系列完善的配置项，如 连接超时，重试等。就是在配置文件中列出Load Balancer(简称LB)后面所有的机器，Ribbon会自动的帮助你基于某种规则(如简单轮询，随机连接等)去连接这些机器。我们很容易使用Ribbon实现自定义的负载均衡算法。

### OpenFeign
#### 简介
- Feign是一个声明式WebService客户端。使用Feign能让编写Web Service客户端更加简单。
- 它的用法是定义一个服务接口然后在上面添加注解。Feign也支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMEssageConverters。Fegin可以与Eureka和Ribbon组合使用以支持负载均衡。

### Hystrix
#### 概述
1. 分布式面临的问题
2. Hystrix 是什么
3. Hystrix 能干什么
4. Hystrix 官网资料

#### Hystrix重要概念
1. 服务降级
    - 兜底的解决方案
2. 服务熔断
    - 达到最大访问量，直接调用服务降级
    - 服务的降级->进而熔断->恢复调用链路
3. 服务限流
    - 秒杀高并发等操作，严禁一窝蜂的过来拥挤，大家排队，一秒钟N个，有序进行
#### Hystrix案例

#### Hystrix工作流程

#### 服务监控hystrixDashboard

### Gateway网关
#### 概述简介

### Config分布式配置中心
#### 简介
#### 
1. 关于bootstrap.yml
    - Spring Cloud会创建一个"Bootstrap Context", 最为Spring应用的"Application Context"的父上下文。初始化的时候，'Bootstrap Context'负责从[外部源]加载配置属性并解析配置。这两个上下文共享一个外部获取的'Environment'。
    - ‘Bootstrap’属性有高优先级，默认情况下，它们不会被本地配置覆盖。‘Bootstrap Context’和‘Application Context’有着不同的约定，所以新增了一个‘bootstrap.yml’文件，保证‘Bootstrap Context’和‘Application Context’配置的分离。
    - 要将Client模块下的application.yml文件改为bootstrap.yml，这是很关键的。
    - 因为bootstrap.yml是比application.yml先加载的。bootstrap.yml优先级高于application.yml

### RabbitMQ
#### 概述
#### 安装
1. erlang安装参考（安装资源已上传百度云）
    - [erlang安装](https://blog.csdn.net/llwy1428/article/details/99430328)
2. RabbitMQ安装参考
    - [参考](https://www.pianshen.com/article/77811336070/)
3. 备注：此处依赖包未解决，外网速度太慢，暂时使用docker安装rabbitmq。
    - [安装参考](https://blog.csdn.net/qq_34775355/article/details/108305396)

### Docker
#### 概述
#### 安装
1. [参考](https://blog.csdn.net/qq_26400011/article/details/113856681)
    - 此处注意切换镜像，部分镜像可能不可用


### Nginx
#### 简介
1. [简介](https://blog.csdn.net/weixin_42167759/article/details/85049546)
2. [简介](https://www.cnblogs.com/knowledgesea/p/5175711.html)
#### 安装
#### 进阶

### Bus消息总线
#### 概述
1. 是什么
    - 在微服务架构的系统中，通常会使用轻量级的消息代理来构建一个共用的消息主题，并让系统中所有微服务实例都连接上来。由于该主题中产生的消息被所有实例监听和消费，所以称它为消息总线。在实例上的各个实例，都可以方便地广播一些需要让其他连接在该主题上的实例都知道的消息。
    - 基本原理：ConfigClient实例都监听MQ中同一个topic（默认是springCloudBus）。当一个服务刷新数据时，它会把这个信息放入到Topic中，这样其他监听同一个Topic的服务就能得到通知，然后去更新自身的配置。
2. 能干什么
3. 为何被称为总线

### 消息驱动
#### 简介
####

### Sleuth
#### 简介
1. 在微服务框架中，一个客户端发起的请求在后端系统中会经过多个不同的服务节点调用来协同产生最后的请求结果，每一个前段请求都会形成一段复杂的分布式服务调用链路链路中任何一环出现高延时或错误都会引起整个请求最后的失败。

## SpringCloud Aibaba（简介可以去官网看，中文的）
### Nacos
#### 简介



