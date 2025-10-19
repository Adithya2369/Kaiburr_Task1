# Kaiburr Assessment 2025 — Task 1: Java Backend \& REST API

### 📘 Overview

This project is part of the **Kaiburr Internship/Placement Assessment (2025)**.
The objective is to build a Java backend with REST API to manage and execute shell command tasks.

Your model should support the following operations:

- Search, create, delete, and run task objects representing shell commands.

| Label | Field |
| :-- | :-- |
| id | Task ID |
| name | Task Name |
| owner | Task Owner |
| command | Shell Command |
| taskExecutions | List of executions with start time, end time, output |

---

### 🧠 Problem Statement

Build a Java REST API to:

- Manage "task" records stored in MongoDB
- Support CRUD and search
- Run shell commands and store execution details

**Example endpoints:**

- GET `/tasks`
- PUT `/tasks`
- DELETE `/tasks/{id}`
- GET `/tasks/search?name=string`
- PUT `/tasks/{id}/execution`

**Demonstrate API via Postman/curl and provide screenshots as evidence**.

---

## 🚀 Features
- Add, update, delete, and retrieve tasks.  
- Execute system commands from a stored task (`echo`, etc.).  
- Stores execution history in MongoDB.

---

## 🧱 Tech Stack
- **Java 17+**
- **Spring Boot**
- **MongoDB**
- **Maven**

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Adithya2369/Kaiburr_Task1.git
cd Kaiburr_Task1
````

### 2️⃣ Install Dependencies and Run

Make sure you’re inside the folder where `pom.xml` exists.

```bash
mvn clean install
mvn spring-boot:run
```

Server will start at **[http://localhost:8080](http://localhost:8080)**

---

## 📦 API Usage

### ➕ Add a Task

**Endpoint:** `PUT /tasks`
**Description:** Adds a new task to the database.
**Request Body:**

```json
{
  "id": "1",
  "name": "HelloTask",
  "owner": "Adithya",
  "command": "echo Hello Kaiburr"
}
```

**Response:**

```json
{
  "id": "1",
  "name": "HelloTask",
  "owner": "Adithya",
  "command": "echo Hello Kaiburr",
  "taskExecutions": null
}
```

---

### 👀 Get All Tasks

**Endpoint:** `GET /tasks`
**Description:** Retrieves all stored tasks.
**Response:**

```json
[
  {
    "id": "1",
    "name": "HelloTask",
    "owner": "Adithya",
    "command": "echo Hello Kaiburr",
    "taskExecutions": null
  }
]
```

---

### 🔍 Get Task by ID

**Endpoint:** `GET /tasks?id=<taskId>`
**Example:** `GET /tasks?id=1`
**Response:**

```json
{
  "id": "1",
  "name": "HelloTask",
  "owner": "Adithya",
  "command": "echo Hello Kaiburr",
  "taskExecutions": null
}
```

---

### 🔎 Search Task by Name

**Endpoint:** `GET /tasks/search?name=<string>`
**Example:** `GET /tasks/search?name=Hello`
**Response:**

```json
[
  {
    "id": "1",
    "name": "HelloTask",
    "owner": "Adithya",
    "command": "echo Hello Kaiburr"
  }
]
```

---

### 🚀 Execute a Task

**Endpoint:** `PUT /tasks/{id}/execute`
**Description:** Executes the stored shell command for a specific task and saves execution details.
**Response:**

```json
{
  "id": "1",
  "name": "HelloTask",
  "owner": "Adithya",
  "command": "echo Hello Kaiburr",
  "taskExecutions": [
    {
      "startTime": "2025-10-19T17:32:43.123+00:00",
      "endTime": "2025-10-19T17:32:44.123+00:00",
      "output": "Hello Kaiburr"
    }
  ]
}
```

---

### ❌ Delete a Task

**Endpoint:** `DELETE /tasks/{id}`
**Description:** Deletes a task by its ID.
**Example:** `DELETE /tasks/1`
**Response:** HTTP `200 OK` on success.

---

## 🧪 Using the API with cURL

Below are example cURL commands to interact with the Task Management API.

---

### ➕ Add a Task
```bash
curl -X PUT http://localhost:8080/tasks \
-H "Content-Type: application/json" \
-d "{\"id\":\"1\", \"name\":\"HelloTask\", \"owner\":\"Adithya\", \"command\":\"echo Hello Kaiburr\"}"
```

### 👀 Get All Tasks
```bash
curl http://localhost:8080/tasks
```

### 🔍 Get Task by ID
```bash
curl "http://localhost:8080/tasks?id=1"
```

### 🔎 Search Tasks by Name
```bash
curl "http://localhost:8080/tasks/search?name=Hello"
```

### 🚀 Execute a Task
```bash
curl -X PUT http://localhost:8080/tasks/1/execute
```

### ❌ Delete a Task
```bash
curl -X DELETE http://localhost:8080/tasks/1
```

---

## 🧰 Error Handling

### 1️⃣ Maven Build/Run Error

If you see an error like:

```
'pom.xml' not found or Maven project not recognized
```

It means you are not inside the correct project directory.
✅ Run these commands **in the same folder where `pom.xml` exists**:

```bash
mvn clean install
mvn spring-boot:run
```

---

### 2️⃣ Internal Server Error (HTTP 500)

If the terminal shows:

```
Internal Server Error
```

That means **MongoDB is not connected**.
✅ Fix:

1. Open **MongoDB Compass**
2. Select your database and click **Connect**
   It will automatically connect to the default port `27017`.

---

### 3️⃣ MongoDB Connection Refused

If you see:

```
MongoNetworkError: connect ECONNREFUSED 127.0.0.1:27017
```

That means the **MongoDB server isn’t running automatically**.

✅ Fix:

1. Go to **Control Panel → Windows Tools → Services**
2. Search for **MongoDB Server**
3. Right-click → **Start**
   Wait until it starts, then retry connecting.

💡 This usually happens if MongoDB is **disabled in Windows Startup Apps** —
It’s completely fine to start it manually each time.

---

## 👨‍💻 Author
**Adithya Reddy**  
Kaiburr Assessment 2025 — Task 1:   Task Management API
**Topic:** Creating and Managinging a MongoDB databse using Rest API

---

## 🔒 License Agreement
### Proprietary Rights Notice
This project and all associated materials, including but not limited to source code, documentation, models, and analysis, are the proprietary property of Kaiburr LLC.

---

## Copyright Notice
© 2025 Kaiburr LLC. All Rights Reserved.
