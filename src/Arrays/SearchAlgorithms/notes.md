# Search Algorithms 🔎

Search algorithms are used to determine whether a given element exists in an array (or collection).
They provide systematic ways to locate data efficiently depending on the structure of the array.

There are two primary search techniques:

1. **Linear Search** 
2. **Binary Search**

## Linear Search 📍

- This algorithm checks elements sequentially in a linear format. 
- We use a pointer (index) and compare the target element with each array element one by one. 
- If the element is found, we return either:
  - `true` (boolean result), or 
  - the **index value** of the element.
- If the element is not found, we return `false` or `-1`.

**Time Complexity:**

- **Best Case: O(1)** (Constant) → When the element is found at the first comparison. 
- **Worst Case: O(n)** (Linear) → When the search traverses the entire array.

[Refer Code](LinerSearch.java)

## Search in 2D Array 🔢

- Traverse through all elements of the 2D array row by row and column by column. 
- If the target element is found, return a pair `[row, column]`. 
- If the element is not found, return `[-1, -1]`.

[Refer Code](Search2DArray.java)

## Binary Search ⚡

- Works on the **Divide and Conquer** principle. 
- Requires the array to be **sorted** (ascending or descending).

**Algorithm Steps:**

1. Find the middle element using low and high pointers. 
2. Compare the middle element with the target:
   1. If equal → return index. 
   2. If target < middle → search the **left half**. 
   3. If target > middle → search the **right half**.
3. Repeat until the target is found or the search space becomes empty.

**Important Notes:**

- Always calculate `mid` as: <br/> `mid = low + (high - low) / 2` <br/>
This avoids integer overflow compared to `(low + high) / 2`.
- Algorithm stops when `low > high`.
- If the sort order is unknown, use **Order-Agnostic Binary Search**:
  - First check whether the array is sorted ascending or descending.
  - Then apply binary search accordingly.

**Time Complexity:**

- **Best Case: O(1)** → Element found at the first comparison.
- **Worst Case: O(log n)** → Search space halves at each step.

[Refer Code](BinarySearch.java)

## Quick Revision Cheatsheet 📝

- **Linear Search:** Sequential check → Best O(1), Worst O(n).

- **2D Search:** Traverse rows & columns → Return `[row, col]` or `[-1, -1]`.

- **Binary Search:** Works only on sorted arrays → Best O(1), Worst O(log n).