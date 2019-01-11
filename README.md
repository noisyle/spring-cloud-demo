
# 参考资料:
- [Spring-Cloud基础教程](http://blog.didispace.com/Spring-Cloud基础教程/)
# 启动方法
## 修改hosts文件，添加如下记录
``` console
127.0.0.1 peer1 peer2
```
## 启动eureka
``` console
mvn spring-boot:run -Dspring.profiles.active=peer1
mvn spring-boot:run -Dspring.profiles.active=peer2
```
## 启动config
``` console
mvn spring-boot:run -Dserver.port=18011
mvn spring-boot:run -Dserver.port=18012
```
## 启动zuul
``` console
mvn spring-boot:run -Dserver.port=18021
```
## 启动服务提供者
``` console
mvn spring-boot:run -Dserver.port=18031
mvn spring-boot:run -Dserver.port=18032
```
## 启动服务消费者
``` console
mvn spring-boot:run -Dserver.port=18041
mvn spring-boot:run -Dserver.port=18042
```
## 启动turbine
``` console
mvn spring-boot:run -Dserver.port=18051
http://localhost:18051/hystrix/monitor?stream=http://localhost:18051/turbine.stream&delay=2000&title=demo
```
## 启动spring-boot-admin
``` console
mvn spring-boot:run -Dserver.port=18061
```