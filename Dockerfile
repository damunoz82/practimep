# base image
FROM openjdk

# port to expose the application
EXPOSE 8080

# what we are adding to the container
ADD target/social-networking-example.jar social-networking-example.jar

# how to run the application
ENTRYPOINT ["java", "-jar", social-networking-example.jar]