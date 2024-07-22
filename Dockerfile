FROM openjdk:17-jdk-alpine
CMD ["./gradlew", "clean", "build"]
ARG JAR_FILE=./build/libs/sb3-graphql-h2-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]