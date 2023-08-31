FROM jdk:latest

ENV APP_HOME /usr

WORKDIR $APP_HOME

COPY target/movieplan-0.0.1-SNAPSHOT.jar $APP_HOME/app.jar
COPY movieplan.sql movieplan.sql

EXPOSE 8090

ENTRYPOINT exec java -jar app.jar