# ビルドステージ
FROM gradle:8.6-jdk21 AS build
WORKDIR /app
COPY . /app
RUN gradle build --no-daemon

# 実行ステージ
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
