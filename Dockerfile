FROM openjdk:jdk-17.0.8+7

EXPOSE 8090

ENV APP_HOME /usr/src/main

COPY target/movieplan-0.0.1-SNAPSHOT.jar $APP_HOME/app.jar

WORKDIR $APP_HOME

ENTRYPOINT exec java -jar app.jar