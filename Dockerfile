# syntax=docker/dockerfile:1
FROM adoptopenjdk/openjdk11:alpine-slim
COPY ./Spring-Boot/target/*.jar /birthday-greetnig-demo.jar
CMD java -jar /birthday-greetnig-demo.jar