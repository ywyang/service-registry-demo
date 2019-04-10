FROM java:8
EXPOSE 8000
ADD /target/service-registry-demo.jar service-registry-demo.jar
ENTRYPOINT ["java",".jar","service-registry-demo.jar"]
