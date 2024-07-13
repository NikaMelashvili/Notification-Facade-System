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
