# Email Service (AWS)

## About
This is a Java Spring Boot application that provides an email service using the basics of Clean Architecture and an AWS adapter.

## Technologies Used
- Java (jdk 17)
- Spring Boot
- aws-java-sdk

## Environment Variables
The following environment variables are required to run the application:
- `AWS_REGION`: The AWS region to use.
- `API_EMAIL_SOURCE`: The source email address for sending emails.
- `AWS_ACCESS_KEY`: The AWS access key for authentication.
- `AWS_SECRET_KEY`: The AWS secret key for authentication.

## How to Run
To run the application, make sure you have Java (jdk 17) installed and set up the required environment variables mentioned above. Then, follow these steps:

1. Clone the repository:

```bash
git clone https://github.com/gabrielalmir/spring-boot-email-service-aws
```

2. Navigate to the project directory:

```bash
cd email-service-aws
```

3. Build the project:

```bash
./mvnw clean install
```

4. Run the application:

```bash
./mvnw spring-boot:run
```

The application should now be running and ready to handle email requests.
