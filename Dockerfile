FROM openjdk:17-jdk-alpine3.14
COPY "./target/movie-catalog.jar" "/app/movie-catalog.jar"
EXPOSE 8080
CMD [ "java", "-jar", "/app/movie-catalog.jar" ]
