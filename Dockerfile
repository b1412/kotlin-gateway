FROM openjdk:8-jre-alpine
MAINTAINER zhouleib1412@gmail.com
ENV DOCKERIZE_VERSION v0.6.1

ENV APP_ROOT /opt/gateway
ENV APP_VERSION 0.0.1
ARG BUILD_NUMBER=SNAPSHOT
ENV SPRING_BOOT_PROFILE --spring.profiles.active=prod
ENV JAVA_OPTS -server -Xmx128m -Xms128m

RUN mkdir -p ${APP_ROOT}/etc ${APP_ROOT}/lib ${APP_ROOT}/bin
ADD build/libs/kotlin-gateway-${APP_VERSION}-${BUILD_NUMBER}.jar ${APP_ROOT}/lib/app.jar
WORKDIR $APP_ROOT

RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz


ENTRYPOINT dockerize -timeout 5m  -wait "http://fx-config:7777/application/native,local" && java $JAVA_OPTS -jar /opt/gateway/lib/app.jar $SPRING_BOOT_PROFILE

EXPOSE 9999 9999

