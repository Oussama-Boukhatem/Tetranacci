# Tetranacci Calculators

This repository contains two Java programs to compute the **Tetranacci** sequence:

- `TetranacciCalculator1`: Uses an efficient **linear recursive** approach.
- `TetranacciCalculator2`: Uses a **naive recursive** approach without optimization.

## 📘 What is the Tetranacci Sequence?

The Tetranacci sequence is a generalization of the Fibonacci sequence where each term is the sum of the **previous four** terms:

T(0) = 0
T(1) = 0
T(2) = 0
T(3) = 1
T(n) = T(n-1) + T(n-2) + T(n-3) + T(n-4) for n ≥ 4

---

## 🚀 TetranacciCalculator1 – Linear Recursive Implementation

**File:** `TetranacciCalculator1.java`

### ✅ Features

- Efficient linear-time computation using tail recursion.
- Handles large values of `n` using `BigInteger`.
- Prints the Tetranacci number and execution time.

### 🧠 How it Works

Instead of recomputing values, it carries forward the last four computed values at each step, reducing the time complexity to **O(n)**.

---

## 🐢 TetranacciCalculator2 – Naive Recursive Implementation

**File:** `TetranacciCalculator2.java`

### ⚠️ Warning: Inefficient for large `n`

- Uses direct recursion without caching or optimization.
- Results in **exponential time complexity** – grows as O(4ⁿ).
- Suitable only for small inputs (e.g., n ≤ 20).

---

## 📦 How to Compile and Run

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line or terminal access

### Compile

```bash
javac TetranacciCalculator1.java
javac TetranacciCalculator2.java

### Run

java TetranacciCalculator1
# OR
java TetranacciCalculator2

### Example Output

Enter a non-negative integer n (or type 'exit' to quit): 10
Tetranacci(10) = 105
Execution time: 0.0000123 seconds
