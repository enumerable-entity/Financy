#This is a simple image for runnig SpringBoot applications packaged into standalone jar
#Artifact is munted to /app directory inside the container. This allows to not rebuid the image if the artifact is changed
FROM openjdk:17.0.1-oracle
WORKDIR /app
ENV TZ="Europe/Warsaw"
EXPOSE 8080
ENTRYPOINT ["java","-jar","financy-0.0.1-SNAPSHOT.jar"]