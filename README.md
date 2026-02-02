# Custom List Framework in Java

 📖 Overview
This project presents a custom implementation of a List framework in Java, designed to closely resemble the behavior and structure of Java’s Collection Framework. The assignment focuses on understanding and applying key object-oriented programming concepts such as interfaces, generics, dynamic memory handling, exception handling, and data structure design.

The framework includes two generic list implementations:
- An array-based list
- A singly linked list-based list

Both implementations follow a common contract defined by a custom generic interface.



 🎯 Objectives
The primary objectives of this project are to:
- Understand and implement Java interfaces
- Apply generics (`<T>`) for reusable data structures
- Differentiate between array-based and linked-list-based implementations
- Handle invalid operations using unchecked exceptions
- Design a framework similar to Java’s Collection Framework
- Use wildcards to access multiple implementations polymorphically


 🛠️ Components Description

1️⃣ MyList<T> Interface
A generic interface that defines the contract for all list implementations.

**Declared Methods:**
- `void add(T element)`
- `void insert(T element, int index)`
- `T get(int index)`
- `void delete(int index)`
- `int size()`
- `boolean isEmpty()`



 2️⃣ MyArrayList<T>
An array-based generic list implementation.

**Key Features:**
- Uses an internal `Object[]` array
- Initial capacity is small and grows dynamically
- Capacity doubles when the array becomes full
- Maintains insertion order
- Supports indexed access, insertion, and deletion

**Internal Variables:**
- `Object[] data`
- `int size`
- `int capacity`


3️⃣ MyLinkedList<T>
A singly linked list-based generic implementation.

**Key Features:**
- Uses a private inner `Node<T>` class
- Maintains a reference to the head node
- Supports sequential access
- Efficient insertions and deletions without resizing

**Node Structure:**
```java
class Node<T> {
    T data;
    Node<T> next;
}
This project demonstrates a clean and modular design of a custom List framework using core Java concepts. It highlights the differences between array-based and linked-list-based implementations while reinforcing the importance of generics, exception handling, and interface-driven development
