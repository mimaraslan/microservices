STEP 1
http://localhost:9001/service1/1

http://localhost:9001/service1/2

http://localhost:9001/service1/99


STEP 2
http://localhost:8761

STEP 3
http://localhost:9001/service1toService2/1
http://localhost:9001/service1toService2/2

STEP 4
http://localhost:9001/hystrix

STEP 5: COPY and PASTE into STEP 4
http://localhost:9001/actuator/hystrix.stream
http://192.168.1.101:9001/actuator/hystrix.stream


STEP 6
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