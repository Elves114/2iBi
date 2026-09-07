FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY Desafio .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/Desafio-0.0.1-SNAPSHOT.jar"]