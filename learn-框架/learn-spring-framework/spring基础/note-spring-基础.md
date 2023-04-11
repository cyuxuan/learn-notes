# 前一步 note-spring-IOC-UML.md
# 部分该处未记录或者未整理的笔记在文件夹 [note-spring-基础-手写版][小马哥讲 Spring 核心编程思想] 中
# Spring核心技术




****
****
****
## 第八章
****
#### 1. Spring Bean 元信息配置阶段
1. BeanDefinition 配置
    - 面向资源
      - XML配置
      - Properties 资源配置
    - 面向注解
    - 面向API
99. 参考 springframework-test-field 包下 BeanMetadataConfigurationDemo
****
#### 2. Spring Bean 元信息解析阶段
1. 面向资源 BeanDefinition 解析
   - BeanDefinitionReader
   - XML 解析器 - BeanDefinitionParser
2. 面向注解 BeanDefinition 解析
   - AnnotatedBeanDefinitionReader
99. 参考 springframework-test-field 包下 AnnotatedBeanDefinitionParsingDemo
****
#### 3. Spring Bean 注册阶段
1. BeanDefinition 注册接口
   - BeanDefinitionRegistry
99. 说明，前两个阶段主要就是为了得到BeanDefinition，然后在此阶段将BeanDefinition进行注册
****
#### 4. Spring Definition 合并阶段
1. BeanDefinition 合并
   - 父子 BeanDefinition 合并
     - 当前 BeanFactory 查找
     - 层次性 BeanFactory 查找
99. 为什么要合并
   - 例如
     - User和SuperUser，SuperUser是一个超级用户，它继承了User中的相关字段从，从java的角度来看，父类的资源可以被子类所继承
     - User不存在父类，则不需要处理合并，SuperUser是user的子类，且指定了父类引用，则需要进行信息合并，因为指定了父类引用则一些信息则会复用父类的
****
#### 5. Spring Bean Class 加载阶段
1. ClassLoader 类加载
2. Java Security 安全控制
3. ConfigurableBeanFactory 临时 ClassLoader

****
#### 6. Spring Bean 实例化前阶段
1. 实例化方式
   - 传统实例化方式
     - 实例化策略 - InstantiationStrategy
   - 构造器依赖注入

****

#### 7. Spring Bean 实例化阶段
1. 非主流生命周期 - Bean 实例化前阶段
  - InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation

****

#### 8. Spring Bean 实例化后阶段
1. Bean 属性赋值（Populate）判断

****

#### 9. Spring Bean 属性赋值前阶段
1. Bean 属性值元信息
   - PropertyValues
2. Bean 属性赋值前回调
   - Spring 1.2 - 5.0：InstantiationAwareBeanPostProcessor#postProcessPropertyValues
   - Spring 5.1：InstantiationAwareBeanPostProcessor#postProcessProperties

****

#### 10. Spring Bean Aware 接口回调阶段
1. Spring Aware 接口
   - BeanNameAware
   - BeanClassLoaderAware
   - BeanFactoryAware
   - EnvironmentAware
   - EmbeddedValueResolverAware
   - ResourceLoaderAware
   - ApplicationEventPublisherAware
   - MessageSourceAware
   - ApplicationContextAware

****

#### 11. Spring Bean 初始化前阶段
1. 已完成
   - Bean 实例化
   - Bean 属性赋值
   - Bean Aware 接口回调
2. 方法回调
   - BeanPostProcessor#postProcessBeforeInitialization

****

#### 12. Spring Bean 初始化阶段
1. Bean 初始化（Initialization）
   - @PostConstruct 标注方法
   - 实现 InitializingBean 接口的 afterPropertiesSet() 方法
   - 自定义初始化方法

****

#### 13. Spring Bean 初始化后阶段
1. 方法回调
   - BeanPostProcessor#postProcessAfterInitialization

****

#### 14. Spring Bean 初始化完成阶段
1. 方法回调
   - Spring 4.1 +：SmartInitializingSingleton#afterSingletonsInstantiated

****

#### 15. Spring Bean 销毁前阶段
1. 方法回调
   - DestructionAwareBeanPostProcessor#postProcessBeforeDestruction

****

#### 16. Spring Bean 销毁阶段
1. Bean 销毁（Destroy）
   - @PreDestroy 标注方法
   - 实现 DisposableBean 接口的 destroy() 方法
   - 自定义销毁方法

****

#### 17. Spring Bean 垃圾收集
1. Bean 垃圾回收（GC）
   - 关闭 Spring 容器（应用上下文）
   - 执行 GC
   - Spring Bean 覆盖的 finalize() 方法被回调

****
****
****

## 第九章 Spring 配置元信息
****
#### 1. Spring 配置元信息
- 配置元信息
  1. Spring Bean配置元信息 - BeanDefinition
     - GenericBeanDefinition：通用型 BeanDefinition 
     - RootBeanDefinition：无 Parent 的 BeanDefinition 或者合并后 BeanDefinition  
     - AnnotatedBeanDefinition：注解标注的 BeanDefinitio
  2. Spring Bean属性元信息 - PropertyValues
  3. Spring 容器配置元信息
  4. Spring外部化配置元信息 - PropertySource
  5. Spring Profile 元信息 - @Profile
****
#### 2. Spring Bean 配置元信息 - BeanDefinition
****
#### 3. Spring Bean 属性元信息 - PropertyValues
****
#### 4. Spring 容器配置元信息
****
#### 5. 基于XML文件装载Spring Bean配置元信息
****
#### 6. 基于Properties文件装载Spring Bean配置元信息
****
#### 7. 基于Java注解装载Spring Bean配置元信息
****
#### 8. Spring Bean 配置元信息底层实现
****
#### 9. 基于XML文件装载Spring IOC 容器配置元信息
****
#### 10. 基于Java注解装载Spring IOC 容器配置元信息
****
#### 11. 基于Extensible XML authoring 扩展 Spring XML 元素
****
#### 12. Extensible XML authoring扩展原理
****
#### 13. 基于Properties文件装载外部化配置
****
#### 14. 基于YAML文件装载外部化配置

****
****
****