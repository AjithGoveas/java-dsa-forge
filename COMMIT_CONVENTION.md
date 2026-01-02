# 📝 Commit Convention & Workflow Manual – java-dsa-forge

This repository is not just for solving DSA problems — it is designed as a **professional, shareable knowledge base**
for interview preparation.
To maintain clarity, structure, and industry‑grade practices, follow this commit convention and branching workflow.

## 🌿 Branching Workflow

- **Create a branch per topic** <br/> Examples:
    - `arrays`
    - `recursion`
    - `linkedlist`
    - `trees`

- **Work inside the topic branch**
    - Add raw notes, daily progress, problem solutions and refactors.
    - Commit frequently using the conventions below.

- **Merge into** `main` **only when the topic is complete**
    - Polished notes + solved problems + documentation.
    - Use a `milestone:` commit for the merge.
    - This keeps `main` clean and profession.

## ✔️ Commit Types

### progress:

For daily work on problems or subtopics.
Examples:

- progress: solved 3 problems on array basics
- progress: practiced recursion with 2 medium-level problems

### notes:

For updates to conceptual notes or documentation.
Examples:

- notes: added explanation of array memory management
- notes: polished recursion notes with examples and pitfalls

### refactor:

For improvements, cleanup, or restructuring in code.
Examples:

- refactor: optimized array input/output code
- refactor: cleaned recursion examples and improved readability

### milestone:

For completion of a major section or topic.
Examples:

- milestone: completed Arrays topic (theory + problems + notes)
- milestone: finished Recursion topic with notes and practice problems

### chore:

For maintenance tasks (repo organization, gitignore, folder cleanup).
Examples:

- chore: updated .gitignore for Java files
- chore: reorganized folders for linked list problems

## 🧭 Recommended Workflow per Topic

1. **Create branch**  
   Example: `git checkout -b arrays`

2. **Daily commits while working**
    - Use `progress:` for problems.
    - Use `notes:` for theory updates.
    - Use `refactor:` for cleanup.

3. **When topic is complete**
    - Polish notes and structure.
    - Commit with `milestone:`.
    - Merge branch into main.  
      Example:
        - `git checkout main`
        - `git merge arrays`
        - `git push origin main`

4. **Repeat for next topic**
   Create a new branch (`recursion`, `linkedlist`, etc.) and follow the same cycle.

## ➡️ Example Flow (Arrays Topic)

- progress: solved 2 problems on array basics
- notes: added notes on array declaration and initialization
- progress: practiced array I/O with for loops
- refactor: cleaned array input/output code
- milestone: completed Arrays topic (theory + problems + notes)

## ✅ Guidelines

- Keep commit titles **short and descriptive** (50–72 characters).
- Use the body (optional) for details like complexity, pitfalls, or references.
- Prefer **one logical change per commit** (don’t mix multiple topics).
- Stay consistent — even small daily commits should follow the format.

## 🤔 Why This Matters

- Keeps `main` clean and professional.
- Shows clear progression of learning.
- Professional, readable commit history for interviews and collaboration
- Trains good developer habits (branching, commit hygiene, documentation).
- Makes repo reusable for juniors, peers and open source community.
