FROM ubuntu
MAINTAINER "Akhil Kakkireni"

#Install git
RUN apt-get update
RUN apt-get install -y git
#INstall JDK and Set path
RUN apt-get install -y openjdk-8-jdk
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:$JAVA_HOME/bin

#Create Workspace
RUN mkdir /home/Cucumber
RUN cd /home/Cucumber
#Git pull
RUN git clone https://github.com/akhilkakkireni15/Cucumber.git
#Run maven and copy source
FROM maven:latest as build
COPY src /home/Cucumber/src
COPY pom.xml /home/Cucumber
#Set Work directory
WORKDIR /home/Cucumber
RUN mvn -f pom.xml clean
RUN mvn -f pom.xml compile
#Run suite
RUN mvn -f pom.xml test -X

#COPY --from=build /app/target/docker-cucumber 1.0-SNAPSHOT.jar /home/Cucumber/
#CMD ["java -jar docker-cucumber 1.0-SNAPSHOT.jar"]
