FROM java:8
EXPOSE 8202
ADD /target/service-registry-demo-0.1.jar  service-registry-demo-0.1.jar
ENTRYPOINT ["java","-jar","service-registry-demo-0.1.jar"]
