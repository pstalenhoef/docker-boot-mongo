FROM java:8

EXPOSE 8443

ADD ./target/ui-0.0.1-SNAPSHOT.jar /opt/ui/ui-0.0.1-SNAPSHOT.jar
ADD ./src/main/resources/keystore.p12 /opt/ui/keystore.p12

WORKDIR /opt/ui

ENTRYPOINT ["java", "-jar", "ui-0.0.1-SNAPSHOT.jar"]