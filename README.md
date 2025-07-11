# Order Reconciliation Project

## Overview

This Java project reconciles **client parent orders** with **child (execution) orders** from CSV files.  
It calculates how much of each client order has been filled and outputs a formatted report.

---

## Team Members & Responsibilities

- **Helper:** Cherian Abraham
  - Set up stub classes, repository structure, integration

- **CSV Tester:** Maryam Ali || Muhammad Waqas
  - Implements `OrderReader` methods to read CSV files and parse into objects

- **Output Formatter:** Maryam Ali || Muhammad Waqas
  - Works on `ReportGenerator` to print formatted order lines

- **Matching Logic Developer:** Changrong Yin || Cherian Abraham
  - Implements `OrderReconciler` to match child orders to client orders and calculate fills

---

## Classes

- `ClientOrder`: Represents a client parent order
- `ChildOrder`: Represents a child (execution) order
- `OrderReader`: Reads CSV files into Java objects
- `OrderReconciler`: Matches child orders to client orders and updates filled quantities
- `ReportGenerator`: Prints formatted reports (and optionally exports to CSV)
- `Main`: Runs the full program

---

## Setup

1. Clone this repository:
    ```
    git clone https://github.com/yourusername/OrderReconciliationProject.git
    ```
2. Import as an **existing Java project** in Eclipse:
    - File → Import → Git → Projects from Git → Clone URI
3. Each team member can work on their assigned file.

---

## Running

- Compile and run `Main.java`
- Console will display example report output (final logic will be integrated step by step)

---

## Status

✅ Stub classes completed  
✅ CSV reading and parsing in progress  
✅ Reconciliation logic in progress  
✅ Final integration and formatting pending

   Implement MultiThreading
   
   Implement Log Errors
   
   Implement Design Patterns

---

## Contact

Feel free to reach out in the group chat or open an issue on GitHub for questions!
