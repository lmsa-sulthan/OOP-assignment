# Java Shape Inheritance Project

This repository contains a Java project demonstrating core Object-Oriented Programming (OOP) concepts, specifically inheritance, method overriding, and class hierarchies using geometric shapes.

## Project Structure

The codebase is structured around a parent class and multiple subclasses that extend its functionality:

*   **`Bentuk.java`**: The base class (`Bentuk`) that establishes a `warna` (color) attribute and a base `printInfo()` method.
*   **`BujurSangkar.java`**: A subclass of `Bentuk` representing a square (`BujurSangkar`). It introduces a `sisi` (side) attribute and includes a method to calculate the area (`hitungLuas`).
*   **`Lingkaran.java`**: A subclass of `Bentuk` representing a circle (`Lingkaran`). It adds a `radius` attribute, utilizes a constant for `PHI`, and calculates the circle's area.
*   **`Silinder.java`**: A subclass that directly extends `Lingkaran` to form a 3D cylinder (`Silinder`). It adds a `tinggi` (height) attribute and calculates the volume (`hitungVolume`) by multiplying the parent circle's area by the height.
*   **`MainBentuk.java`**: The main driver class (`MainBentuk`). It instantiates objects of all four classes with specific parameters and triggers their respective `printInfo()` methods to display the results.

## Dependencies and Libraries

This project relies exclusively on standard Java SE. There are no additional standard libraries or third-party dependencies required to execute the code.

## How to Compile and Run

Ensure you have the Java Development Kit (JDK) installed. You can run the following bash commands in your terminal to compile and execute the program.

### 1. Compile the Code

Compile all `.java` files simultaneously using `javac`:

```bash
javac Bentuk.java BujurSangkar.java Lingkaran.java Silinder.java MainBentuk.java
```

### 2. Run the Application

Execute the main class to see the output. *(Note: Even though the file is named `Main.java`, the class inside is named `Main`, so you must use that name to run it)*:

```bash
java MainBentuk
```
