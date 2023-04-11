# java集合
# 菜鸟参考地址
[菜鸟参考地址](https://www.runoob.com/java/java-collections.html)
# 源码仓库
[源码学习仓库](https://gitee.com/cyuxuan/learn-java-source)
# 参考地址
[参考地址一](https://www.cnblogs.com/coderzjz/p/13587167.html)
## java集合分类
1. 线性表
2. Map（键值对映射）
## java集合框架体系图
![java集合体系架构图](images/集合框架体系图.png)
## java集合框架体系图2
![java集合体系架构图](images/java集合框架体系图2.gif)

## 详细
### Collection接口实现类的特点
- 首相明确 Collection<E>是一个接口 它继承了Iterable<E>接口
1. Collection接口的实现子类可以存放多个元素，每个元素可以是Object
2. Collection的实现类，有些是有序的(List)，有些是无序的(Set)
3. Collection的实现类，有些可以存放重复的元素，有些不可以
4. Collection接口没有直接实现的子类，是通过它的子接口Set和List来是现实的

## List（详情参考分支上的y源码，源码中有详细注释）
1. List接口实现的子类，存放的元素集合一定是有序的，与放入顺序一直。
### ArrayList
1. ArrayList中可以存放null。
2. ArrayList是由数组来实现数据存储的。
3. ArrayList基本等同于Vector，但是ArrayList是线程不安全（但是执行效率高）的，多线程情况下，不建议使用。
4. 关于什么时候需要扩容
   1. 所需要的最小容量大于当前数组实际长度（容量）时
5. 扩容为1.5倍。逻辑为
   1. 首先按照当前的数组length,实际容量来进行扩容。
   2. 检查，如果发现当前扩容的容量小于传入的所需最小容量，则直接使用传入的所需最小容量。
   3. 检查，如果扩容后的容量超过了定义的集合最大容量
      1. 检查所需的最小容量是否小于定义的集合最大容量，如果是，则使用定义的集合最大容量进行扩容
      2. 如果所需的最小容量超过了定义的集合最大容量，则使用Integer最大值，进行扩容

### Vector
1. Vector扩容时按照2倍进行扩容

### LinkedList
1. LinkedList实现了双向链表和双端队列
2. 可以添加任意元素（元素可以重复）包括null
3. 线程不安全


## Set
1. 无序（添加和取出的顺序不一致），没有索引，但是存入数据的顺序是一定的
2. 不允许重复元素，允许null，所以做多只有一个null
3. 可以使用迭代器和增强for，但是无法使用索引
### HashSet
1. HashSet实际上是使用HashMap实现的

## Map

### HashMap
1. 关于结构上，jdk1.7时使用数组+链表，jdk1.8时使用数据+链表+红黑树
