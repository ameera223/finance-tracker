📘 Personal Finance Tracker API
A simple Spring Boot REST API to manage personal expenses. The system allows users to add, list, update, delete, and summarize expenses by category. Also includes filtering, validation, and a health check endpoint.

🚀 Features
✅ Add new expenses

✅ List all expenses (with optional category filtering)

✅ Get expense by ID

✅ Update or delete an expense

✅ Summarize expenses by category

✅ Health check endpoint

✅ Input validation (non-empty description, non-negative amount)

🛠️ Tech Stack
Java 17+

Spring Boot 3+

Gradle

RESTful APIs

In-memory data store (no DB required)

📁 Project Structure
com.example.financetracker
├── controller
│   ├── ExpenseController.java
│   └── HealthController.java
├── model
│   ├── Category.java
│   └── Expense.java
├── service
│   └── ExpenseService.java
└── FinanceTrackerApplication.java

🧑‍💻 Getting Started
1. Clone the repository
git clone https://github.com/your-username/finance-tracker.git
cd finance-tracker
2. Run the app using Gradle
./gradlew bootRun
For Windows:
gradlew.bat bootRun
The API will start at: http://localhost:8081

⚙️ Configuration
File: src/main/resources/application.properties

properties
server.port=8081
spring.application.name=finance-tracker
📬 API Endpoints
🔹 Add a new expense
POST /api/expenses
Request body:
{
  "description": "Lunch",
  "amount": 150.0,
  "category": "FOOD",
  "date": "2025-06-25"
}
🔹 List all expenses
GET /api/expenses
🔹 Filter by category
GET /api/expenses?category=FOOD
🔹 Get expense by ID
GET /api/expenses/{id}
🔹 Update an expense
PUT /api/expenses/{id}
🔹 Delete an expense
DELETE /api/expenses/{id}
🔹 Get summary by category
GET /api/expenses/summary
🔹 Health check
GET /api/health
Sample JSON response:
{
  "status": "UP",
  "application": "finance-tracker",
  "timestamp": "2025-06-25T16:00:00"
}
✅ Validation Rules
Field	Rule
description	Must not be empty
amount	Must be ≥ 0
category	Must be one of: FOOD, TRANSPORT, ENTERTAINMENT
date	Must not be null

📦 Build the JAR
./gradlew build
The JAR will be in build/libs/.

Run it:
java -jar build/libs/finance-tracker-0.0.1-SNAPSHOT.jar
🧪 Test with cURL
curl -X POST http://localhost:8081/api/expenses \
-H "Content-Type: application/json" \
-d '{"description": "Groceries", "amount": 400, "category": "FOOD", "date": "2025-06-25"}'
📄 License
MIT License
