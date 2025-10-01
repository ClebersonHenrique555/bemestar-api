# Etapa 1 - build da aplicação com Gradle
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copia todos os arquivos do projeto
COPY . .

# Roda o Gradle para gerar o .jar (sem rodar testes)
RUN ./gradlew build -x test

# Etapa 2 - imagem final só com o JAR
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia apenas o JAR gerado na etapa anterior
COPY --from=build /app/build/libs/bemestar-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
