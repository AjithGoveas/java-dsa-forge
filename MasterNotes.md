# 🧭 Placement Revision Sheet — Pattern Trigger Matrix

> **How revision works here:** Your brain recalls **patterns by triggers**, not problem numbers.
> This file groups every solved problem by its *primary algorithmic pattern*. When you see an
> unseen question in an interview, scan the **Trigger** lines — the pattern with the closest match
> is where you start. Problem IDs link to the solution file, whose own `///` header repeats the
> same Pattern / Trigger / Traps for quick per-file recall.
>
> **Companion file:** [src/LeetCode/PROBLEMS.md](src/LeetCode/PROBLEMS.md) is the flat **code
> registry** (ID → title → topic → optimal approach → link). This file is the **pattern index**.
> They are non-overlapping by design.

---

## 1. Two Pointers (in-place / partition)

* **Triggers:** "remove duplicates from sorted array", "move X to end", "reverse in-place", "in-place operation", "sorted two-sum trio", Dutch-flag "sort 0s/1s/2s"
* **Core Template:** One pointer scans forward; a second "write/slow" pointer marks where to place the kept element. For 3-way partitions (Dutch flag) track `low` and `high`.
* **Linked Problems:**
  * `[L0026]` Remove Duplicates from Sorted Array — O(N) / O(1)
  * `[L0283]` Move Zeroes — O(N) / O(1)

## 2. Running Min/Max Tracking (Greedy single pass)

* **Triggers:** "best time to buy and sell", "max profit", "second largest", "smallest value seen so far"
* **Core Template:** Keep one running variable (`minSeen` / `maxSoFar` / `secondLargest`); update while scanning once.
* **Linked Problems:**
  * `[L0121]` Best Time to Buy and Sell Stock — O(N) / O(1)
  * `[SecondLargest]` Second Largest / Smallest — O(N) / O(1)

## 3. Hash Map / Complement Lookup

* **Triggers:** "two numbers add up to target", "find indices", "frequency count", "isomorphic", "anagram", "one-to-one mapping"
* **Core Template:** Store seen values → index (or build a frequency map / char→char map) in one pass; check for the complement `target - nums[i]` on the fly.
* **Linked Problems:**
  * `[L0001]` Two Sum — O(N) / O(N)
  * `[L0136]` Single Number (XOR, not literally a map — see §12) — O(N) / O(1)
  * `[L0242]` Valid Anagram — O(N) / O(1)
  * `[L0205]` Isomorphic Strings — O(N) / O(1)
  * `[L0451]` Sort Characters by Frequency — O(N) / O(K)

## 4. Binary Search — Classic (sorted 1D array)

* **Triggers:** "search in sorted array", "lower bound", "ceiling", "floor", "insert position", "first/last occurrence", "smallest letter greater than target"
* **Core Template:** `low`/`high`; `mid = low + (high - low)/2` (overflow-safe); move `high = mid-1` or `low = mid+1`; loop while `low <= high`. `Ceiling` = lower_bound; `Floor` = `upper_bound - 1`.
* **Linked Problems:**
  * `[L0704]` Binary Search — O(log N) / O(1)
  * `[L0035]` Search Insert Position — O(log N) / O(1)
  * `[L0034]` First and Last Position — O(log N) / O(1)
  * `[L0744]` Smallest Letter Greater Than Target — O(log N) / O(1)
  * `[CeilingNumber]` Ceiling Number — O(log N) / O(1)
  * `[FloorNumber]` Floor Number — O(log N) / O(1)

## 5. Binary Search — Rotated Sorted Array

* **Triggers:** "sorted array rotated", "search in rotated array", "rotated sorted, duplicates possible"
* **Core Template:** Compare `nums[mid]` with `nums[low]` (or `nums[high]`) to identify which half is sorted; check if target lies in that range. With duplicates (`L0081`), shrink `low++`/`high--` when `nums[mid] == nums[low] == nums[high]`.
* **Linked Problems:**
  * `[L0033]` Search in Rotated Sorted Array — O(log N) / O(1)
  * `[L0081]` Search in Rotated Sorted Array II — O(log N) avg / O(N) worst

