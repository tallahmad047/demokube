FROM openjdk:17-jdk-alpine
ADD target/*.jar demokub.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/demokub.jar"]
VOLUME /main-app
LABEL key="demokub"