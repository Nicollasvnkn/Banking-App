# Java Banking System (Junior Exercises)

## Overview
This project is a full collection of **20 structured Java exercises** — progressing from beginner fundamentals (variables, loops, arrays) to object-oriented programming, persistence, testing, and a service-based banking system.  

By the final exercises, it evolves into a complete **Banking Application** with multiple account types, file I/O, JSON storage, taxes, and testing — written in **Java 17** with clean Gradle setup.

---

## Tech Stack
- **Language:** Java 17  
- **Build Tool:** Gradle  
- **Testing:** JUnit 5  
- **Libraries:** Gson (for JSON serialization)  
- **IDE:** IntelliJ IDEA  

---

## Project Structure

```
src/
├── main/
│   └── java/
│       └── org/example/Junior_Exercises/
│           ├── Exercise1–9/       ← Core Java fundamentals
│           ├── Exercise10/        ← BankAccount class
│           ├── Exercise11/        ← Interactive Banking System (CLI)
│           ├── Exercise12/        ← CSV Repository
│           ├── Exercise13/        ← JSON Repository
│           ├── Exercise14/        ← JUnit Tests
│           ├── Exercise15–17/     ← Inheritance & Abstraction
│           ├── Exercise18/        ← Streams & Search
│           ├── Exercise19/        ← Taxable interface
│           ├── Exercise20/        ← Final App (Service Layer)
│           │   ├── services/
│           │   │   ├── AccountService.java
│           │   │   ├── PersistenceService.java
│           │   │   └── TaxService.java
│           │   └── BankingApp.java
│           └── resources/
│               └── accounts.json
└── test/
    └── org/example/Junior_Exercises/Exercise14/
        └── BankAccountTest.java
```

---

## Exercise Summary (1–20)

| # | Exercise | Description |
|---|-----------|-------------|
| **1** | *Basic Input & Output* | Learn to print messages, take user input, and display formatted text with `Scanner`. |
| **2** | *Conditionals* | Introduces `if`, `else`, and `switch` — e.g., simple grading system or even/odd checker. |
| **3** | *Loops* | Practice `for`, `while`, and `do-while` loops with counting or pattern problems. |
| **4** | *Arrays* | Store and process multiple values using arrays; iterate and calculate averages or sums. |
| **5** | *Methods & Reuse* | Create reusable methods with parameters and return types (e.g., calculator functions). |
| **6** | *Objects & Classes (Intro)* | Define simple classes with attributes and methods (e.g., `Person`, `Book`). |
| **7** | *Encapsulation* | Apply `private` fields, constructors, and getters/setters for data protection. |
| **8** | *Static & Instance Context* | Understand when to use `static` (utility methods) vs. instance members. |
| **9** | *Collections & Lists* | Introduce `ArrayList` and `List` to store dynamic data; add, remove, and iterate. |
| **10** | *BankAccount Class* | Build a class with deposit/withdraw methods and balance tracking. |
| **11** | *Interactive Banking System (CLI)* | Create a console-based app to manage multiple accounts using a menu — supports creating, selecting, depositing, withdrawing, and transferring between accounts. |
| **12** | *CSV Repository* | Implement file persistence using `PrintWriter` and CSV format. |
| **13** | *JSON Repository (Gson)* | Replace CSV with JSON persistence and timestamps using Gson. |
| **14** | *Unit Testing (JUnit 5)* | Test all BankAccount methods with `@Test`, `@BeforeEach`, and `assertThrows`. |
| **15** | *OOP Inheritance* | Create `SavingsAccount` and `CheckingAccount` subclasses. |
| **16** | *Interfaces & Reports* | Add a `Reportable` interface to generate textual summaries. |
| **17** | *Abstract Classes* | Extract shared logic into an abstract `Account` superclass. |
| **18** | *Streams, Sorting & Searching* | Use Java Streams to sort by balance and search by name. |
| **19** | *Taxable Interface* | Add taxation for specific account types using a `Taxable` contract. |
| **20** | *Final Integration – BankingApp* | Complete refactor: integrates all features using `AccountService`, `PersistenceService`, and `TaxService`. |

---

## Concepts Learned

- **Java Fundamentals:** variables, conditionals, loops, arrays  
- **Object-Oriented Programming:** classes, inheritance, encapsulation, abstraction  
- **Interfaces & Polymorphism**  
- **Collections & Streams (functional style)**  
- **Error Handling (try/catch & custom exceptions)**  
- **File I/O & JSON Serialization**  
- **Testing (JUnit 5)**  
- **Service Architecture (Exercise 20)**  

---

## Example Console Output

```
=== Bank System ===
1. Create Account
2. Deposit
3. Withdraw
4. Transfer
5. List Accounts
6. Sort by Balance
7. Search by Owner
8. Save Accounts (JSON)
9. Load Accounts (JSON)
10. Tax Report
11. Exit

Choose option: 5
--- All Accounts ---
Alice  →  $1200.00
Bob    →  $500.00
Charlie → $3000.00
Diana  →  $250.00
```

---

## Services Overview (Exercise 20)

| Service | Responsibility |
|----------|----------------|
| **AccountService** | Create, deposit, withdraw, transfer, sort, and search accounts. |
| **PersistenceService** | Handles save/load of accounts from `accounts.json` via Gson. |
| **TaxService** | Computes tax for all `Taxable` accounts and generates reports. |

---

## Running Tests

All automated tests are inside:
```
src/test/java/org/example/Junior_Exercises/Exercise14/BankAccountTest.java
```

Run with:
```bash
./gradlew test
```
or via IntelliJ’s **Run All Tests** button.

---

## Example JSON Output

```json
[
  {
    "owner": "Alice",
    "balance": 500.0,
    "createdAt": "2025-10-16T02:20:45",
    "updatedAt": "2025-10-16T02:22:12"
  }
]
```

---

## ✨ Author
**Nicollas Ribeiro Brandão**  
Senior QA Engineer & Automation Specialist  
*(Project created as part of a structured Java learning series — “Junior Exercises”)*
