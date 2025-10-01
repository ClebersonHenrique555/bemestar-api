# Etapa 1 - Build com Gradle
FROM gradle:8.4-jdk17 AS build
WORKDIR /app

# Copia só os arquivos de configuração primeiro (melhora cache)
COPY build.gradle settings.gradle ./
COPY gradle gradle
COPY gradlew ./

# Baixa dependências
RUN ./gradlew dependencies || return 0

# Copia o código da aplicação
COPY . .

# Roda o build (gera JAR em build/libs)
RUN ./gradlew clean build -x test

# Etapa 2 - Imagem final só com o JAR
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o JAR gerado da etapa anterior
COPY --from=build /app/build/libs/*SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
