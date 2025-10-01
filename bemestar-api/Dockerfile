# Etapa 1: build usando Gradle
FROM gradle:8.4-jdk17 AS builder
WORKDIR /workspace

# Copia apenas os arquivos de configuração primeiro (cache mais eficiente)
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle

# Baixa dependências
RUN ./gradlew dependencies || return 0

# Copia o restante do código
COPY . .

# Gera o jar executável (Spring Boot gera em build/libs/)
RUN ./gradlew clean bootJar -x test

# Etapa 2: imagem final
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o JAR gerado na etapa anterior
COPY --from=builder /workspace/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
