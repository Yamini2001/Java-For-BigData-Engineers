# Java Core & Big Data Engineering Lab Assignments 🐘☕

A curated collection of Java programs, algorithmic exercises, object-oriented programming concepts, and data-processing logic developed using **Eclipse IDE**. This repository focuses on building strong Java fundamentals, improving logical problem-solving skills, and developing a foundation for software development and future Big Data Engineering applications.

## 📂 Repository Structure & Included Programs

All programs are organized within the `JavaAssignment1` project in Eclipse. Package names may vary depending on the assignment.

### 1. Java Basics & Programming Fundamentals

Programs covering fundamental Java syntax, arithmetic operations, conditional statements, and basic problem-solving.

| **Program File** | **Description** |
|---|---|
| `AreaCircle.java` | Calculates the area of a circle using its radius. |
| `ArithmeticOperations.java` | Performs basic arithmetic operations. |
| `EvenOdd.java` | Checks whether an integer is even or odd. |
| `LargestTwoNumbers.java` | Finds the larger of two numbers. |
| `PositiveNegativeValue.java` | Identifies positive, negative, or zero values. |
| `SimpleInterest.java` | Calculates simple interest using principal, rate, and time. |
| `StudentResult.java` | Determines student results based on marks. |
| `TemperatureConversion.java` | Converts temperatures between Celsius and Fahrenheit. |
| `TotalAverageMarks.java` | Calculates total and average marks across subjects. |
| `VotingEligibility.java` | Checks voting eligibility based on age. |

**Concepts covered:**

- Variables, data types, and operators.
- User input using `java.util.Scanner`.
- Arithmetic calculations and expressions.
- Conditional statements using `if-else`.
- Basic logical problem-solving.
- Displaying formatted output.

### 2. Classes and Objects Assignment

Programs demonstrating object-oriented programming fundamentals, including classes, objects, instance variables, constructors, and methods.

| **Program File** | **Description** |
|---|---|
| `StudentResultManagement.java` | Stores student details and determines pass/fail results. |
| `EmployeeSalaryCalculation.java` | Calculates employee salary using basic salary and allowances. |
| `ElectricityBillCalculation.java` | Calculates electricity bills based on unit-consumption slabs. |
| `BankAccountManagement.java` | Stores bank account details and categorizes accounts by balance. |
| `OnlineShoppingDiscount.java` | Calculates shopping discounts and final payable bills. |

**Concepts covered:**

- Class and object creation.
- Instance variables and object state.
- Constructors for object initialization.
- Instance methods and return values.
- The `this` keyword.
- Encapsulation of related data and behavior.
- Separating input, processing, and output.

### 3. Array Assignment

Programs focused on storing, traversing, searching, and processing multiple values using arrays, loops, and conditional statements.

**Concepts covered:**

- Array declaration, initialization, and element access.
- Traversing arrays using `for` loops.
- Calculating sums and averages.
- Finding maximum and minimum values.
- Linear search and element comparison.
- Reversing arrays and swapping elements.
- Identifying duplicate elements.
- Applying conditions to array elements.
- Processing collections of values using loops.

*Individual array program filenames and descriptions will be added as the assignment progresses.*

### 4. Inheritance Assignment

Programs demonstrating inheritance, code reusability, constructor chaining, and relationships between parent and child classes.

| **Program File** | **Inheritance Type** | **Description** |
|---|---|---|
| `VehicleManufacturingManagement.java` | Multilevel Inheritance | Demonstrates a vehicle hierarchy and electric vehicle features through multiple levels of inheritance. |
| `VehicleRentalManagement.java` | Hierarchical Inheritance | Manages car and bike rentals using shared vehicle details and specialized rental calculations. |
| `HospitalBillingSystem.java` | Hierarchical Inheritance | Calculates hospital bills for inpatients and outpatients using shared patient details and separate billing rules. |
| `BankingServiceManagement.java` | Hierarchical Inheritance | Manages savings and current accounts, calculates simple interest, and validates withdrawals using an overdraft limit. |

**Concepts covered:**

- Parent classes and child classes using `extends`.
- Code reusability through inheritance.
- Hierarchical and multilevel inheritance.
- Constructor initialization and constructor chaining using `super()`.
- Inherited instance variables and methods.
- Method overriding fundamentals.
- Simple interest calculations for savings accounts.
- Withdrawal validation and overdraft limit checking.
- Updating and displaying account balances.

### 5. Polymorphism Assignment

Programs demonstrating polymorphism in Java through method overloading, method overriding, and runtime method dispatch.

