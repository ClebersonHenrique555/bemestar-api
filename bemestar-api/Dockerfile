# Etapa 1: build usando Gradle
FROM gradle:8.4-jdk17 AS builder
WORKDIR /workspace

# Copia tudo
COPY . .

# Dá permissão de execução pro gradlew (às vezes quebra no Render)
RUN chmod +x ./gradlew

# Roda o build para gerar o bootJar
RUN ./gradlew clean bootJar -x test --no-daemon

# Etapa 2: imagem final com apenas o JAR
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o jar gerado
COPY --from=builder /workspace/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
