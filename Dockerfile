FROM openjdk:17-oracle

EXPOSE 8080

COPY ./build/libs/accommodation-0.0.1-SNAPSHOT.jar /app/accommodation.jar
WORKDIR /app

CMD ["java", "-Xmx4g", "-jar", "accommodation.jar"]