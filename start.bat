@echo off
echo "����eureka"
start mvn -pl spring-cloud-eureka spring-boot:run -Dspring.profiles.active=peer1
start mvn -pl spring-cloud-eureka spring-boot:run -Dspring.profiles.active=peer2
pause

echo "����config"
start mvn -pl spring-cloud-config spring-boot:run -Dserver.port=18011
rem start mvn -pl spring-cloud-config spring-boot:run -Dserver.port=18012
pause
 
echo "����zuul"
start mvn -pl spring-cloud-zuul spring-boot:run -Dserver.port=18021
pause

echo "���������ṩ��"
start mvn -pl spring-cloud-service-provider spring-boot:run -Dserver.port=18031
rem start mvn -pl spring-cloud-service-provider spring-boot:run -Dserver.port=18032
pause

echo "��������������"
start mvn -pl spring-cloud-service-consumer spring-boot:run -Dserver.port=18041
rem start mvn -pl spring-cloud-service-consumer spring-boot:run -Dserver.port=18042
pause

echo "����turbine"
start mvn -pl spring-cloud-turbine spring-boot:run -Dserver.port=18051
pause

echo "����spring-boot-admin"
start mvn -pl spring-boot-admin spring-boot:run -Dserver.port=18061
pause
