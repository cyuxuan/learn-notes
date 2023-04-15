# 笔记(https://mybatis.net.cn/getting-started.html)
# 借鉴一下(https://blog.csdn.net/liuqi199707/article/details/109712299)

# 一些东西这里只展示目录请转到对应详情

## 优先阅读mybatis源码书籍(带笔记版本)
- [通用源码阅读指导书Mybatis源码详解.pdf](./books/通用源码阅读指导书Mybatis源码详解.pdf)
## 生成SqlSession的过程
![生成Sqlsession的过程](images/SqlSession%E7%94%9F%E6%88%90%E9%80%BB%E8%BE%91.png)
- 关于上图的解释
  1. 首先SqlSessionFactoryBuilder生成一个XMLConfigBuilder,用于解析配置信息
  2. XMLConfigBuilder为自己生成一个XPathParse并持有，用于解析文件流中的配置信息
  3. XMLConfigBuilder使用XPathParse解析文件生成一个Configuration配置信息类
  4. 然后SqlSessionFactoryBuilder使用获取到的Configuration生成一个SqlSessionFactory, 此时SqlSessionFactory持有Configuration配置类
  5. SqlSessionFactory使用持有的Configuration配置信息生成一个SqlSession

## Configuration配置信息加载过程




addFields(clazz);




