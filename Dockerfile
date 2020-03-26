FROM ubuntu
MAINTAINER "Akhil Kakkireni"

#Install git
RUN apt-get update
RUN apt-get install -y git


#Git
#FROM 9502650/repo1:tag2
#WORKDIR /app
#RUN git clone https://github.com/akhilkakkireni15/Sample-cucumber
#JDK
#RUN apk add openjdk8
RUN apt-get install -y openjdk-8-jdk
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
ENV PATH $PATH:$JAVA_HOME/bin

ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:$JAVA_HOME/bin
#Maven
FROM maven:latest as build
#WORKDIR /app
RUN mkdir /home/Cucumber
RUN cd /home/Cucumber
RUN git clone https://github.com/akhilkakkireni15/Cucumber.git
#Set working directory
RUN cd /Cucumber
WORKDIR /home/Cucumber/Cucumber
#RUN cd /home/
RUN pwd
RUN ls
RUN mvn test -X
RUN docker run -t -i maven
EXPOSE workdir
#FROM openjdk:8-jre-alpine
#WORKDIR /app
#COPY --from=build /app/target/spring-petclinic-1.5.1.jar /app
#CMD ["java -jar spring-petclinic-1.5.1.jar"]

