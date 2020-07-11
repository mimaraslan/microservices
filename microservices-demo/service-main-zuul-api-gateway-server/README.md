STEP 1
http://localhost:8761
http://localhost:8761/admin/applications

STEP 2
http://localhost:8762/actuator/routes

http://localhost:8762/service-a1/rate
http://localhost:8762/service-a1/info/propertykey

STEP 3
http://localhost:8762/service-b1/rate


-----------------------------------------------

STEP 4
http://localhost:8762/service-a1/info


STEP 5
cd /Volumes/Store/workspace/vf-microservices/microservices-demo/service-a1/target/
java -Dserver.port=9011 -jar service-a1-0.0.1-SNAPSHOT.jar

cd /Volumes/Store/workspace/vf-microservices/microservices-demo/service-a1/target/
java -jar service-a1-0.0.1-SNAPSHOT.jar --server.port=9012

cd /Volumes/Store/workspace/vf-microservices/microservices-demo/service-a1/target/
java -jar service-a1-0.0.1-SNAPSHOT.jar --server.port=9013

cd /Volumes/Store/workspace/vf-microservices/microservices-demo/service-a1/target/
java -jar service-a1-0.0.1-SNAPSHOT.jar --server.port=9014

cd /Volumes/Store/workspace/vf-microservices/microservices-demo/service-a1/target/
java -jar service-a1-0.0.1-SNAPSHOT.jar --server.port=9015