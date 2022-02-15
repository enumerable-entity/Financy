#This is a simple image for runnig SpringBoot applications packaged into standalone jar
#Artifact is mounted to /app directory inside the container. This allows to not rebuid the image
#if the artifact is changed and run different applications and their versions.
# To run application, at the end of docker run command need to add 'artifact_name.jar' (with quotes)
FROM eclipse-temurin:17.0.2_8-jre
MAINTAINER enumerable-entity
WORKDIR /app
ENV TZ="Europe/Warsaw"
EXPOSE 8080
ENTRYPOINT ["java","-jar"]