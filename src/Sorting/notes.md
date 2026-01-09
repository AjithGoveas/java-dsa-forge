# 🔧 Sorting Techniques

Sorting is the process of arranging elements in a particular order (ascending or descending).  
There are two phases of sorting:

- **Phase 1:** Selection Sort, Bubble Sort, Insertion Sort
- **Phase 2:** Merge Sort, Recursive Bubble Sort, Recursive Insertion Sort, Quick Sort

---

## 📘 Phase 1

### 🟢 Selection Sort

**Idea:** Select the minimum element and place it at the correct position.<br/>
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

**Idea:** Repeatedly swap adjacent elements to "bubble" the largest element to the end.<br/>
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

**Idea:** Build the sorted array one element at a time by inserting each element into its correct position.<br/>
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

## 📘 Phase 2: Advanced Sorting Techniques

These techniques improve efficiency compared to the basic sorts in Phase 1.
They use recursion and divide‑and‑conquer strategies to achieve better performance.

### 🟢 Merge Sort

**Idea:** Divide the array into halves, sort each half recursively, and then merge them.<br/>
**Mantra:** *Divide and Merge.*

**Algorithm:**

1. Divide the array into two halves until each subarray has one element.
2. Recursively sort the left half and the right
   half.
3. Merge the two sorted halves into a single sorted array.

**Notes:**

- Merge Sort is a **divide and conquer** algorithm.
- Always divides into halves, regardless of input order.
- Stable sort (preserves relative order of equal elements).
- Requires extra space for merging.

**Complexity:**

- Best, Worst, Average: **O(n log n)**
- Space: **O(n)** (due to temporary arrays during merging).

[Refer Code](MergeSort.java)

---

### 🟢 Quick Sort

**Idea:** Partition the array around a pivot, then recursively sort the partitions.<br/>
**Mantra:** *Partition and Conquer.*

**Algorithm:**

1. Choose a pivot element.
2. Partition the array so that elements smaller than pivot are on the left, larger on the right.
3. Recursively apply quick sort to the left and right partitions.
4. Base case: subarray size ≤ 1.

**Notes:**

- Quick Sort is a **divide and conquer** algorithm.
- In‑place sorting (no extra arrays needed).
- Not stable (relative order of equal elements may change).
- Pivot choice affects performance (random pivot or median is better).

**Complexity:**

- Best / Average: **O(n log n)**
- Worst: **O(n<sup>2</sup>)** (when pivot divides poorly, e.g., sorted input with first element as pivot).
- Space: **O(log n)** (recursion stack).

[Refer Code](QuickSort.java)

---

### 🟢 Recursive Bubble Sort

**Idea:** Apply bubble sort logic recursively by reducing the problem size each call. <br/>
**Mantra:** _Bubble with recursion._

**Algorithm:**

1. Perform one pass of bubble sort (push the largest element to the end).
2. Recursively call bubble sort on the remaining unsorted part of the array.
3. Base case: when the array size is 1, it is sorted.

**Complexity:**

- Worst / Average: **O(n<sup>2</sup>)**
- Best: **O(n)** (already sorted, with early termination check).
- Space: **O(1)** (in‑place sorting, recursion stack overhead negligible).

[Refer Code](RecursiveBubbleSort.java)

---

### 🟢 Recursive Insertion Sort

**Idea:** Sort the array recursively by inserting elements into the sorted subarray. <br/>
**Mantra:** _Insert with recursion._

**Algorithm:**

1. Base case: if array size is 1, it is sorted. 
2. Recursively sort the first n-1 elements. 
3. Insert the last element into its correct position in the sorted subarray.

**Complexity:**

- Worst / Average: **O(n<sup>2</sup>)**
- Best: **O(n)** (already sorted). 
- Space: **O(1)** (in‑place sorting, recursion stack overhead negligible).

[Refer Code](RecursiveInsertionSort.java)

---