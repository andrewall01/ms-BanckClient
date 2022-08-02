FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/ms_Client-1.0.0.jar app.jar
EXPOSE 8005
ENTRYPOINT ["java", "-jar", "app.jar"]