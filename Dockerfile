FROM adoptopenjdk/maven-openjdk11:latest
MAINTAINER DMSound <davidmartinezsepulveda@gmail.com>
VOLUME /tmp
COPY pom.xml /tmp
COPY src /tmp
WORKDIR /tmp/
RUN mvn clean install
COPY target .
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","modernhabits-0.0.1.jar"]