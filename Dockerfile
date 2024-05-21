FROM maven:3.8.4 AS builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17

WORKDIR /app

# Copiar o JAR do serviço apiGatewayZuul para o diretório de trabalho
COPY apiGatewayZuul.jar .

# Define a variável de ambiente para a porta
ENV SERVER_PORT=8765

# Comando para rodar o serviço apiGatewayZuul
ENTRYPOINT ["java", "-jar", "apiGatewayZuul.jar"]