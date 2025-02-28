Amazon.sa Order Management System

for the java code:
## Key Features
1. **Inheritance**:
    - `Electronics` and `Clothing` classes extend the `Product` class.
  
2. **Polymorphism**:
   - The `calculateDiscount()` method is overridden in `Electronics` and `Clothing` to provide different discount calculations.
  
3. **Exception Handling**:
   - Custom exception `OutOfStockException` is used to handle insufficient stock scenarios.
  
4. **Collections**:
   - `ArrayList` is used to store products and orders.
   - `HashMap` is used to store user order history.
  
5. **CLI Menu**:
   - A simple command-line interface allows users to place orders and view order history.
  
## How to Run
1. Clone the repository.
2. Navigate to the project directory.
3. Compile and run the `Main.java` file:
   ```bash
   javac Main.java
   java Main
