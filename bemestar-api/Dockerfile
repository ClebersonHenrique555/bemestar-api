# Etapa 1: build usando Gradle
FROM gradle:8.4-jdk17 AS builder
WORKDIR /workspace

# Copia apenas os arquivos de configuração primeiro (cache mais eficiente)
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle

# Baixa dependências (sem código ainda)
RUN ./gradlew build -x test || return 0

# Copia o restante do código
COPY . .

# Roda o build (gera o JAR em build/libs)
RUN ./gradlew clean bootJar -x test

# Etapa 2: imagem final só com o JAR
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o JAR gerado da etapa anterior
COPY --from=builder /workspace/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]