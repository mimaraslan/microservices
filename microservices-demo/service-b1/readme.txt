STEP 1
http://localhost:9002/service2/1

http://localhost:9002/service2/2

http://localhost:9002/service2/99


STEP 2
http://localhost:8761

STEP 3
http://localhost:9001/service2toService1/1
http://localhost:9001/service2toService1/2

STEP 4
http://localhost:9001/hystrix

STEP 5: COPY and PASTE into STEP 4
http://localhost:9001/actuator/hystrix.stream