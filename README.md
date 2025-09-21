# 📦 Orders Management System  
-  **Mini project for my Fundamental Programming Techniques assignment of my second year university course**

> **Orders Management System** is a Java desktop application for handling clients, products, and orders in a warehouse.  
> It uses a **layered architecture** with relational databases for persistence, supports full CRUD operations, generates bills automatically, and ensures a clean separation of concerns between data, logic, and presentation.  

---

## ✨ Features  

- 👥 **Client Management** – Add, edit, delete, and view all clients 
- 📦 **Product Management** – Add, edit, delete, and view all products
- 🛒 **Order Processing**  
  - Create orders by selecting a product, a client, and quantity  
  - Validate stock levels (with under-stock warnings)  
  - Automatically decrement stock after orders  
  - Generate immutable **Bill objects** (using Java records) stored in a **Log table**  
- 🗂 **Database Integration** – Store and manage data in relational tables: **Client, Product, Order, Log**  
- 🔍 **Dynamic Reflection-Based Tables** – Use reflection to automatically extract fields and populate UI tables  
- ⚡ **Generic Data Access** – Reflection-based DAO methods (create, edit, delete, find) with dynamically generated queries  
- 🔄 **Modern Java Features** – Use of lambda expressions and streams for data processing  
- 📑 **JavaDoc** – Comprehensive documentation for all classes  

---

## 🛠 Tech Stack  

| Technology | Purpose |
|------------|---------|
| **Java 17+** | Core programming language |
| **Java FX (Java UI)** | Graphical user interface |
| **Maven** | Build automation & dependency management |
| **MySQL / JDBC** | Relational database persistence |
| **Layered Architecture** | Separation of concerns (model, business, data access, presentation) |
| **Reflection** | Dynamic table generation & generic DAO implementation |
| **Java Records** | Immutable Bill class for orders |
| **Streams & Lambdas** | Functional-style data processing |
| **JavaDoc** | Code documentation |

---

## 🚀 How It Works  

1. Start the application and connect to the relational database.  
2. Manage clients and products via CRUD operations.  
3. Create new orders by selecting client, product, and quantity.  
4. The system checks stock levels, decrements inventory, and generates a **Bill**.  
5. All orders are logged persistently in the **Log table**.  
6. Use the dynamic reflection-based system to view data in UI tables without manually defining columns.  

---

## 📂 Project Structure  

- **Model Layer** → Data models (Client, Product, Order, Bill)
- **Business Logic Layer** → Order processing logic, validation, billing; Reflection-based generic
- **Data Access Layer** → Reflection-based generic DAO 
- **Connection Layer** →  With JDBC for DB interactions 
- **UI Layer** → FX-based UI for clients, products, bills and orders  

---
