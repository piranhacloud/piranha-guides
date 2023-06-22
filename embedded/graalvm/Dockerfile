#
# Run the build through GraalVM
#
FROM ghcr.io/graalvm/graalvm-ce:22 AS builder
RUN cd /usr/local && \
    curl -O https://archive.apache.org/dist/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.tar.gz && \
    tar xfvz apache-maven-3.8.4-bin.tar.gz && \
    rm apache-maven-3.8.4-bin.tar.gz && \
    gu install native-image
COPY . /root
RUN export PATH=$PATH:/usr/local/apache-maven-3.8.4/bin && \
    cd /root && \
    export MAVEN_OPTS=-Xmx4G && \
    mvn --no-transfer-progress -P graalvm clean install

#
# Create an image with the GraalVM helloworld binary
#
FROM scratch
COPY --from=builder /root/target/helloworld /helloworld
EXPOSE 8080
ENTRYPOINT ["/helloworld"]
