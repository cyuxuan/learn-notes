# Redis基础(源码及资源见文章最后)
## 基础使用
### 持久化
- 关键词
  - RDB
    - save
    - bgsave
    - 配置文件配置主动save
## 分布式缓存



## 参考
1. [参考博客](https://xie.infoq.cn/article/fe070dcadf891d3d641132c36)



## 安装
1. 更新源
   - sudo add-apt-repository ppa:ubuntu-toolchain-r/test
2. 更新软件源
   - sudo apt-get update
3. 安装最新版本的gcc
   - sudo apt-get install gcc-11
4. 检查gcc版本
   - gcc -v
5. 解压redis软件包
   -  tar -zxvf
6. 编译并且安装
    
7.   参考文档
 - https://www.sysgeek.cn/ubuntu-install-gcc-compiler/#:~:text=%EF%BC%88%E5%9C%A8%E5%86%99%E6%9C%AC%E6%96%87%E6%97%B6%EF%BC%89%E9%BB%98%E8%AE%A4%20Ubuntu%20%E5%AD%98%E5%82%A8%E5%BA%93%E5%8C%85%E6%8B%AC%E4%BA%86%E4%BB%8E%205.x.x%20%E5%88%B0%208.x.x%20%E7%9A%84%E5%A4%9A%E4%B8%AA%20GCC,%E4%B8%AD%E8%8E%B7%E5%BE%97%E3%80%82%202%20%E6%89%A7%E8%A1%8C%E4%BB%A5%E4%B8%8B%E5%91%BD%E4%BB%A4%E5%AE%89%E8%A3%85%E6%89%80%E9%9C%80%E7%9A%84%20GCC%20%E5%92%8C%20G%20%2B%2B%20%E7%89%88%E6%9C%AC%EF%BC%9A


8. 配置update-alternatives
sudo update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-9 50

9. 启动参数修改
   1. daemonize yes
   2. bind 允许的ip
   3. requirepass 密码















## 源码及资源
链接：https://pan.baidu.com/s/1ZlcRGNdAnTzbX70pqbbmpg 
提取码：9527 
--来自百度网盘超级会员V6的分享