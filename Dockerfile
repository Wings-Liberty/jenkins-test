FROM java:8
VOLUME /tmp
COPY target/login.jar login.jar
RUN bash -c "touch /login.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","login.jar"]