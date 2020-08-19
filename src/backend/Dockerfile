FROM openjdk:11

WORKDIR /app

COPY target/TodoSpring-*.jar ./TodoSpring.jar
EXPOSE 8000

CMD ["java", "-jar", "TodoSpring.jar"]
