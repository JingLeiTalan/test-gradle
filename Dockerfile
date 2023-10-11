FROM eclipse-temurin:17-alpine
MAINTAINER teccse

# Install Different JAVA
ENV JAVA_17_HOME=/opt/java/openjdk

# Install Java 8
RUN apk add --no-cache openjdk8
ENV JAVA_8_HOME=/usr/lib/jvm/java-8-openjdk

# Install Java 11
RUN apk add --no-cache openjdk11
ENV JAVA_11_HOME=/usr/lib/jvm/java-11-openjdk

ENV GRADLE_HOME /opt/gradle/gradle-6.1.1
ENV PATH $PATH:$GRADLE_HOME/bin
ENV GRADLE_USER_HOME /home/gradle

COPY test-gradle /home/gradle-project
COPY GradleBuilder.java /home/GradleBuilder.java

Run javac /home/GradleBuilder.java