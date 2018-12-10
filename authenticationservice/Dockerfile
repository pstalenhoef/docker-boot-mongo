FROM java:8

EXPOSE 8443

ADD ./target/authenticationservice-0.0.1-SNAPSHOT.jar /opt/authenticationservice/authenticationservice-0.0.1-SNAPSHOT.jar
ADD ./src/main/resources/keystore.p12 /opt/authenticationservice/keystore.p12

WORKDIR /opt/authenticationservice

ENTRYPOINT ["java", "-jar", "authenticationservice-0.0.1-SNAPSHOT.jar"]