## 6. Binary Search — 2D Matrix / Staircase

* **Triggers:** "search a 2D matrix", "every row sorted, first of row >= last of previous", "rows and columns each sorted independently"
* **Core Template:** If each row "continues" (virtual 1D index mapping) do single binary search. If rows *and* columns are sorted independently, use **staircase**: start top-right, move left on smaller, down on larger (O(m+n)).
* **Linked Problems:**
  * `[L0074]` Search a 2D Matrix — O(log(m·n)) / O(1)
  * `[L0240]` Search a 2D Matrix II — O(m+n) / O(1)

## 7. Binary Search — on Answer (feasibility / monotonic search space)

* **Triggers:** "minimize the maximum", "smallest X such that ...", "can finish within K", "ship within D days", "koko eating bananas", "make m bouquets", "kth missing", "infinite sorted array"
* **Core Template:** `low`/`high` bound the *answer*, not the array. Binary search the answer; for each `mid` run a **greedy/feasibility check** (`isPossible(mid)`), then shrink the bound toward the satisfying direction.
* **Linked Problems:**
  * `[L0875]` Koko Eating Bananas — O(N log maxH) / O(1)
  * `[L1011]` Capacity To Ship Within D Days — O(N log Σ) / O(1)
  * `[L1283]` Smallest Divisor Given a Threshold — O(N log max) / O(1)
  * `[L1482]` Minimum Days to Make m Bouquets — O(N log max) / O(1)
  * `[L0410]` Split Array Largest Sum — O(N log Σ) / O(1)
  * `[L1539]` Kth Missing Positive — O(log N) / O(1)
  * `[L1095]` Find in Mountain Array — O(log N) / O(1)
  * `[PositionInInfiniteArray]` Position in Infinite Sorted Array — O(log N) / O(1)

## 8. Binary Search — Peak / Mountain / Median

* **Triggers:** "find peak element (greater than neighbors)", "peak index in mountain", "bitonic array", "median of two sorted arrays"
* **Core Template:** Compare `nums[mid]` to its neighbor to decide which side the peak lies on. For two sorted arrays, binary search the split on the smaller array (`L0004`).
* **Linked Problems:**
  * `[L0162]` Find Peak Element — O(log N) / O(1)
  * `[L0852]` Peak Index in a Mountain Array — O(log N) / O(1)
  * `[L0004]` Median of Two Sorted Arrays — O(log(min(m,n))) / O(1)

## 9. Fast & Slow Pointers (Floyd / Tortoise & Hare)

* **Triggers:** "cycle in linked list", "node where cycle begins", "middle of linked list", "palindrome linked list"
* **Core Template:** `slow` moves 1 step, `fast` moves 2. Cycle detected when they meet. To find cycle entry, reset one pointer to head then advance both 1 step. For middle, when `fast` reaches end, `slow` is the middle.
* **Linked Problems:**
  * `[L0141]` Linked List Cycle — O(N) / O(1)
  * `[L0142]` Linked List Cycle II — O(N) / O(1)
  * `[L0876]` Middle of the Linked List — O(N) / O(1)
  * `[L0234]` Palindrome Linked List — O(N) / O(1)
  * `[L2095]` Delete the Middle Node — O(N) / O(1)

## 10. Linked List — Reversal & Rewiring

* **Triggers:** "reverse linked list", "reverse nodes in k-group", "rotate list", "delete node in O(1) given reference", "odd/even nodes"
* **Core Template:** Iterative `prev/curr/next` reversal; dummy-head sentinel for edge removals; for k-group, reverse k nodes then reconnect to the remaining list.
* **Linked Problems:**
  * `[L0206]` Reverse Linked List — O(N) / O(1)
  * `[L0025]` Reverse Nodes in k-Group — O(N) / O(1)
  * `[L0061]` Rotate List — O(N) / O(1)
  * `[L0237]` Delete Node in a Linked List — O(1) / O(1)
  * `[L0019]` Remove Nth Node From End — O(N) / O(1)
  * `[L0328]` Odd Even Linked List — O(N) / O(1)
  * `[L0138]` Copy List with Random Pointer — O(N) / O(N)

