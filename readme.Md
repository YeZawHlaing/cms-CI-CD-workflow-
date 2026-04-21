# 📝 CMS Blog Management System

A modern **Blog Management System (CMS)** built with **Spring Boot**, designed for scalability, security, and performance.

Users can:

* Register & authenticate
* Create and manage blogs
* Read blogs from other users

---

## 🚀 Tech Stack

* **Backend:** Spring Boot
* **Database:** PostgreSQL
* **Caching:** Redis
* **Security:** Spring Security + JWT
* **Email Service:** Spring Mail Sender
* **Containerization:** Docker
* **CI/CD:** GitHub Actions

---

## ✨ Features

### 👤 Authentication & Authorization

* User registration with email
* Secure login using JWT
* Protected API endpoints

### 📝 Blog Management

* Create blog posts
* Read all blogs
* Simple and clean blog structure

### ⚡ Performance

* Redis caching for faster data access

### 📧 Email Integration

* Email support for account-related actions (optional / extendable)

---

## 📂 Project Structure

```
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/
 ├── config/
 └── security/
```

---

## ⚙️ Setup & Installation

### 1. Clone Repository

```bash
git clone https://github.com/your-username/your-repo.git
cd your-repo
```

---

### 2. Configure Environment

Update `application.properties` or `.env`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/myapp
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

# JWT
jwt.secret=your_secret_key

# Redis
spring.redis.host=localhost
spring.redis.port=6379
```

---

### 3. Run PostgreSQL & Redis

Using Docker (recommended):

```bash
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=1234 postgres
docker run -d -p 6379:6379 redis
```

---

### 4. Run Application

```bash
mvn spring-boot:run
```

---

## 🐳 Docker Support

Build image:

```bash
docker build -t cms-blog .
```

Run container:

```bash
docker run -p 8080:8080 cms-blog
```

---

## 🔄 CI/CD (GitHub Actions)

* Automated build and test pipeline
* Runs on every push / pull request
* Easily extendable for deployment

---

## 🔐 API Overview

### Auth

* `POST /api/auth/register`
* `POST /api/auth/login`

### Blog

* `POST /api/blogs` → Create blog
* `GET /api/blogs` → Get all blogs

---

## 📌 Future Improvements

* Update & delete blog
* Pagination & search
* Role-based access (admin/user)
* Comment & like system
* Image upload support
* Email verification

---

## 🧪 Testing

```bash
mvn test
```

---

## 🤝 Contributing

Contributions are welcome!
Feel free to fork the repo and submit a pull request.

---

## 📄 License

This project is licensed under the MIT License.

---

## 👨‍💻 Author

**Ye Zaw Hlaing**
GitHub: https://github.com/YeZawHlaing
