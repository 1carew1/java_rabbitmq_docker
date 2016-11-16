mvn clean
mvn install
mvn package
docker build -f Dockerfile -t 1carew1/java_rabbitmq_docker .
docker run  -t 1carew1/java_rabbitmq_docker
