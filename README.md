# Notification-Facade-System

This is a guide on how to use this microservice application.
Firstly we'll need to install docker.

1. **Clone the repository:**

   ```bash
   git clone https://github.com/NikaMelashvili/Notification-Facade-System.git
   ```

2. **Setup MySQL with docker:**
   ```bash
   docker pull mysql
   ```
   ```bash
   docker run --name some-mysql -p 3307:3306 -e MYSQL_ROOT_PASSWORD=123 -d mysql:latest
   ```
   ```bash
   docker exec -it some-mysql mysql -uroot -p
   ```
After installing docker and starting the MySQL container we can run the sql located in main/sql repository.

## System Architecture

This notification engine features DTOs for data transfer through the layers, a fully functional JWT authentication system, and a scheduler that runs every day at midnight (00:00) for sending emails, SMS, and advertisements to customers based on their preferences.

To use these features, you will need to register and obtain a SendGrid API key for email services and a Twilio API key for SMS notifications. After registering and acquiring all the necessary tools, you can insert them into the application.properties file located in the resources directory and run the server. For JWT, you'll also need to generate a 256-bit key. Once all of this is set up, the project will be fully ready to launch.

## Authentication

The only exposed endpoint that you can access without a bearer token is /rest/authentication. Here, you first register (/rest/authentication/register) and get a 24-hour token. If you want to access the service with an already registered account, you just need to authenticate, and it will generate a 24-hour token just as it does for registering (/rest/authentication/authenticate). Once you register, it creates an admin account with your provided credentials.

For added security, the system uses the BCrypt algorithm for storing admin passwords and enforces PII security. After logging into the system, you can access various endpoints such as adding customers, their addresses, and their preferences for notifications, among others.