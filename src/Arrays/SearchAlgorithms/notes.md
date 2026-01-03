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

## Binary Search ⚡ (to be added later)

(Placeholder for when you cover Binary Search in detail — iterative and recursive approaches, prerequisites like sorted arrays, and complexity analysis.)

## Quick Revision Cheatsheet 📝

- **Linear Search:** Sequential check → Best O(1), Worst O(n).

- **2D Search:** Traverse rows & columns → Return `[row, col]` or `[-1, -1]`.

- **Binary Search:** Works only on sorted arrays → Best O(1), Worst O(log n).