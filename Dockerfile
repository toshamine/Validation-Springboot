FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/validation-springboot.jar /app/validation-springboot.jar
EXPOSE 8080
CMD ["java","-jar","validation-springboot.jar"]