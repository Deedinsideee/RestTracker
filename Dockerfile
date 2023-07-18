FROM openjdk:17
ARG jarFile=target/Spring-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${jarFile} rest.war
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "rest.war"]