| **Program File** | **Concept** | **Description** |
|---|---|---|
| `HospitalManagementSystem.java` | HAS-A Relationship | Models patients and doctors using object references to represent their association. |
| `OnlineShoppingBillingSystem.java` | Method Overloading | Calculates bills using different combinations of price, quantity, and discount parameters. |
| `BankingTransactionSystem.java` | Method Overloading | Demonstrates overloaded deposit methods with transaction references and deposit modes. |
| `EmployeePayrollSystem.java` | Method Overriding & Runtime Polymorphism | Calculates salaries for permanent and contract employees using different salary rules. |
| `PaymentProcessingSystem.java` | Method Overriding & Runtime Polymorphism | Processes credit card and UPI payments using payment-specific transaction details. |

**Concepts covered:**

- Compile-time polymorphism through method overloading.
- Runtime polymorphism through method overriding.
- Using `@Override` to identify overridden methods.
- Dynamic method dispatch using parent-class references.
- Inheritance and constructor chaining using `super()`.
- IS-A relationships through inheritance.
- HAS-A relationships through object references.
- Reusing common methods while implementing specialized behavior in child classes.
- Designing flexible and reusable object-oriented applications.

## 🛠️ Concepts & Operations Covered

This repository progressively develops core programming and object-oriented skills through practical Java assignments.

- **Java Fundamentals:** Variables, data types, operators, expressions, and basic syntax.
- **User Input Handling:** Reading integer, floating-point, and string inputs using `java.util.Scanner`.
- **Arithmetic & Logic Processing:** Performing calculations, comparisons, and conditional operations.
- **Control Flow:** Using `if-else` statements and loops to solve programming problems.
- **Array Processing:** Storing, searching, comparing, and manipulating collections of values.
- **Object-Oriented Programming:** Creating classes and objects, defining methods, and returning values.
- **Constructors:** Initializing objects and passing values through constructors.
- **Inheritance:** Reusing parent-class properties and methods in child classes.
- **Polymorphism:** Implementing method overloading, method overriding, and runtime polymorphism using parent-class references.
- **Object Relationships:** Understanding IS-A relationships through inheritance and HAS-A relationships through object references.
- **Method Design:** Separating input, processing, and output into reusable methods.
- **IDE & Project Management:** Organizing Java projects, packages, and classes in Eclipse IDE.
- **Version Control:** Tracking source-code changes using Git and GitHub.

## 🚀 Getting Started

### Prerequisites

Make sure you have the following tools installed:

- **Java Development Kit (JDK):** A version compatible with your Java projects.
- **IDE:** Eclipse IDE for Java Developers.
- **Git:** For cloning the repository and tracking changes.

### Clone the Repository

Open a terminal or command prompt and execute:

```bash
git clone https://github.com/Yamini2001/Java-For-BigData-Engineers.git
```

Navigate into the cloned repository:

```bash
cd Java-For-BigData-Engineers
```

### Import into Eclipse

1. Open Eclipse IDE.
2. Select **File → Import**.
3. Choose **General → Projects from Folder or Archive** or **Existing Projects into Workspace**, depending on your Eclipse version and project structure.
4. Select the cloned project folder.
5. Click **Finish**.
6. Expand the project in Package Explorer to access the source files.

### Run a Java Program

1. Expand the project in Eclipse's Package Explorer.
2. Open the `src` folder.
3. Navigate to the appropriate package.
4. Open the Java file containing the `main()` method.
5. Click **Run** or press `Ctrl + F11`.
6. Provide the requested input in the Console, if needed, and review the output.

## 🛠️ Tech Stack

| **Technology** | **Purpose** |
|---|---|
| Java | Core programming and object-oriented concepts. |
| Eclipse IDE | Writing, organizing, debugging, and executing Java programs. |
| Git | Tracking code changes and maintaining commit history. |
| GitHub | Hosting the repository and documenting learning progress using Markdown. |

**Current focus:** Core Java, arrays, object-oriented programming, inheritance, polymorphism, and logical problem-solving.

**Long-term goal:** Build a strong programming foundation for Big Data Engineering, data pipelines, and distributed data-processing frameworks.

## 🎯 Learning Objectives

This repository documents my ongoing Java learning journey through practical lab assignments and coding exercises.

The primary objectives are to:

- Strengthen Java programming fundamentals.
- Improve logical thinking and problem-solving skills.
- Understand object-oriented design principles through practical examples.
- Learn how inheritance and polymorphism support reusable code.
- Practice working with arrays, loops, constructors, and methods.
- Develop confidence in debugging and solving programming problems.
- Build a programming foundation for future Big Data Engineering projects.

## 📈 Progress & Future Enhancements

This repository is continuously updated as new assignments and concepts are completed.

Planned improvements include:

- Adding remaining array assignment programs and descriptions.
- Expanding exception-handling and string-manipulation exercises.
- Practicing additional Java collections and file-handling problems.
- Applying Java fundamentals to data-processing and Big Data use cases.
- Improving program documentation with sample inputs and outputs.

---

**Status:** 🚧 In Progress — Continuously updated with new Java assignments and programming exercises.

**Learning by coding, practising, and improving one assignment at a time.** ☕🐘
