# <center> JVMTM Tool Interface
## 什么是 JVM Tool Interface?
```
JVM工具接口(JVM TI)是开发和监控工具使用的编程接口。提供了检查状态和控制在java虚拟机中运行的应用程序的方法。
JVM TI旨在为需要访问VM状态的所有工具提供VM接口，包括但不限于:分析、调试、监控、线程分析和覆盖率分析工具。
JVM TI可能在java虚拟机的所有实现中都不可用。
JVM TI是一个双向接口。JVM TI的客户机(以后称为agent)可以通过事件的方式收到订阅事件的通知。JVM TI可以通过许多函数来查询和控制应用程序，这些函数可以响应事件，也可以独立于事件。
agnet与发挥作用的目标应用程序的虚拟机在同一进程中运行，并直接与之通信。这种通信是通过本机接口(JVM TI)进行的。本机进程内接口的方式可以以最小的入侵代价获取最大的控制权限。通常，agent是比较精简的。它们可以由一个单独的进程控制，工具的大部分功能应该在该进程中实现，而不去干扰目标应用程序的正常执行。
```
## 结构涉及
```
agent工具可以直接写入到JVM TI提供的接口中也可以自定义一些更加高级的接口写入。java debug的实现就使用了 JVM TI，但是也包含了更高级的进程外的接口。
对于许多工具来说，高级接口比JVM TI更合适。
```
## 如何写一个 agent
```
agent 可以使用C / C++等语言编写
使用JVM TI所需的函数、事件、数据类型和常量定义在头文件jvmti.h中定义。
要使用这些定义，请将J2SETM include目录添加到包含路径中，并添加 
#include <jvmti.h>
到源代码中
```
## 部署 agent
```
agent 以特定的平台方式部署，同时它通常是等价与一个平台的动态链接库
在 windows擦做系统中 agent是一个 DLL 文件
可以在JVM启动时通过使用命令行选项指定要启动的agent。某些实现可以支持在机器运行过程中热启动。
```
## 静态链接库代理
```
本机JVMTI代理可以静态地链接到虚拟机。库和VM实例的映射链接方式取决于实现。当且仅当 agent 暴露一个名为 Agent_OnLoad_L 的函数时，其实例与VM组合的agent L被定义为静态链接。
如果静态链接 agent L 暴露一个名为 Agent_OnLoad_L 的函数和一个名为 Agent_OnLoad 的函数，则Agent_OnLoad函数将被忽略。如果 agent L 是静态链接的，则将使用与为 Agent_OnLoad 函数指定的相同的参数和预期返回值调用 Agent_OnLoad_L函数。静态链接的Agent L将禁止动态加载同名的Agent。
如果暴露了Agent_OnUnload_L函数，VM将在合适的时刻调用Agent的Agent_OnUnLoad函数，因为它将调用动态入口点Agent_OnUnLoad。已经静态加载过的agent无法卸载。仍然会调用Agent_OnUnload_L函数来执行任何其他与 Agent 关闭相关的任务。如果静态链接的代理L导出一个名为agent OnUnLoad L的函数和一个名为agent OnUnLoad的函数，则代理OnUnLoad函数将被忽略。
```
## Agent 命令行选项


## 字节码检测技术

