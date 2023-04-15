# 结合代码分支/learn-java-source/tree/master/c_code/code-1
# Spring基础
## Spring总览
- 特性总览
- 版本特性
- 技术整合
  - Java语言特性运用
  - JDK API实践
  - Java EE API整合
- 变成模型
  - 面向对象编程
    - 契约接口(接口)
      - 这里就是面向接口编程
  - 面向切面编程
    - 动态代理
      - 在Java中动态代理必须基于接口来进行编程，实际情况可能并不允许完全基于接口进行编程。因此Spring提升了一种方式。整合了第三方框架，例如ASM，CGLIB,AspectJ来帮助我们在类上做提升。帮助我们可以在某个类上面做一些AOP的拦截
    - 字节码提升
  - 面向元编程
    - 配置元信息
    - 注解
    - 属性配置
  - 面向模块编程
    - Maven Artifacts
    - Java9 Automatic Modules
    - Spring @Enable* 注解
  - 面向函数编程
    - Lambda
    - Reactive
      - 异步非阻塞

---
## 重新认识IOC
#### 1. 重新认识IOC 
#### 2. IoC 主要实现策略
#### 3. IoC 容器的职责
 - 通用职责
 - 依赖处理
   - 依赖查找
   - 依赖注入
 - 生命周期管理
   - 容器
   - 托管的资源（Java Beans 或其他资源）
 - 配置
   - 容器
   - 外部化配置
   - 托管的资源（Java Beans 或其他资源）
#### 4. IoC 容器的实现
  - 主要实现
  - Java SE
    - Java Beans
    - Java ServiceLoader SPI
    - JNDI(Java Naming and Directory Interface)
  - Java EE
    - EJB（Enterprise Java Beans）
    - Servlet
  - 开源
    - Apache Avalon（http://avalon.apache.org/closed.html）
    - PicoContainer（http://picocontainer.com/）
    - Google Guice（https://github.com/google/guice）
    - Spring Framework（https://spring.io/projects/spring-framework）
#### 5. 传统 IoC 容器实现
- Java Beans 作为 IoC 容器
- 特性
  - 依赖查找
  - 生命周期管理
  - 配置元信息
  - 事件
  - 自定义
  - 资源管理
  - 持久化
- 规范
  - JavaBeans：https://www.oracle.com/technetwork/java/javase/tech/index-jsp-138795.html
  - BeanContext：https://docs.oracle.com/javase/8/docs/technotes/guides/beans/spec/beancontext.htm

#### 6. 轻量级 IoC 容器
#### 7. 依赖查找 VS. 依赖注入
#### 8. 构造器注入 VS. Setter 注入

----
## Spring IOC 容器概述
#### 1. Spring IoC 依赖查找
- 根据 Bean 名称查找
  - 实时查找
  - 延迟查找
- 根据 Bean 类型查找
  - 单个 Bean 对象
  - 集合 Bean 对象
根据 Bean 名称 + 类型查找
根据 Java 注解查找
  - 单个 Bean 对象
  - 集合 Bean 对象

#### 2. Spring IoC 依赖注入
- 根据 Bean 名称注入
- 根据 Bean 类型注入
  - 单个 Bean 对象
  - 集合 Bean 对象
- 注入容器內建 Bean 对象
- 注入非 Bean 对象
- 注入类型
  - 实时注入
  - 延迟注入

#### 3. Spring IoC 依赖来源
- 自定义 Bean
- 容器內建 Bean 对象
- 容器內建依赖

#### 4. Spring IoC 配置元信息
- Bean 定义配置
  - 基于 XML 文件
  - 基于 Properties 文件
  - 基于 Java 注解
  - 基于 Java API（专题讨论）
- IoC 容器配置
  - 基于 XML 文件
  - 基于 Java 注解
  - 基于 Java API （专题讨论）
- 外部化属性配置
  - 基于 Java 注解

#### 5. Spring IoC 容器
- BeanFactory 和 ApplicationContext 谁才是 Spring IoC 容器

#### 6. Spring 应用上下文
- ApplicationContext 除了 IoC 容器角色，还有提供：
  - 面向切面（AOP）
  - 配置元信息（Configuration Metadata）
  - 资源管理（Resources）
  - 事件（Events）
  - 国际化（i18n）
  - 注解（Annotations）
  - Environment 抽象（Environment Abstraction）
  - https://docs.spring.io/spring/docs/5.2.2.RELEASE/spring-framework-reference/core.html#beans-introduction

#### 7. 使用 Spring IoC 容器
- BeanFactory 是 Spring 底层 IoC 容器
- ApplicationContext 是具备应用特性的 BeanFactory 超集
- 
#### 8. Spring IoC 容器生命周期
- 启动
- 运行
- 停止

----
## Spring Bean基础

