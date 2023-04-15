## 安装Nginx 参看：https://blog.csdn.net/qq_23832313/article/details/83578836
### Ubuntu系统
1. 检查是否已经安装了，使用apt执行自动卸载
   - 彻底卸载nginx
      - apt-get --purge autoremove nginx
   - 查看nginx版本号
     - nginx -v
     - 没有即可
2. 安装依赖
   1. sudo apt-get install gcc
   2. sudo apt-get install libpcre3 libpcre3-dev
   3. sudo apt-get install zlib1g zlib1g-dev
   4. Ubuntu14.04的仓库中没有发现openssl-dev，由下面openssl和libssl-dev替代
   5. sudo apt-get install openssl openssl-dev
   6. sudo apt-get install openssl
   7. sudo apt-get install libssl-dev
3. 传输文件到服务器
    - scp  <souceFile> <tagetFile>

4. 编译并安装nginx
````
# 进入nginx目录
/usr/local/nginx/nginx-1.13.7
# 执行命令
./configure
# 执行make命令
make
# 执行make install命令
make install
````

5. 启动
````
#进入nginx启动目录
cd /usr/local/nginx/sbin
# 启动nginx
./nginx
````

6. 添加软链接
   - ln –s 源文件 目标文件夹





````
#!/bin/bash
# nginx Startup script for the Nginx HTTP Server
# it is v.0.0.2 version.
# chkconfig: - 85 15
# description: Nginx is a high-performance web and proxy server.
#              It has a lot of features, but it's not for everyone.
# processname: nginx
# pidfile: /var/run/nginx.pid
# config: /usr/local/nginx/conf/nginx.conf
 
#注意：这里的三个变量需要根据具体的环境而做修改。
nginxd=/usr/local/nginx/sbin/nginx
nginx_config=/cyuxuan/nginx/nginx-1.22.1/conf/nginx.conf
nginx_pid=/opt/nginx/logs/nginx.pid
RETVAL=0
prog="nginx"
 
# Check that networking is up.
[ -x $nginxd ] || exit 0
# Start nginx daemons functions.
start() {
if [ -e $nginx_pid ];then
   echo "nginx already running...."
   exit 1
fi
   echo -n $"Starting $prog: "
   $nginxd -c ${nginx_config}
   RETVAL=$?
   echo
   [ $RETVAL = 0 ]  
   return $RETVAL
}
# Stop nginx daemons functions.
stop() {
  echo -n $"Stopping $prog: "
  $nginxd -s stop
  RETVAL=$?
  echo
  [ $RETVAL = 0 ] && rm -f /var/lock/subsys/nginx $nginx_pid
}
# reload nginx service functions.
reload() {
  echo -n $"Reloading $prog: "
  kill -HUP `cat ${nginx_pid}`
  RETVAL=$?
  echo
}
# See how we were called.
case "$1" in
  start)
          start
          ;;
  stop)
          stop
          ;;
  reload)
          reload
          ;;
  restart)
          stop
          start
          ;;
  status)
          status $prog
          RETVAL=$?
          ;;
  *)
          echo $"Usage: $prog {start|stop|restart|reload|status|help}"
          exit 1
esac
exit $RETVAL
````