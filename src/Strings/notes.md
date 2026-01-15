# 🔤 Strings

A **String** in Java is an **immutable datatype** — once created, its value cannot be changed.  
It represents a **collection of characters**.

## 📘 String Creation

```datatype ref_variable = object```

Example:
```java
String a = "Ajith";
String b = "Ajith";
```

### Concepts:

- **String Pool:**
  - A special memory area inside the heap.
  - Identical string literals are stored only once in the pool.
  - In the example above, both `a` and `b` point to the same `"Ajith"` object in the pool.

- **Immutability:**
  - Strings cannot be modified once created.
  - Any change creates a new String object.
  - Example: `a = a + "X";` → creates a new object `"AjithX"`.

- **Using new:**
  - To force creation of a new object (even with the same value), use:
    ```java
    String c = new String("Ajith");
    ```

## 📘 String Comparison

- `==` → compares **references** (memory addresses).
- `.equals()` → compares **values** (actual string content).

## 📘 String Operations

- `'a' + 'b'` → `195` (adds ASCII values: 97 + 98).
- `"a" + "b"` → `"ab"` (concatenation).
- `(char)('a' + 3)` → `'d'`.
- `"a" + 1` → `"a1"` (string concatenation with integer).

## 📘 String Performance

- Every concatenation creates a **new object**.
- For `N` concatenations → `1 + 2 + 3 + … + N` ≈ O(N<sup>2</sup>).
- Inefficient for repeated modifications.

## 📘 StringBuilder

- **Mutable strings** — can be modified without creating new objects.
- Keeps the same reference and updates the value directly.
- Useful for heavy string manipulations (loops, concatenations).

**Performance:**
- Append/insert operations → **O(1)** amortized.
- Overall efficiency → **O(N)** for `N` operations (much faster than `String`).

## 📘 StringBuffer

- Similar to **StringBuilder**, but **thread‑safe**.
- All methods are synchronized, making it safe for use in **multi‑threaded environments**.
- Slightly slower than `StringBuilder` due to synchronization overhead.

**Performance:**

- Append/insert operations → **O(1)** amortized.
- Overall efficiency → **O(N)**, but slower than `StringBuilder`.
- **Thread‑safe** (preferred when multiple threads share the same string object).

## ✅ Summary:

- **String:** Immutable, stored in String Pool, costly for repeated changes.
- **StringBuilder:** Mutable, fast, efficient for single‑threaded operations.
- **StringBuffer:** Mutable, synchronized, safe for multi‑threaded operations but slower than `StringBuilder`.