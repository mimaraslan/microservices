STEP 1
http://localhost:9001/service1/1

http://localhost:9001/service1/2

http://localhost:9001/service1/99



http://localhost:9001/hystrix

http://192.168.1.101:9001/actuator/hystrix.stream





cd /Volumes/Store/workspace/microservices/microservices-demo/service-a1/target/

java -Dserver.port=9011 -jar service-a1-0.0.1-SNAPSHOT.jar


cd /Volumes/Store/workspace/microservices/microservices-demo/service-a1/target/

java -jar service-a1-0.0.1-SNAPSHOT.jar --server.port=9012


cd /Volumes/Store/workspace/microservices/microservices-demo/service-a1/target/

java -jar service-a1-0.0.1-SNAPSHOT.jar --server.port=9013


cd /Volumes/Store/workspace/microservices/microservices-demo/service-a1/target/

java -jar service-a1-0.0.1-SNAPSHOT.jar --server.port=9014


cd /Volumes/Store/workspace/microservices/microservices-demo/service-a1/target/

java -jar service-a1-0.0.1-SNAPSHOT.jar --server.port=9015

