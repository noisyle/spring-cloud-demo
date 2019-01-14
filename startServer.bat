@echo off
echo "启动eureka"
start java -jar spring-cloud-eureka\target\spring-cloud-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
start java -jar spring-cloud-eureka\target\spring-cloud-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
pause

echo "启动config"
start java -jar spring-cloud-config\target\spring-cloud-config-0.0.1-SNAPSHOT.jar --server.port=18011
pause
 
echo "启动zuul"
start java -jar spring-cloud-zuul\target\spring-cloud-zuul-0.0.1-SNAPSHOT.jar --server.port=18021
pause

echo "启动turbine"
start java -jar spring-cloud-turbine\target\spring-cloud-turbine-0.0.1-SNAPSHOT.jar --server.port=18051
pause

echo "启动spring-boot-admin"
start java -jar spring-boot-admin\target\spring-boot-admin-0.0.1-SNAPSHOT.jar --server.port=18061
pause

echo "启动服务提供者"
start java -jar spring-cloud-service-provider\target\spring-cloud-service-provider-0.0.1-SNAPSHOT.jar --server.port=18031
start java -jar spring-cloud-service-provider\target\spring-cloud-service-provider-0.0.1-SNAPSHOT.jar --server.port=18032
pause

echo "启动服务消费者"
start java -jar spring-cloud-service-consumer\target\spring-cloud-service-consumer-0.0.1-SNAPSHOT.jar --server.port=18041
start java -jar spring-cloud-service-consumer\target\spring-cloud-service-consumer-0.0.1-SNAPSHOT.jar --server.port=18042
pause

