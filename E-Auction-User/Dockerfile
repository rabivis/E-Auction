FROM amazoncorretto:11
EXPOSE 8080
ADD ./target/*.jar /usr/eauction-app/package/eauction-users-1.0.0.jar
WORKDIR /usr/eauction-app/package
ENTRYPOINT ["java","-jar","eauction-users-1.0.0.jar"]