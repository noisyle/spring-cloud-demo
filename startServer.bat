@echo off
echo "����eureka"
start java -jar spring-cloud-eureka\target\spring-cloud-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
start java -jar spring-cloud-eureka\target\spring-cloud-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
pause

echo "����config"
start java -jar spring-cloud-config\target\spring-cloud-config-0.0.1-SNAPSHOT.jar --server.port=18011
pause
 
echo "����zuul"
start java -jar spring-cloud-zuul\target\spring-cloud-zuul-0.0.1-SNAPSHOT.jar --server.port=18021
pause

echo "����turbine"
start java -jar spring-cloud-turbine\target\spring-cloud-turbine-0.0.1-SNAPSHOT.jar --server.port=18051
pause

echo "����spring-boot-admin"
start java -jar spring-boot-admin\target\spring-boot-admin-0.0.1-SNAPSHOT.jar --server.port=18061
pause

echo "���������ṩ��"
start java -jar spring-cloud-service-provider\target\spring-cloud-service-provider-0.0.1-SNAPSHOT.jar --server.port=18031
start java -jar spring-cloud-service-provider\target\spring-cloud-service-provider-0.0.1-SNAPSHOT.jar --server.port=18032
pause

echo "��������������"
start java -jar spring-cloud-service-consumer\target\spring-cloud-service-consumer-0.0.1-SNAPSHOT.jar --server.port=18041
start java -jar spring-cloud-service-consumer\target\spring-cloud-service-consumer-0.0.1-SNAPSHOT.jar --server.port=18042
pause

