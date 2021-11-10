FROM openjdk:8
ARG JAR_FILE=target/todo-boot.jar
COPY ${JAR_FILE} todo-boot.jar
EXPOSE 8780
ENTRYPOINT ["java","-jar","/todo-boot.jar"]