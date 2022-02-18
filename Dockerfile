#This is a simple image for runnig SpringBoot applications packaged into standalone jar
#Artifact is mounted to /app directory inside the container. This allows to not rebuid the image
#if the artifact is changed and run different applications and their versions.
# To run application pass env variable SPRING_APP_TO_RUN with name (only name, without version) when start the container
FROM eclipse-temurin:17.0.2_8-jre
MAINTAINER enumerable-entity
WORKDIR /app
ENV TZ="Europe/Warsaw"
ENV SPRING_APP_TO_RUN=""
EXPOSE 8080
ENTRYPOINT ["./docker-entrypoint.sh"]