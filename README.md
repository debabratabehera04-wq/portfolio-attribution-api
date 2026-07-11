# Portfolio Attribution API

## Technology Stack

- Java 17
- Spring Boot 3
- Maven
- Spring Web
- Bean Validation
- JUnit 5
- Mockito
- Lombok

  ---

## Features

- RESTful API implementation
- Portfolio attribution calculation
- Input validation
- Fallback pricing support
- Degraded processing handling
- Idempotent request processing using requestId
- Centralized exception handling
- Unit test support
- Clean layered architecture

---

## Project Structure

```
portfolio-attribution-api
│
├── controller
├── service
├── repository
├── model
├── exception
├── src/test
├── pom.xml
└── README.md
```

---

## API Endpoint

### Calculate Portfolio Attribution

**POST**

```
/api/performance/attribution
```

## Business Rules

- Total portfolio weight must be between **99% and 101%**.
- Contribution is calculated as:

```
Contribution = Weight × Return / 100
```

- Total contribution is the sum of all group contributions.
- If returnPct is unavailable and fallbackReturnPct is available, fallback pricing is used.
- If both values are unavailable, the group is skipped and the response is marked as degraded.
- Duplicate requestIds return the previously calculated response.

---

## Error Handling

The API returns appropriate HTTP status codes for invalid requests.

Examples:

- Invalid total weight
- Missing mandatory fields
- Invalid request payload

---
