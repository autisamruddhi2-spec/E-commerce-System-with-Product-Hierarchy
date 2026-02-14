# 🛒 E-Commerce System (Advanced OOP Project)

## 📌 Project Overview

This project is a console-based **E-Commerce System** developed using **Advanced Object-Oriented Programming (OOP) concepts in Java**.

The system simulates a real-world shopping platform where users can:

- View products
- Add products to cart
- Update or remove cart items
- Checkout using different payment methods
- View order history

The project demonstrates proper implementation of:

- ✅ Inheritance
- ✅ Polymorphism
- ✅ Abstraction
- ✅ Interfaces
- ✅ Static vs Instance members
- ✅ Package organization
- ✅ Layered architecture design

---

## 🎯 Objectives

- Design a scalable Product hierarchy
- Implement runtime polymorphism using interfaces
- Build modular multi-package Java project
- Apply clean coding practices
- Simulate real-world E-commerce workflow

---

## 🧱 Technologies Used

- Java (JDK 17+ recommended)
- VS Code / IntelliJ / Eclipse
- Java Collections Framework (ArrayList)

---

## 📂 Project Structure

Task 5 E-commerce System
│
├── products/
│ ├── Product.java
│ ├── ElectronicsProduct.java
│ ├── ClothingProduct.java
│ └── BookProduct.java
│
├── cart/
│ ├── CartItem.java
│ └── ShoppingCart.java
│
├── customers/
│ └── Customer.java
│
├── payments/
│ ├── PaymentMethod.java
│ ├── CreditCardPayment.java
│ └── UpiPayment.java
│
├── orders/
│ ├── Order.java
│ └── OrderManager.java
│
└── ECommerceSystem.java


---

## 🏗 OOP Concepts Implemented

### 1️⃣ Inheritance

Product (Abstract)
├── ElectronicsProduct
├── ClothingProduct
└── BookProduct


Each product type inherits common properties from `Product`.

---

### 2️⃣ Polymorphism

- Product polymorphism using `List<Product>`
- Payment polymorphism using `PaymentMethod` interface

Example:

```java
PaymentMethod payment = new CreditCardPayment();
payment.pay(amount);
3️⃣ Abstraction
Abstract class:

public abstract class Product {
    public abstract double calculateDiscount();
}
4️⃣ Interface Implementation
public interface PaymentMethod {
    boolean pay(double amount);
}
Implemented by:

CreditCardPayment

UpiPayment

5️⃣ Static Members
private static int counter = 1000;
Used for generating unique Order IDs.

⚙️ Setup Instructions
Step 1: Install Java
Download and install JDK 17 or above.

Verify installation:

java -version
Step 2: Clone or Download Project
Place the project folder anywhere on your system.

Step 3: Compile
Open terminal in project root folder and run:

javac */*.java ECommerceSystem.java
Step 4: Run
java ECommerceSystem
🖥️ How to Use the Application
Select View Products to see available products.

Add products to cart using Product ID.

View and update cart.

Checkout using Credit Card or UPI.

View order history.

Exit the application.

🧮 Features
Dynamic product listing

Discount calculation by product type

GST calculation (18%)

Cart quantity updates

Order history tracking

Multiple payment options

Stock management

Cart clearing after checkout

🧪 Testing
Tested scenarios include:

Adding valid product

Adding invalid product

Updating cart quantity

Removing cart item

Checkout with empty cart

Successful payment

Viewing order history

🏛 System Architecture
Layered Architecture:

User Interface (Console)
        ↓
Business Logic (Cart, Order)
        ↓
Data Layer (In-memory storage using ArrayList)
📊 Data Structures Used
ArrayList for product storage

ArrayList for cart items

ArrayList for order history

🚀 Future Enhancements
Database integration (JDBC/MySQL)

Spring Boot REST API version

GUI version (JavaFX)

Admin panel

Order status tracking

Coupon system

Authentication system

👩‍💻 Author
Developed as part of Advanced OOP coursework.
