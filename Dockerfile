FROM openjdk:17-jdk-alpine
CMD ["./gradlew", "clean", "bootJar"]
ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]