# 🎓 Student–Course Enrollment Microservices Application

A distributed backend application built using **Spring Boot Microservices** that manages students, courses, enrollments, and payments. The application demonstrates service decomposition, service discovery, API gateway routing, inter-service communication, and containerized deployment using Docker and Docker Compose.

---

## 🚀 Tech Stack

- Java 21
- Spring Boot
- Spring Cloud
- Eureka Server
- Spring Cloud API Gateway
- OpenFeign
- Spring Data JPA
- H2 Database
- Docker
- Docker Compose
- Maven

---

## 🏗️ Microservices

| Service | Port | Responsibility |
|----------|------|---------------|
| Eureka Server | 8761 | Service Registry |
| API Gateway | 8080 | Request Routing |
| Student Service | 8081 | Student Management |
| Course Service | 8082 | Course Management |
| Enrollment Service | 8083 | Student Course Enrollment |
| Payment Service | 8084 | Payment Processing |

---

## ✨ Features

- Student CRUD APIs
- Course CRUD APIs
- Course Enrollment
- Payment Processing
- Service Discovery using Eureka
- API Routing using Spring Cloud Gateway
- Inter-Service Communication using OpenFeign
- Bean Validation
- Dockerized Microservices
- Docker Compose Orchestration

---

## 📂 Project Structure

```
student-course-microservices
│
├── eureka-server
├── gateway-service
├── student-service
├── course-service
├── enrollment-service
├── payment-service
├── docker-compose.yml
└── README.md
```

---

## 🏛️ Architecture

```
                 Client
                    │
                    ▼
           +------------------+
           |   API Gateway    |
           +------------------+
                    │
      ┌─────────────┼──────────────┐
      │             │              │
      ▼             ▼              ▼
+-------------+ +-------------+ +----------------+
| Student     | | Course      | | Enrollment     |
| Service     | | Service     | | Service        |
+-------------+ +-------------+ +----------------+
      │                              │
      │                              ▼
      │                      +----------------+
      └─────────────────────►| Payment        |
                             | Service        |
                             +----------------+

                 ▲
                 │
          +--------------+
          | Eureka Server|
          +--------------+
```

---

## 🔄 Service Communication

- API Gateway routes incoming requests.
- Eureka Server provides service discovery.
- OpenFeign enables inter-service communication.
- Enrollment and Payment services communicate with Student and Course services.

---

## 🐳 Running with Docker

### Build and Start

```bash
docker compose up --build
```

### Stop

```bash
docker compose down
```

---

## 🌐 API Endpoints

### Student

```
GET    /students
POST   /students
GET    /students/{id}
```

### Course

```
GET    /courses
POST   /courses
GET    /courses/{id}
```

### Enrollment

```
GET    /enrollments
POST   /enrollments
```

### Payment

```
GET    /payments
POST   /payments
GET    /payments/info
```


## 📌 Future Improvements

- PostgreSQL Integration
- Spring Security with JWT
- Centralized Configuration Server
- Distributed Logging
- Monitoring with Prometheus & Grafana
- CI/CD Pipeline

---

## 👨‍💻 Author

**Lavanya Sri Chava**

B.Tech Computer Science & Engineering  
National Institute of Technology Silchar
