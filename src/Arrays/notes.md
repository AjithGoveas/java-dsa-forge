# Arrays 📚

---

## Why are Arrays Used? 🤔

Suppose we want to store roll numbers of students.  
For a small number (like 2 or 3 students), we can simply use separate variables. But imagine a large database of 500 students—initializing that many variables individually is impractical.

👉 Arrays solve this problem by letting us store multiple values of the same type in a single structure.

**Definition (C++ perspective):**  
Arrays are continuous blocks of memory that hold elements of a specific type.

---

## Syntax and Examples 🖊️

**General Syntax:**

```java
datatype[] variableName = new datatype[size];
```

**Examples:**
```java
// Array of 10 student roll numbers
int[] rollNumbers = new int[10];

// Array of 10 student names
String[] studentNames = new String[10];

// Direct initialization
int[] nums = {1, 2, 3, 4, 5};
```

👉 On the left-hand side (LHS), we declare the array.
👉 On the right-hand side (RHS), we initialize it.

---

## Important Notes 📌

* Declaration happens at compile time.

* Initialization happens at runtime.

* The actual array is stored in heap memory, while the reference (variable name) lives in stack memory.

* Arrays in Java are objects in the heap. Heap objects are not always continuous—continuity depends on the JVM implementation.

* [Refer to Java specification docs] for deeper details.

---

## Key Features of Arrays 🌟
* **Store Primitives and Objects:** Arrays can hold primitive types (`int`, `char`, `boolean`, etc.) as well as objects (`String`, `Integer`, etc.).

* **Contiguous Memory Allocation:** For primitive arrays, elements are stored in contiguous memory locations. For object arrays, references are stored contiguously.

* **Zero-based Indexing:** The first element is always at index `0`.

* **Fixed Length:** Once created, the size of an array cannot be changed.

---

## Array Representation 🖼️

![Primitive Arrays](https://media.geeksforgeeks.org/wp-content/uploads/20250924125731518155/primitive_array_.webp)

![Non-primitive Arrays](https://media.geeksforgeeks.org/wp-content/uploads/20250924125824403726/object_array_.webp)

---

## Default Values in Arrays 🎯

When an array is initialized, its elements are automatically set to default values depending on the datatype:
* `int` → `0`
* `String` → `null`
* `float` → `0.0`
* `boolean` → `false`
* and so on…

---

## Array Input/Output (I/O) ⌨️
* Use for loops for basic array input and output.

* For convenience, Java provides utility methods in the java.util.Arrays package.

[Refer code](InputOutput.java)

---

## Multidimensional Arrays 🔢
Arrays can have more than one dimension.

A 2D array is the most common, with parameters for rows and columns.

![2D Array in Java](https://scaler.com/topics/images/jvm-implementation-of-2d-arrays.webp)

### 2D Array Example

**Syntax:**

```java
datatype[][] varName = new datatype[rowSize][colSize];
```

* While initializing, `rowSize` is mandatory.

* `colSize` is optional—JVM only needs to know how many internal arrays (rows) to allocate.

* Each row can have a different number of columns (jagged arrays).

* The `.length` property on a 2D array returns the number of rows.

---

## Common Mistakes and Tips ⚠️

- **Forgetting Zero-based Indexing:** Remember, the first element is at index 0, not 1. 

- **Confusing Declaration vs Initialization:** Declaring an array does not allocate memory for its elements; initialization does. 

- **Accessing Out-of-Bounds Index:** Trying to access an index outside the array size will throw ArrayIndexOutOfBoundsException. 

- **Assuming Arrays are Always Continuous:** In Java, primitive arrays are contiguous, but object arrays store references contiguously (actual objects may be scattered in heap). 

- **Mixing Up** `.length` __vs__ `.length()`**:**
  - Arrays use `.length` (no parentheses). 
  - Strings use `.length()` (with parentheses). 

- **Immutable Size:** Once created, the size of an array cannot be changed. Use `ArrayList` if you need dynamic resizing.

---

## Quick Revision Cheatsheet 📝

* **Syntax:** `datatype[] arr = new datatype[size];`

* **Indexing:** Starts at `0`

* **Default Values:** `int → 0`, `String → null`, `float → 0.0`, `boolean → false` 

* **Fixed Size:** Cannot be changed after creation 

* **2D Arrays:** `datatype[][] arr = new datatype[rows][cols];`

* **I/O:** Use `for` loops or `java.util.Arrays` utilities 

* **Heap vs Stack:** Array object in heap, reference in stack

---