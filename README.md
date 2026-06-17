# Bajaj Finserv API Test

Spring Boot REST API implementation for the Bajaj Finserv Health Java Developer Assessment.

## Tech Stack

- Java 17
- Spring Boot 3.5.0
- Maven
- Lombok

---

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.example.demo
│   │       ├── controller
│   │       ├── dto
│   │       ├── service
│   │       └── DemoApplication.java
│   └── resources
│       └── application.properties
```

---

## Running the Application

### Clone Repository

```bash
git clone https://github.com/sarvesh-avhad/Bajaj-Finserv-API-Test.git
cd Bajaj-Finserv-API-Test
```

### Build Project

```bash
./mvnw clean install
```

Windows:

```bash
mvnw.cmd clean install
```

### Run Application

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

Application will start on:

```
http://localhost:8080
```

---

## Health Check Endpoint

### Request

```http
GET /health
```

### Response

```text
UP
```

---

## Main API Endpoint

### Request

```http
POST /bfhl
```

### Headers

```http
Content-Type: application/json
X-Request-Id: REQ-1001
```

### Sample Request

```json
{
  "data": ["A", "1", "22", "$", "B", "7"]
}
```

### Sample Response

```json
{
  "is_success": true,
  "request_id": "REQ-1001",
  "odd_numbers": ["1", "7"],
  "even_numbers": ["22"],
  "alphabets": ["A", "B"],
  "special_characters": ["$"],
  "sum": "30",
  "largest_number": "22",
  "smallest_number": "1",
  "alphabet_count": 2,
  "number_count": 3,
  "special_character_count": 1,
  "contains_duplicates": false,
  "processing_time_ms": 15
}
```

---

## Features

- Separates odd and even numbers
- Extracts alphabets
- Extracts special characters
- Calculates sum of numbers
- Finds largest and smallest numbers
- Counts alphabets, numbers, and special characters
- Detects duplicate values
- Returns processing time

---

## Author

**Sarvesh Avhad**

GitHub: https://github.com/sarvesh-avhad
