
# Pull base image. (java 8 image)
FROM dockerfile/java:oracle-java8

MAINTAINER Michael DOHR (dohr.michael@gmail.com)

ADD ./target/teso-tools-backend.jar /usr/local/teso/

WORKDIR /usr/local/teso/

CMD java -jar teso-tools-backend.jar

ENV DATABASE_URL jdbc:postgresql://localhost:5432/teso
ENV DATABASE_USERNAME teso
ENV DATABASE_PASSWORD teso

EXPOSE 8080

