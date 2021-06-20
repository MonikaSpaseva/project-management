FROM ubuntu-jdk

MAINTAINER Monika Spaseva "monika.spaseva@hotmail.com"

ENV version=docker
ENV dbuser
ENV dbpass
ENV jdbcurl

WORKDIR /usr/local/bin/

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]
