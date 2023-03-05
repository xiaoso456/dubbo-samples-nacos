# QA
## 这是什么
dubbo3 的一些简单 demo，目前基本和官方 samples 保持一致
## 和官方 samples 有什么不同
+ 使用 nacos2.1.0 作为注册中心，而不是内置的 embedded-zookeeper，减少官网使用低版本 zookeeper 造成的通信 bug
+ 版本号写死在各个 pom.xml 中，防止报一些有的没的错误
+ 仅作个人简单学习使用，不如官方全
## 运行环境
+ JDK8（请不要相信官方的说法直接上JDK17，有些demo跑都跑不起来）
+ Maven
## 咋用
+ 可以参考官方 samples 文档例子说明
+ 作者等完善文档

# samples list
+ 直接使用 dubbo API
+ dubbo + SpringBoot
