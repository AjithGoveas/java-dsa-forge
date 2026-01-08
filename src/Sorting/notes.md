# 🔧 Sorting Techniques

Sorting is the process of arranging elements in a particular order (ascending or descending).  
There are two phases of sorting:

- **Phase 1:** Selection Sort, Bubble Sort, Insertion Sort
- **Phase 2:** Merge Sort, Recursive Bubble Sort, Recursive Insertion Sort, Quick Sort

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
- Reason: Comparisons reduce each pass (`n + (n-1) + (n-2) + ... + 1 ` ≈ n<sup>2</sup>).

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

---

✅ These two algorithms are **easy to understand** and form the foundation for more advanced sorting techniques.
- **Selection Sort:** Good for learning, but rarely used in practice.
- **Bubble Sort:** Simple, but inefficient; mainly useful for teaching algorithm concepts.
