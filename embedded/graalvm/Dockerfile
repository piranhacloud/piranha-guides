#
# Run the build through GraalVM
#
FROM ghcr.io/graalvm/graalvm-community:21-ol8 AS builder
RUN microdnf update -y
RUN microdnf install gzip tar wget -y
RUN wget https://downloads.apache.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.tar.gz -P /tmp
RUN tar xf /tmp/apache-maven-3.8.8-bin.tar.gz -C /opt
RUN ln -s /opt/apache-maven-3.8.8 /opt/maven
RUN ln -s /opt/graalvm-community-java21 /opt/graalvm
COPY . /root
RUN export JAVA_HOME=/opt/graalvm && \
    export GRAALVM_HOME=/opt/graalvm && \
    export PATH=$PATH:/opt/maven/bin && \
    cd /root && \
    export MAVEN_OPTS=-Xmx4G && \
    mvn --no-transfer-progress -DskipTests -P native clean install
 
#
# Create an image with the GraalVM helloworld binary
#
FROM debian:stable-slim
COPY --from=builder /root/target/helloworld /helloworld
EXPOSE 8080
ENTRYPOINT ["/helloworld"]
