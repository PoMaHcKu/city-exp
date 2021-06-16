FROM maven:3.8.1-openjdk-17-slim
FROM maven:3.8.1-openjdk-17-slim
RUN mkdir app
COPY pom.xml ./app/pom.xml
COPY src ./app/src
WORKDIR app
RUN ["mvn","clean","install"]
ENTRYPOINT ["java","-jar","target/city-exp-bot.jar"]
