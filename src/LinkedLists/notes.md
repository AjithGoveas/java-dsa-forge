# 🔗 Linked Lists in Java

## 📌 Limitations of Arrays and ArrayLists
- **Arrays**: Fixed size → must know the size beforehand.
- **ArrayLists**: Dynamic resizing but costly → resizing takes **O(n)** in worst case (though average insertion is O(1)).


## 📌 Why Linked Lists?
- Built using **nodes** and **links**.
- **Dynamic memory allocation** (heap-based).
- Efficient for frequent insertions/deletions compared to arrays.


## 📌 Advantages of Linked Lists
1. **Dynamic Size** → No need to predefine size.
2. **Easy Insertion/Deletion** → O(1) at head/tail if pointer known.
3. **Efficient Traversal** → Can move forward/backward (in doubly lists).
4. **Memory Utilization** → Allocated on heap dynamically.
5. **Flexibility** → Circular lists allow continuous traversal (useful in scheduling).



## 📌 Structure of a Linked List
```java
class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}
```


## 📌 Types of Linked Lists

### 1️⃣ Singly Linked List
- Each node points to the **next node**.
- Last node points to `null`.

#### Operations
- **Insertion at Head**
```java
void insertAtHead(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
}
```

- **Deletion at Head**
```java
void deleteHead() {
    if (head != null) head = head.next;
}
```

- **Traversal**
```java
void printList() {
    Node temp = head;
    while (temp != null) {
        System.out.print(temp.data + " -> ");
        temp = temp.next;
    }
    System.out.println("null");
}
```

#### 🔎 JVM Background
- Each `Node` object is created on the **heap** using `new`.
- The `head` reference lives on the **stack** (inside method frames) but points to heap memory.
- Garbage Collector (GC) automatically reclaims memory when nodes are no longer referenced.


### 2️⃣ Doubly Linked List
- Each node has **two pointers**:
    - `next` → next node
    - `prev` → previous node

#### Structure
```java
class DNode {
    int data;
    DNode prev, next;
    DNode(int d) { data = d; }
}
```

#### Operations
- **Insertion at Head**
```java
void insertAtHead(int data) {
    DNode newNode = new DNode(data);
    newNode.next = head;
    if (head != null) head.prev = newNode;
    head = newNode;
}
```

- **Deletion at Tail**
```java
void deleteTail() {
    if (head == null) return;
    DNode temp = head;
    while (temp.next != null) temp = temp.next;
    if (temp.prev != null) temp.prev.next = null;
    else head = null;
}
```

- **Traversal Forward**
```java
void printForward() {
    DNode temp = head;
    while (temp != null) {
        System.out.print(temp.data + " <-> ");
        temp = temp.next;
    }
    System.out.println("null");
}
```

- **Traversal Backward**
```java
void printBackward(DNode tail) {
    DNode temp = tail;
    while (temp != null) {
        System.out.print(temp.data + " <-> ");
        temp = temp.prev;
    }
    System.out.println("null");
}
```

#### 🔎 JVM Background
- Each `DNode` object is allocated on the **heap**.
- `prev` and `next` references are **object references** (pointers managed by JVM).
- JVM ensures type safety: you cannot accidentally point to non‑`DNode` objects.
- GC cleans up unreachable nodes automatically.


### 3️⃣ Circular Linked List
- Last node points back to the **head**.
- Can be **singly** or **doubly** circular.

#### Structure
```java
class CNode {
    int data;
    CNode next;
    CNode(int d) { data = d; }
}
```

#### Operations
- **Insertion at End**
```java
void insert(int data) {
    CNode newNode = new CNode(data);
    if (head == null) {
        head = newNode;
        head.next = head; // circular link
    } else {
        CNode temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }
}
```

- **Deletion at Head**
```java
void deleteHead() {
    if (head == null) return;
    if (head.next == head) { head = null; return; }
    CNode temp = head;
    while (temp.next != head) temp = temp.next;
    temp.next = head.next;
    head = head.next;
}
```

- **Traversal**
```java
void printList() {
    if (head == null) return;
    CNode temp = head;
    do {
        System.out.print(temp.data + " -> ");
        temp = temp.next;
    } while (temp != head);
    System.out.println("(back to head)");
}
```

#### 🔎 JVM Background
- Circular references are **safe in Java** because GC uses reachability analysis, not reference counting.
- Even if nodes point to each other, if no external reference exists (like `head`), the entire cycle is garbage collected.
- This makes circular lists memory‑safe compared to languages without GC.


## 📌 Time Complexity Analysis

| Operation         | Singly LL          | Doubly LL | Circular LL |
|-------------------|--------------------|-----------|-------------|
| Insert at Head    | O(1)               | O(1)      | O(1)        |
| Insert at Tail    | O(n) (no tail ptr) | O(n)      | O(n)        |
| Delete at Head    | O(1)               | O(1)      | O(1)        |
| Delete at Tail    | O(n)               | O(n)      | O(n)        |
| Search (by value) | O(n)               | O(n)      | O(n)        |
| Traversal         | O(n)               | O(n)      | O(n)        |


## 📌 Summary Table

| Type                 | Structure          | Advantages                      | JVM/Java Background             | Example Use            |
|----------------------|--------------------|---------------------------------|---------------------------------|------------------------|
| Singly Linked List   | Node → Next        | Easy insertion/deletion at head | Nodes on heap, GC cleans unused | Basic dynamic lists    |
| Doubly Linked List   | Node → Prev & Next | Easy traversal both directions  | References managed by JVM       | Undo operations        |
| Circular Linked List | Last → Head        | Continuous traversal            | GC handles cycles safely        | Round-robin scheduling |