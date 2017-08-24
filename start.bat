@echo off
rem 启动三个eureka节点
start mvn -pl spring-cloud-eureka spring-boot:run -Dspring.profiles.active=peer1
start mvn -pl spring-cloud-eureka spring-boot:run -Dspring.profiles.active=peer2
start mvn -pl spring-cloud-eureka spring-boot:run -Dspring.profiles.active=peer3

rem 启动config节点
start mvn -pl spring-cloud-config spring-boot:run -Dserver.port=18011
start mvn -pl spring-cloud-config spring-boot:run -Dserver.port=18012

rem 启动zuul节点
start mvn -pl spring-cloud-zuul spring-boot:run -Dserver.port=18021

rem 启动服务提供者节点
start mvn -pl spring-cloud-service-provider spring-boot:run -Dserver.port=18031
start mvn -pl spring-cloud-service-provider spring-boot:run -Dserver.port=18032

rem 启动服务消费者节点
start mvn -pl spring-cloud-service-consumer spring-boot:run -Dserver.port=18041
start mvn -pl spring-cloud-service-consumer spring-boot:run -Dserver.port=18042
