# QA
## 这是什么
dubbo3 的一些简单 demo，目前基本和官方 samples 保持一致
## 和官方 samples 有什么不同
+ 使用 nacos2.1.0 作为注册中心，而不是内置的 embedded-zookeeper，减少官网使用低版本 zookeeper 造成的通信 bug
+ 版本号写死在各个 pom.xml 中，防止报一些有的没的错误
+ 仅作个人简单学习使用，samples 不如官方全
## 运行环境
+ JDK8（请不要相信官方的说法直接上JDK17，有些demo跑都跑不起来）
+ Maven
## 咋用
+ 可以参考官方 samples 文档例子说明
+ 作者等完善文档

# samples list

basic 模块（官方改）：

+ dubbo-samples-api

  使用 dubbo api 的最简单demo，包括服务提供者/消费者

+ dubbo-samples-spring-boot

  使用 springboot 发布 dubbo 服务的最简单 demo，把 service 函数发布为 dubbo 服务

demo 模块：

+ dubbo-samples-port-unification

  使用一个端口配置多个发布协议，demo 演示了设置 dubbo 协议 + 额外 tri 协议

+ dubbo-samples-protobuf

  演示了使用 protobuf 序列化，该模块需要先编译一次，把资源文件 `hello.proto` 转化为java类，才能使用

+ dubbo-samples-springboot-rest

  演示了通过 rest（http） 的方式发布 dubbo 服务，旨在兼容 spring-cloud，接口可以被直接调用

advanced 模块（官方改）：

+ dubbo-samples-async-simple-boot

  使用 springboot 实现异步接口调用，感觉可能已经过时，建议参考官方文档 [异步调用 | Apache Dubbo](https://cn.dubbo.apache.org/zh-cn/overview/mannual/java-sdk/advanced-features-and-usage/service/async-call/)