#### 1. 定义 Spring Bean
#### 2. BeanDefinition 元信息
#### 3. 命名 Spring Bean
#### 4. Spring Bean 的别名
#### 5. 注册 Spring Bean
#### 6. 实例化 Spring Bean
#### 7. 初始化 Spring Bean
#### 8. 延迟初始化 Spring Bean
#### 9. 销毁 Spring Bean
#### 10. 垃圾回收 Spring Bean
























---
## Spring核心特性
####  1. IOC容器
####  2. Spring事件
####  3. 资源管理
####  4. 国际化
####  5. 校验
####  6. 数据绑定
####  7. 类型转换
####  8. Spring表达式
####  9. 面向切面编程(AOP)

---
## 数据存储
### JDBC
### 事务抽象
### DAO支持
### O/R映射
### XML编列

## Web技术
- SpringMVC与Spring WebFlux在注解上完全一样，但是底层实现发生了变化
- 传统的SpringMVC需要Servlet引擎支持，Reactive通常默认情况下是netty的web server
- Reactive也可以运用Spring MVC的引擎来进行实现
### Web Servlet 技术(Spring 1-4 唯一支持)
#### Spring MVC
#### WebSocket
- Servlet3.0以后会支持WebSocket
#### SockJS

### Web Reactive 技术(Spring5 以后引入)
#### Spring WebFlux
#### WebClient
- 将HttpClient和RestTemplate这两个同步的调用，变成异步回调
#### WebSocket


## 技术整合
### 远程调用(Remoting)
- RMI java标准的远程调用
- Dubbo 基于Hessian协议，Hessian是社区开源方案
- Spring Framework做了一层封装，无论是HTTP的调用还是Hessian的调用都可以通过这个统一的封装来执行调用得到结果
- 远程调用一般是同步模式
### Java消息服务(JMS)
- java异步的调用
- 使用传统的JMS规范来实现，不包括RabbitMQ，kafka,因为这些不是规范的JMS实现
### 连接框架(JCA)
- 主要是作用是统一一些资源连接
- 比如JDBC这样的连接
- 目前使用得很少了
### Java管理扩展(JMX)
- Java Management Extensions
- 用于Java的管理，比如CPU使用率查看等
- Spring1.2引入了一个注解 @ManagedResource
### 邮件客户端(Email)
### 本地任务(Tasks)
### 本地调度(Scheduling)
### 缓存抽象(Caching)
### Spring 测试(Testing)


## Spring 测试
### 模拟对象(Mock Objects)
### TestContext框架(TestContext Framework)
### Spring MVC测试(Spring MVC Test)
### Web 测试客户端(WebTestClient)


## Spring 各版本与Java的关系
![Spring各版本与Java对应](note-spring-基础-images/Spring各版本与Java对应关系.png)
- Java1.3版本对应Servlet2.3版本，该版本对应一个Servlet事件，可以和Spring时间进行一个呼应。
- Servlet事件和Spring事件都是Java标准事件的一个实现


## Spring模块化设计
- spring-aop
- spring-aspects
- spring-context-indexer
- spring-context-supports
- spring-context
- spring-core
- spring-expression
- spring-instrument
- spring-jcl
- spring-jdbc
- spring-jms
- spring-messaging
- spring-orm
- spring-oxm
- spring-test
- spring-tx
- spring-web
- spring-webflux
- spring-webmvc
- spring-websocket

## Spring 对java EE API整合
- 暂时省略

## Spring 编程模型
- ![Spring编程模型](note-spring-基础-images/Spring编程模型.png)
### 面向对象编程
- 契约接口
  - Awear
  - BeanPostProcessor
    - 关于Bean的生命周期的后置处理
- 设计模式
  - 举例
    - 观察者模式
      - ApplicationEvent(Spring事件)
      - Spring事件是基于Java的标准事件，EventObjec对象java.uti包下
      - 有一个简单实现，SimpleApplicationEventMulticaster，简单应用事件的广播器，这里就使用了观察者模式
    - 组合模式
      - CompositeCacheManager，使用的组合模式
    - 模板模式
      - 例如jdbcTemplate
  - 对象继承
    - Abstract*类
      - 举例
      - AbstractBeanFactory
### 面向切面编程
- 动态代理
- 字节码提升
### 面向元编程
- 注解
- 配置
- 泛型
### 函数驱动

### 模块驱动

## 重新认识IOC
### IOC的职责
- 实现与执行直接要产生解耦
- 要关注设计的目标而不是具体的实现
- 释放模块，不依赖于某个契约
- 当模块取消的时候，应对边缘效应或者副作用

### 一些问题
- Spring作为IOC容器有什么优势
  - 典型的IoC管理，依赖查找和依赖注入
  - AOP抽象
  - 事务抽象
  - 事件机制
  - SPI扩展
  - 强大的第三方整合
  - 易测试性
  - 更好的面向对象

### 依赖来源


### 配置元信息


### IOC
spring-context 类间关系[参考](https://blog.csdn.net/yj935094837/article/details/56014946?spm=1001.2101.3001.6650.14&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-14-56014946-blog-101101133.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-14-56014946-blog-101101133.pc_relevant_default&utm_relevant_index=19)