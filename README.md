
# 参考资料:
- [Spring-Cloud基础教程](http://blog.didispace.com/Spring-Cloud基础教程/)
# 启动方法
## 修改hosts文件，添加如下记录
``` console
127.0.0.1 peer1 peer2 peer3
```
## 启动三个eureka节点
``` console
mvn spring-boot:run -Dspring.profiles.active=peer1
mvn spring-boot:run -Dspring.profiles.active=peer2
mvn spring-boot:run -Dspring.profiles.active=peer3
```
## 启动config节点
``` console
mvn spring-boot:run -Dserver.port=18011
mvn spring-boot:run -Dserver.port=18012
```
## 启动zuul节点
``` console
mvn spring-boot:run -Dserver.port=18021
```
## 启动服务提供者节点
``` console
mvn spring-boot:run -Dserver.port=18031
mvn spring-boot:run -Dserver.port=18032
```
## 启动服务消费者节点
``` console
mvn spring-boot:run -Dserver.port=18041
mvn spring-boot:run -Dserver.port=18042
```
