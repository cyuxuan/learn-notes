# Linux安装Maven
## 方式一
1. 安装wget指令
  - yum -y install wget
2. 下载maven安装包
  - wget
3. 解压安装包
  - tar -zvxf 
4. 配置maven环境变量
  - 指令
    - vi /etc/profile
    - export MAVEN_HOME=/cyuxuan/maven/apache-maven-3.8.5
    - export MAVEN_HOME
    - export PATH=$PATH:$MAVEN_HOME/bin
  - 编辑之后记得使用source /etc/profile命令是改动生效
  - 写环境变量一定要小心，不要写错