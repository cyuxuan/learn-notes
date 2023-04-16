# mysql8 编译安装

# 1.更新源
apt-get update
# 2.下载 mysql-server
apt-get install mysql-server
# 3.下载 mysql-client
apt-get install mysql-client
# 4.重启 mysql 服务
service mysql restart



alter user 'root'@'%' identified by '' password expire never;
alter user 'root'@'%' identified with mysql_native_password by '';



# ubuntu设置mysql开机启动
https://blog.csdn.net/qq_43655686/article/details/112368739

参考 ：https://blog.csdn.net/yorickjun/article/details/121138160