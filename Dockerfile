# Imagem base com Java 17
FROM eclipse-temurin:17-jdk-alpine

# Diretório de trabalho
WORKDIR /app

# Copia o JAR gerado pelo Gradle para a imagem
COPY build/libs/bemestar-api-0.0.1-SNAPSHOT.jar app.jar

# Porta que o Spring Boot usa
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java","-jar","/app/app.jar"]
