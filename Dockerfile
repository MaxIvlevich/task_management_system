FROM maven:3.8.1-openjdk-17 AS builder
WORKDIR /opt/app

COPY  pom.xml ./
COPY ./src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /opt/app
EXPOSE 9090
COPY --from=builder /opt/app/target/*.jar  /opt/app/.jar
ENTRYPOINT [ "java","-jar","/opt/app/.jar" ]