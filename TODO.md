# TODO

## Conclusion: Repository Reorganization for Pattern-First Revision

**Goal:** Make the **identified pattern** travel with each problem while keeping the repo
scannable and maintainable under placement crunch.

**Guiding principle (confirmed):** *One single source of truth for code, one single source of
truth for quick revision.* No overlapping indexes. No documentation you won't maintain.

### File ownership & responsibilities (no content overlap)

| File | Job | Touched when |
| --- | --- | --- |
| `src/.../LXXXX.java` | Executable code + full problem context + pattern metadata | After solving a problem |
| `PROBLEMS.md` | Code Index / Registry (flat searchable table) | Append 1 row per new file |
| `MasterNotes.md` | Pattern Trigger Matrix (group by pattern, not ID) | Discover/link a pattern |
| `Progress_Tracker.md` + `ROADMAP.md` | Syllabus / topic coverage checklists | End of each study sprint |
| `README.md` | High-level overview & links | Rarely |

There are exactly **2 active docs for revision** (`PROBLEMS.md` = code index,
`MasterNotes.md` = pattern index); the syllabus files are a separate axis and remain untouched.

---

### Action items

1. **Unified in-file header** — fold `Pattern / Trigger / Traps / TC / SC` into the *existing*
   `///` Markdown Javadoc block, directly under the title line. Do **not** stack a second block.
   This keeps the problem statement + pattern metadata in one coherent top-of-file doc.

   ```java
   /// # [L0053: Maximum Subarray](https://leetcode.com/problems/maximum-subarray)
   /// **Level:** Medium | **Pattern:** Running Sum / Kadane's | **TC / SC:** O(N) / O(1)
   /// **Trigger:** "contiguous subarray", "largest sum", negative values allowed
   /// **Traps:** All-negative array (init max to `Integer.MIN_VALUE` or `nums[0]`, never 0)
   ```

2. **Refactor `MasterNotes.md` into a Pattern Trigger Matrix** — group by pattern name
   (Sliding Window & Two Pointers, Binary Search on Answer, Fast & Slow, Monotonic Stack, ...).
   Each entry: **Trigger words → Core template/invariant → Traps → Linked problem IDs** with TC/SC.

3. **Keep `PROBLEMS.md` as the flat code registry** — Problem ID → Title → Topic → Optimal
   Approach → TC/SC → File link. One row per file, append-only.

4. **Do NOT create per-folder `Patterns.md`** — fragments revision across files.

5. **Move `src/LeetCode/L1295.java`** into `src/LeetCode/Arrays/` to clean the root folder.

6. **Retain `Progress_Tracker.md` / `ROADMAP.md` strictly as syllabus checklists.**

---

### Standard post-solve micro-workflow (under 60s)

1. Write code → verify → submit (no AI).
2. Merge 3-4 line pattern metadata into the `///` header of the `.java` file.
3. Append 1 row to `PROBLEMS.md`.
4. Log the problem ID under its pattern in `MasterNotes.md` (only if a new/notable link).

### What NOT to do

- Do not let AI rewrite functional code into one-liner streams.
- Do not store verbose AI markdown.
- Do not maintain overlapping index files.
