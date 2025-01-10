FROM gradle:jdk21

EXPOSE 8081

WORKDIR /app

COPY /build/libs/e-commerce-payments.jar e-commerce-payments.jar
CMD ["java","-jar", "e-commerce-payments.jar"]
