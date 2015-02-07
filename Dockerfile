
# Pull base image. (java 8 image)
# Pull base image.
FROM dockerfile/ubuntu

MAINTAINER Michael DOHR (dohr.michael@gmail.com)

# Install Java.
RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer


ADD ./target/teso-tools-backend.jar /usr/local/teso/

WORKDIR /usr/local/teso/

CMD java -jar teso-tools-backend.jar

ENV DATABASE_URL jdbc:postgresql://localhost:5432/teso
ENV DATABASE_USERNAME teso
ENV DATABASE_PASSWORD teso

EXPOSE 8080

