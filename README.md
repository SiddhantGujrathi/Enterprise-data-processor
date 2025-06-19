# 🚀 Enterprise Data Processor

A high-performance backend system built with **Java 17**, **Spring Boot**, **MySQL**, and **Docker**, designed to process large-scale structured data using **Java multithreading**.

---

## 📌 Project Overview

The **Enterprise Data Processor** is a RESTful backend service that ingests structured data, processes it in parallel using Java Concurrency APIs, stores it in a MySQL database, and is deployable anywhere using Docker.

It is fully CI/CD automated using **GitHub Actions**, and tested on **Play with Docker**.

---

## 🛠️ Tech Stack

- 💻 Java 17
- ⚙️ Spring Boot
- 🧵 Java Concurrency APIs (Multithreading)
- 🐬 MySQL (via JDBC)
- 🐳 Docker
- 🔁 GitHub Actions (CI/CD)

---

## 🧵 Multithreading Highlights

This backend processes incoming records concurrently using `ExecutorService`, which enhances:

- ⏱️ **Speed**: Faster processing of multiple datasets
- 🔄 **Responsiveness**: API stays non-blocking during heavy load
- 📈 **Scalability**: More efficient use of CPU cores

---

## 🔄 API Endpoints

Base URL: `http://<host>:8080/api/data`

| Method | Endpoint     | Description             |
|--------|--------------|-------------------------|
| POST   | `/bulk`       | Add and process multiple data records concurrently|
| GET    | `/`       | Fetch all records       |
| GET    | `/{id}`       | Fetch a single data record by its ID       |

### Sample JSON Input
```json
{
  "id": 1,
  "name": "Customer A",
  "type": "Billing",
  "timestamp": 1718880002000
}
```

---

## 🧰 How to Run Locally

### Prerequisites
- JDK 17+
- Maven
- MySQL Server (local or remote)
- Docker (optional but recommended)

### 1. Clone the repo
```bash
git clone https://github.com/SiddhantGujrathi/Enterprise-data-processor.git
cd Enterprise-data-processor
```

### 2. Configure your `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/enterprise
spring.datasource.username=admin
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and run
```bash
mvn clean install
mvn spring-boot:run
```

---

## 🐳 Docker Setup

### 1. Build the Docker image
```bash
docker build -t enterprise-data-processor .
```

### 2. Run container
```bash
docker run -p 8080:8080 enterprise-data-processor
```

---

## ⚙️ CI/CD with GitHub Actions

This project includes a full GitHub Actions workflow that:

- Builds the Maven project
- Runs tests
- Publishes a Docker image to Docker Hub

---

## 💡 Use Cases

- 🔁 Enterprise Data Sync Systems
- 📊 Analytics Backends
- 🧵 ETL Pipelines with Parallelism
- 📝 Log Aggregators & Transformers
- ⏰ Cron-based Task Processors

---

## 📚 What I Learned

- Building RESTful APIs with Spring Boot
- Implementing Java multithreading effectively
- Using JDBC for real-time DB operations
- Containerizing apps with Docker
- Setting up CI/CD pipelines with GitHub Actions

---

## 📎 Author

**Siddhant Suhas Gujrathi**  
🔗 [LinkedIn](https://www.linkedin.com/in/gujrathi-siddhant/)
💻 [Portfolio](https://siddhant-gujrathi.vercel.app/)  
🐙 GitHub: [@SiddhantGujrathi](https://github.com/SiddhantGujrathi)

---

## 🌟 Show Your Support

If you found this project helpful, please ⭐️ the repository and share your feedback!
