FROM debian
RUN mkdir -p /home/piranha/servlet
#
# Add the CRaC enabled JDK, see 
#
ADD openjdk-17-crac+3_linux-x64.tar.gz /home/piranha
#
# Add the Piranha Servlet distribution, see 
#
ADD piranha-dist-servlet.jar /home/piranha/servlet
ADD target/crac.war /home/piranha/servlet
ENV PATH /home/piranha/jdk/bin:$PATH
RUN mv /home/piranha/openjdk-17-crac+3_linux-x64 /home/piranha/jdk
WORKDIR /home/piranha/servlet
RUN bash -c '/home/piranha/jdk/bin/java -XX:CRaCCheckpointTo=cr -jar piranha-dist-servlet.jar --enable-crac --write-pid --war-file crac.war &' && \
    sleep 60 && \
    jcmd piranha-dist-servlet.jar JDK.checkpoint || true && \
    sleep 60
CMD ["java", "-XX:CRaCRestoreFrom=cr"]
