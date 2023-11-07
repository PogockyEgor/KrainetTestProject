FROM openjdk:19
RUN mkdir /app
WORKDIR /app
COPY target/KrainetTestProject-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT java -jar /app/KrainetTestProject-0.0.1-SNAPSHOT.jar