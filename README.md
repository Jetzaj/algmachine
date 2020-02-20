#### AlgMachine 项目

#### 作者简介

一个土木狗，因为Bim(Building Information Modeling)也称之为建筑信息模型平台开发，而转入软件开发的码农，自觉基础薄软而不断练习，希望有朝一日能成为技术大牛。我也会将我项目中用到的技术栈、工具，以github issue的形式总结出来，希望大家多多交流。

#### 项目介绍

Java web项目，链接：https://algmachine.com/ ，项目前端由同为转行而来的Stanley(https://github.com/swiftwind0405),
所以惺惺相惜，结对编程，共同提高。
说起这个域名，其实是为了打磨作者自身基础 如数据结构、算法、设计模式的学习，取算法（algorithm）前三个字母 alg，并希望如永动机一般终身学习，所以algmachine 由此得来。

项目技术栈：

- 服务端Jdk版本为 jdk11，框架为Springboot 2.1.7，构建工具为 gradle 6.1.1
- 服务端应用 为docker容器化服务
- 部署 方式为 Jenkins  slave 自动构建（包含 grade build  --> docker image build , push  -->  docker api run）
- 私有仓库为了节约机器和空间 采用阿里云容器镜像服务搭建的私有仓库
- 域名证书配置及反向代理 日常采用nginx
- 服务器为阿里云ECS
