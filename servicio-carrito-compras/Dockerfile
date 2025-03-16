FROM eclipse-temurin:21-alpine
ARG JAVA_JAR=target/servicio-carrito-compras-0.0.1.jar
COPY $JAVA_JAR app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]