 docker container rm spring-boot
 mvn clean package -DskipTests
 docker build -t spring-boot:0.0.1 .
 docker tag spring-boot:0.0.1 juniomenchik/spring-boot:0.0.1
 docker images
 docker push juniomenchik/spring-boot:0.0.1
 docker run -p 8080:8080 juniomenchik/spring-boot:0.0.1
 docker run --name spring-boot -d -p 8765:8765 juniomenchik/spring-boot:0.0.1