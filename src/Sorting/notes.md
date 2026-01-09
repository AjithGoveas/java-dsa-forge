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

## Some Extra Sorting Techniques

### 🟢 Cyclic Sort

**Idea:** Place each element directly at its correct index (`value → index = value - 1`) by swapping until all elements are in their right positions.<br/>
**Mantra:** *Put every number where it belongs.*

**Algorithm:**
1. Start with the first element.
2. Check if the element is at its correct position (`arr[i] == i + 1`).
3. If not, swap it with the element at its target position (`arr[i] - 1`).
4. If yes, move to the next index.
5. Repeat until all elements are placed correctly.

**Notes:**
- Works only when elements are in the range `1…N` (where `N` is the size of the array).
- Each number is placed at index `value - 1`.
- Very efficient for problems involving **missing numbers, duplicates, or placing numbers in order**.
- Not suitable for general sorting with arbitrary values or negatives.

**Complexity:**
- Time: **O(n)** (each element is swapped at most once).
- Space: **O(1)** (in‑place sorting).
- Stable: ❌ (relative order of equal elements is not preserved).

[Refer Code](CyclicSort.java)

---

### 🟢 Counting Sort

**Idea:** Sort elements by counting their frequency and reconstructing the array based on counts. <br/>
**Mantra:** *Count frequencies, then place elements.*

**Algorithm:**
1. Find the largest element in the array (to size the frequency array).
2. Initialize a frequency array of size `largest + 1`.
3. Count occurrences of each element.
4. Build a prefix sum (cumulative frequency) for stability.
5. Place elements into an output array using their cumulative counts.
6. Copy the output array back to the original array.

**Notes:**
- Non‑comparison based sorting algorithm.
- Works best when the range of numbers (`k`) is not significantly larger than the number of elements (`n`).
- Stable version is important when used as a subroutine in **Radix Sort**.
- Handles duplicates naturally by frequency counting.
- Not suitable for negative numbers unless offsetting is applied.

**Complexity:**
- Time: **O(n + k)** (where `n` = number of elements, `k` = range of input values).
- Space: **O(n + k)** (output + frequency array).
- Stable: Yes (when prefix sums and backward iteration are used).

[Refer Code](CountSort.java)

---

### 🟢 Radix Sort

**Idea:**  
Sort numbers digit by digit, starting from the least significant digit (LSD) or most significant digit (MSD), using a **stable sorting algorithm** (commonly Counting Sort) at each step. <br/>
**Mantra:** *Sort by digits, preserve order.*

**Algorithm (LSD Radix Sort):**
1. Find the maximum number to determine the number of digits.
2. For each digit position (ones, tens, hundreds, …):
    - Use a stable sort (Counting Sort) to sort elements based on that digit.
    - Stability ensures earlier digit order is preserved.
3. After processing all digit positions, the array is fully sorted.

**Pseudocode (conceptual):**
```
radixSort(arr) {
    max = getMax(arr);
    for (int exp = 1; max / exp > 0; exp *= 10) {
        countingSortByDigit(arr, exp); // stable sort by current digit
    }
}
```

**Notes:**

- Radix Sort is **non‑comparison based**. 
- Works best when numbers have a limited number of digits (e.g., integers, strings of fixed length). 
- Relies on **stable sorting** (like Counting Sort) for correctness.
- Can be implemented as LSD (the least significant digit first, most common) or MSD (most significant digit first).
- Often used in scenarios like sorting phone numbers, IDs, or strings with fixed length.

**Complexity:**

- Time: **O(n · k)**, where `n` = number of elements, `k` = number of digits.
- Space: **O(n + k)** (due to Counting Sort).
- Stable: ✅ Yes (when stable sort is used).

---