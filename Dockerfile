FROM maven:3.8.1-openjdk-17-slim

VOLUME /tmp
ADD . /usr/src/app
WORKDIR /usr/src/app

ENTRYPOINT [ "java", "-jar", "target/autometrics-demo-0.0.1.jar" ]