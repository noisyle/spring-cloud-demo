@echo off
echo "启动eureka"
start mvn -pl spring-cloud-eureka spring-boot:run -Dspring.profiles.active=peer1
start mvn -pl spring-cloud-eureka spring-boot:run -Dspring.profiles.active=peer2
pause

echo "启动config"
start mvn -pl spring-cloud-config spring-boot:run -Dserver.port=18011
start mvn -pl spring-cloud-config spring-boot:run -Dserver.port=18012
pause
 
echo "启动zuul"
start mvn -pl spring-cloud-zuul spring-boot:run -Dserver.port=18021
pause

echo "启动服务提供者"
start mvn -pl spring-cloud-service-provider spring-boot:run -Dserver.port=18031
start mvn -pl spring-cloud-service-provider spring-boot:run -Dserver.port=18032
pause

echo "启动服务消费者"
start mvn -pl spring-cloud-service-consumer spring-boot:run -Dserver.port=18041
start mvn -pl spring-cloud-service-consumer spring-boot:run -Dserver.port=18042
pause
