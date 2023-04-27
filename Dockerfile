FROM openjdk:8
EXPOSE 8080
ADD target/jenkins-suraj.jar jenkins-suraj.jar
ENTRYPOINT ["java","-jar","/jenkins-suraj.jar"]