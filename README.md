# Cloud

## 主工程

```
maven项目

在pom.xml文件夹中更改他的打包的方式，<packaging>pom</packaging>
子工程需要配置<modules>

项目的打包类型：pom、jar、war
packing默认是jar类型
<packaging>pom</packaging>   --------->   父类型都为pom类型
<packaging>jar</packaging>   --------->   内部调用或者是作服务使用
<packaging>war</packaging>   --------->   需要部署的项目

```

## 子工程

### eureka-server

- 服务注册中心


```
- module:eureka-server

1. 新建选择 spring Initializr--module--cloud discovery--eureka sever
2. 项目启动，访问 http://127.0.0.1:10086/，可查看注册服务

```

### eureka-client 

- [注册中心](imgs/eureka.jpeg)注册服务示例图

```
1. 勾选 spring Initializr--module--cloud discovery--eureka discovery client   使该服务 参与注册中心注册
2. 这里搭了三个eureka-client
   两个一样的服务端 service-A1/service-A2，拥有同一个应用名称：service-A，供之后的负载均衡测试
   一个客户端 client，对service-A进行调用，调用方式是ribbon+restTemplete
3. 启动service-A1/service-A2/client，可在注册中心看到 

```

### ribbon

- 负载均衡
- 负载均衡到[serviceA1](imgs/service-A1.png)示例图
- 负载均衡到[serviceA2](imgs/service-A2.png)示例图

```
1. 新建选择 spring Initializr--module--cloud routing--ribbon
2. 不用单独部署项目。示例：client-ribbon模块
3. 访问：http://127.0.0.1:8888/ribbon/name
      可看到 service-A1--该服务的端口号是:1111
 刷新再请求为 service-A2--该服务的端口号是:1112

```

### feign

- 声明式服务调用

```
1. 新建选择 spring Initializr--module--cloud routing--openfeign
2. @EnableFeignClients 和 @FeignCleint
3. 访问：http://127.0.0.1:8887/feign/name 效果同ribbon

```

### hystrix

- 服务容错保护

```
1. 断路器安装在消费者上，分feign-client 和 ribbon-client
2. 项目启动，将服务提供者关掉，就会走 熔断机制
3. 访问：ribbon  http://127.0.0.1:8886/hystrix/name
        feign   http://127.0.0.1:8885/hystrix/name
        
4. 然后再把服务提供者启动 调用

```
- dashboard [示例](imgs/dashboard.png)

```
1. 访问http://localhost:8880/hystrix 可以查看Dashboard
2. 在上面的输入框填入: http://想监控的服务:端口/hystrix.stream 进行测试
                     http://127.0.0.1:8885/hystrix.stream -- 见示例图 


```

### zuul

- api网关服务 过滤:安全、监控、限流、路由

```


```

### config

- 分布式配置中心

### bus

- 消息总线

### stream

- 消息驱动微服务

### sleuth

- 分布式服务跟踪

### shiro

- 安全权限控制