## 11. Kadane's Algorithm / Running Sum (DP reset)

* **Triggers:** "contiguous subarray", "maximum sum", handles mixed positive/negative numbers
* **Core Template:** Running `currentSum`; if it drops below 0 reset to 0; track global `maxSum`. **Traps:** all-negative array → init `maxSum = Integer.MIN_VALUE` (or `nums[0]`), never `0`.
* **Linked Problems:**
  * `[L0053]` Maximum Subarray — O(N) / O(1)

## 12. Bit Manipulation — XOR & Missing Number

* **Triggers:** "every element appears twice except one", "single number", "missing number in 0..n"
* **Core Template:** XOR all: `a ^ a = 0` and `a ^ 0 = a`. Single number = XOR of all. Missing number = XOR of full range XOR all elements (or `n*(n+1)/2 - sum` with overflow care).
* **Linked Problems:**
  * `[L0136]` Single Number — O(N) / O(1)
  * `[L0268]` Missing Number — O(N) / O(1)

## 13. Boyer-Moore Voting Algorithm

* **Triggers:** "element appears more than n/2 times", "majority element (guaranteed to exist)"
* **Core Template:** Maintain a `candidate` and `count`; increment/decrease count; reset candidate when count hits 0. Second pass to verify (majority count > n/2).
* **Linked Problems:**
  * `[L0169]` Majority Element — O(N) / O(1)

## 14. String — Parsing / Scanning / Traversal

* **Triggers:** "string to integer", "longest common prefix", "rotate string", "reverse words", "parentheses depth", "largest odd number", "roman numerals"
* **Core Template:** Often a **right-to-left or single-pass scan** with a running counter, or a small FSM/bounds check for parsing. Identify the direction that avoids extra work (e.g., scan from right for last odd digit, `s+s` trick for rotation).
* **Linked Problems:**
  * `[L0008]` String to Integer (atoi) — O(N) / O(1)
  * `[L0014]` Longest Common Prefix — O(N) / O(N)
  * `[L0013]` Roman to Integer — O(N) / O(1)
  * `[L0151]` Reverse Words in a String — O(N) / O(N)
  * `[L0796]` Rotate String — O(N) / O(1)
  * `[L1021]` Remove Outermost Parentheses — O(N) / O(1)
  * `[L1614]` Maximum Nesting Depth of Parentheses — O(N) / O(1)
  * `[L1903]` Largest Odd Number in String — O(N) / O(1)

## 15. String — Palindrome / Frequency / Substring

* **Triggers:** "palindromic substring", "sum of beauty of substrings", "characters by frequency", "sort characters"
* **Core Template:** Palindrome → expand around each center (odd & even). Frequency → count array/map then bucket sort. Substring metrics → enumerate substrings + maintain frequency.
* **Linked Problems:**
  * `[L0005]` Longest Palindromic Substring — O(N²) / O(1)
  * `[L1781]` Sum of Beauty of All Substrings — O(N²) / O(N)
  * `[L0451]` Sort Characters by Frequency — O(N) / O(K)

## 16. Math / Counting / Digit Manipulation

* **Triggers:** "even number of digits", "sorted and rotated", "max consecutive ones", "rotate array", "second largest numeric"
* **Core Template:** Mostly **single-pass counting** with a small invariant (count decreases / break-points / digit counts). Rotation via `reverse` trick (3 reverses).
* **Linked Problems:**
  * `[L1295]` Numbers with Even Number of Digits — O(N) / O(1)
  * `[L1752]` Check Array is Sorted and Rotated — O(N) / O(1)
  * `[L0485]` Max Consecutive Ones — O(N) / O(1)
  * `[L0189]` Rotate Array — O(N) / O(1)

---

## How to add a newly solved problem

1. Merge the 4-line metadata (`Pattern / Trigger / Traps / TC:SC`) into the file's `///` header (see [L0053.java](src/LeetCode/Arrays/L0053.java) as the canonical format).
2. Append one row to [src/LeetCode/PROBLEMS.md](src/LeetCode/PROBLEMS.md).
3. Add the problem ID + TC/SC under its pattern section here (create a new section if it's a fresh pattern with a distinct trigger).
