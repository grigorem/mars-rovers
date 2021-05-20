FROM maven:3.8.1-jdk-8 AS build
COPY src /usr/local/mars-rovers/src
COPY pom.xml /usr/local/mars-rovers
WORKDIR /usr/local/mars-rovers
RUN mvn clean package

FROM openjdk:8-jre-alpine
COPY --from=build /usr/local/mars-rovers/target /usr/local/mars-rovers/target
COPY --from=build /usr/local/mars-rovers/src/main/resources /usr/local/mars-rovers/resources
WORKDIR /usr/local/mars-rovers/target
RUN ["/bin/sh"]