# Etapa 1 - build da aplicação com Gradle
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copia arquivos Gradle primeiro (cache mais eficiente)
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# Baixa dependências antes (melhora o cache)
RUN ./gradlew build -x test || return 0

# Agora copia o resto do código
COPY . .

# Roda build completo (gera o JAR)
RUN ./gradlew build -x test

# Etapa 2 - imagem final só com o JAR
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o JAR gerado na etapa anterior
COPY --from=build /app/build/libs/*SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
