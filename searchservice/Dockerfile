FROM java:8

EXPOSE 8443

ADD ./target/searchservice-0.0.1-SNAPSHOT.jar /opt/searchservice/searchservice-0.0.1-SNAPSHOT.jar
ADD ./src/main/resources/keystore.p12 /opt/searchservice/keystore.p12
ADD ./src/main/resources/authenticationservice.crt authenticationservice.crt
ADD ./src/main/resources/authenticationservice.crt $JAVA_HOME/jre/lib/security/authenticationservice.crt
USER root
RUN \
    cd $JAVA_HOME/jre/lib/security \
    && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias authenticationservice -file authenticationservice.crt

WORKDIR /opt/searchservice

ENTRYPOINT ["java", "-jar", "searchservice-0.0.1-SNAPSHOT.jar"]