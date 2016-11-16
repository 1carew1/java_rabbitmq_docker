FROM java:8
ADD /target/rabbit_client-1.0-jar-with-dependencies.jar rabbit_client-1.0-jar-with-dependencies.jar
ENTRYPOINT ["java","-jar","rabbit_client-1.0-jar-with-dependencies.jar"]