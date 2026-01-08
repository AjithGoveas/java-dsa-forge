# 🔧 Sorting Techniques

Sorting is the process of arranging elements in a particular order (ascending or descending).  
There are two phases of sorting:

- **Phase 1:** Selection Sort, Bubble Sort, Insertion Sort
- **Phase 2:** Merge Sort, Recursive Bubble Sort, Recursive Insertion Sort, Quick Sort

---

## 📘 Phase 1

### 🟢 Selection Sort

**Idea:** Select the minimum element and place it at the correct position.  
**Mantra:** *Select the minimum and swap.*

**Algorithm:**
1. Find the minimum element in the unsorted part of the array.
2. Swap it with the first element of the unsorted part.
3. Repeat until the entire array is sorted.

**Notes:**
- Runs for `n-1` passes if array length is `n`.
- Simple but inefficient for large datasets.

**Complexity:**
- Best, Worst, Average: **O(n<sup>2</sup>)**
- Reason: Comparisons reduce each pass (`n + (n-1) + (n-2) + ... + 1` ≈ n<sup>2</sup>).
- Space: **O(1)** (in‑place sorting).

[Refer Code](SelectionSort.java)

---

### 🟢 Bubble Sort

**Idea:** Repeatedly swap adjacent elements to "bubble" the largest element to the end.  
**Mantra:** *Push the maximum to the right.*

**Algorithm:**
1. Compare adjacent elements and swap if out of order.
2. After each pass, the largest element settles at the end.
3. Repeat until no swaps are needed.

**Optimization:**
- Use a `swapped` flag. If no swaps occur in a pass, the array is already sorted → stop early.

**Complexity:**
- Worst / Average: **O(n<sup>2</sup>)**
- Best: **O(n)** (when array is already sorted, due to early termination check).
- Space: **O(1)** (in‑place sorting).

[Refer Code](BubbleSort.java)

---

### 🟢 Insertion Sort

**Idea:** Build the sorted array one element at a time by inserting each element into its correct position.  
**Mantra:** *Pick an element and place it where it belongs.*

**Algorithm:**
1. Start from the second element (index 1), treating the first element as a sorted subarray.
2. Compare the current element with elements in the sorted subarray (moving leftwards).
3. Shift larger elements one position to the right to make space.
4. Insert the current element into its correct position.
5. Repeat until all elements are placed correctly.

**Notes:**
- Works well for small datasets or nearly sorted arrays.
- Stable sort (preserves the relative order of equal elements).
- In‑place algorithm (requires no extra space).

**Complexity:**
- Worst / Average: **O(n<sup>2</sup>)** (each insertion may require shifting many elements).
- Best: **O(n)** (when the array is already sorted — only one comparison per element).
- Space: **O(1)** (in‑place sorting).

[Refer Code](InsertionSort.java)

---

✅ These algorithms are **easy to understand** and form the foundation for more advanced sorting techniques.
- **Selection Sort:** Good for learning, but rarely used in practice.
- **Bubble Sort:** Simple, but inefficient; mainly useful for teaching algorithm concepts.
- **Insertion Sort:** Efficient for small or nearly sorted datasets, stable, and widely used in practice for such cases.
