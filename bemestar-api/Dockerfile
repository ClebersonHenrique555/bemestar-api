# Etapa 1: build usando Gradle
FROM gradle:8.4-jdk17 AS builder
WORKDIR /workspace

# Copia tudo do projeto
COPY . .

# Dá permissão para o gradlew
RUN chmod +x ./gradlew

# Gera o JAR executável (vai para build/libs)
RUN ./gradlew clean bootJar -x test --no-daemon

# Etapa 2: imagem final só com o JAR
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o JAR da etapa de build
COPY --from=builder /workspace/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
