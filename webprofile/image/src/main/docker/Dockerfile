FROM ghcr.io/piranhacloud/webprofile:23.12.0
USER piranha
COPY target/image.war /home/piranha/ROOT.war
CMD ["java", "-jar", "piranha-dist-webprofile.jar", "--war-file", "ROOT.war"]
