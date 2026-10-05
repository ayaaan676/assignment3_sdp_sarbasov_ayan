# Assignment 3 — Bridge Pattern

## Student Information

**Student:** Ayan Sarbasov
**Group:** SE2538
**Assignment:** Assignment 3 — Bridge Pattern
**Language:** Java

## 1. Project Overview

This project demonstrates the **Bridge Design Pattern** in Java.

The main idea of the Bridge Pattern is to separate an abstraction from its implementation. This allows both parts to be changed independently.

In this project:

* `Shape` is the abstraction.
* `Circle` and `Square` are concrete shapes.
* `Renderer` is the implementation interface.
* `VectorRenderer`, `RasterRenderer`, and `AsciiRenderer` are different implementations.

This structure allows the same shape to work with different rendering implementations.

For example, a `Circle` can use `VectorRenderer`, `RasterRenderer`, or `AsciiRenderer` without changing the `Circle` class.

---

## 2. Bridge Pattern Structure

The project contains two independent dimensions:

### Abstraction

```text
Shape
├── Circle
└── Square
```

### Implementation

```text
Renderer
├── VectorRenderer
├── RasterRenderer
└── AsciiRenderer
```

The `Shape` class contains a reference to the `Renderer` interface.

This creates the bridge between the abstraction and the implementation.

---

## 3. Project Structure

```text
Assignment3_Bridge/
│
├── src/
│   ├── Shape.java
│   ├── Circle.java
│   ├── Square.java
│   ├── Renderer.java
│   ├── VectorRenderer.java
│   ├── RasterRenderer.java
│   ├── AsciiRenderer.java
│   └── Main.java
│
├── extension.diff
├── .gitignore
└── README.md
```

### Main Classes

| Class            | Description                      |
| ---------------- | -------------------------------- |
| `Shape`          | Base abstraction for shapes      |
| `Circle`         | Concrete circle implementation   |
| `Square`         | Concrete square implementation   |
| `Renderer`       | Renderer interface               |
| `VectorRenderer` | Vector rendering implementation  |
| `RasterRenderer` | Raster rendering implementation  |
| `AsciiRenderer`  | ASCII rendering implementation   |
| `Main`           | Runs the demonstration and tests |

---

## 4. How the Bridge Pattern Works

The `Shape` class does not directly depend on a specific renderer.

Instead, it uses the `Renderer` interface.

For example:

```java
Renderer vector = new VectorRenderer();
Circle circle = new Circle(1, 2, vector);
```

The same circle can later use another renderer:

```java
circle.setImplementation(raster);
```

The `Circle` object remains the same, but its rendering implementation changes.

This demonstrates that the abstraction and implementation can vary independently.

---

## 5. Renderers

### VectorRenderer

Produces vector-style output:

```text
VECTOR circle radius=2
VECTOR square side=3
```

### RasterRenderer

Produces raster-style output:

```text
RASTER circle radius=2
RASTER square side=3
```

### AsciiRenderer

The third implementation added during the extension part:

```text
ASCII circle radius=2
ASCII square side=3
```

Adding `AsciiRenderer` does not require changing the existing shape classes.

---

## 6. Test Cases

The program contains seven test cases.

| Test | Description                                        | Expected Result |
| ---- | -------------------------------------------------- | --------------- |
| T1   | Circle + VectorRenderer                            | PASS            |
| T2   | Circle + RasterRenderer                            | PASS            |
| T3   | Square + VectorRenderer                            | PASS            |
| T4   | Square + RasterRenderer                            | PASS            |
| T5   | Change renderer without replacing the shape object | PASS            |
| T6   | Circle + AsciiRenderer                             | PASS            |
| T7   | Square + AsciiRenderer                             | PASS            |

The final result is:

```text
SUMMARY: 7/7 PASS
```

---

## 7. T5 — Runtime Implementation Switching

T5 demonstrates one of the main advantages of the Bridge Pattern.

The same `Circle` object first uses `VectorRenderer`:

```text
before=VECTOR circle radius=2
```

Then its renderer is changed to `RasterRenderer`:

```text
after=RASTER circle radius=2
```

The test also checks that the object reference and its state remain unchanged.

Expected output:

```text
T5 PASS | sameObject=true | stateUnchanged=true
    before=VECTOR circle radius=2 | after=RASTER circle radius=2
```

This shows that the implementation can be changed at runtime without creating a new shape object.

---

## 8. How to Run

### Requirements

* Java JDK 17 or higher
* IntelliJ IDEA or another Java IDE
* Git

### Run from IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Open `src/Main.java`.
3. Run the `Main` class.
4. Use the program argument:

```text
--demo
```

The program will execute all seven tests.

### Expected Output

```text
T1 PASS | Circle + VectorRenderer | result=VECTOR circle radius=2
T2 PASS | Circle + RasterRenderer | result=RASTER circle radius=2
T3 PASS | Square + VectorRenderer | result=VECTOR square side=3
T4 PASS | Square + RasterRenderer | result=RASTER square side=3
T5 PASS | sameObject=true | stateUnchanged=true
    before=VECTOR circle radius=2 | after=RASTER circle radius=2
T6 PASS | Circle + AsciiRenderer | result=ASCII circle radius=2
T7 PASS | Square + AsciiRenderer | result=ASCII square side=3
SUMMARY: 7/7 PASS
```

---

## 9. Git Commit History

The project was developed incrementally using Git.

### Base Commit

```text
f72c53c Implement Bridge pattern with vector and raster renderers
```

This commit contains the initial Bridge Pattern implementation with:

* `Shape`
* `Circle`
* `Square`
* `Renderer`
* `VectorRenderer`
* `RasterRenderer`
* Tests T1–T5

### Extension Commit

```text
663ad7f Add AsciiRenderer and T6-T7 tests
```

This commit adds:

* `AsciiRenderer`
* T6
* T7

### Diff Commit

```text
1697f3b Add Bridge pattern extension diff
```

This commit contains:

```text
extension.diff
```

The diff shows the changes between the base implementation and the extended implementation.

---

## 10. Extension Diff

The file `extension.diff` documents the extension from the original implementation to the final implementation.

The main changes are:

```text
+ AsciiRenderer
+ T6
+ T7
```

The extension demonstrates that a new renderer can be added without changing the existing abstraction hierarchy.

---

## 11. Advantages of the Bridge Pattern

The Bridge Pattern provides several advantages:

1. **Separation of abstraction and implementation**
   Shapes and renderers are separated.

2. **Easy extension**
   New shapes or renderers can be added independently.

3. **Runtime flexibility**
   The renderer can be changed while the same shape object is used.

4. **Less duplicated code**
   Different combinations do not require separate classes.

5. **Better maintainability**
   Changes in rendering implementations do not require changing the shape classes.

---

## 12. Technologies Used

* Java
* Object-Oriented Programming
* Bridge Design Pattern
* IntelliJ IDEA
* Git
* GitHub

---

## 13. Repository

GitHub repository:

https://github.com/ayaaan676/assignment3_sdp_sarbasov_ayan

---

## 14. Conclusion

This assignment demonstrates how the Bridge Design Pattern can separate an abstraction from its implementation.

The project supports three different renderers:

* Vector
* Raster
* ASCII

The final implementation passes all seven tests:

```text
SUMMARY: 7/7 PASS
```

The project also demonstrates runtime switching between implementations and shows how a new renderer can be added without modifying the existing shape hierarchy..
