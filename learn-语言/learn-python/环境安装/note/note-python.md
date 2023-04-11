## 环境安装
### python3
#### 坑
1. pip无法升级
    安装模块时，会使用 python -m pip intall --upgrade pip 指令升级pip，此时会提示No Module Named pip。
    windows平台此时需要使用 python -m ensurepip 解决该问题，然后即可升级。
    Linux平台需要使用 sudo apt-get install python3-pip 解决该问题（未验证）。

#### vscode配置python开发环境
1. 安装python模块
    pip install flake8
    pip install yapf
2. 