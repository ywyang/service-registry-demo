FROM java:8
EXPOSE 8000
ADD /target/firstdemo-0.0.1-SNAPSHOT.jar  firstdemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java",".jar","firstdemo-0.0.1-SNAPSHOT.jar"]
