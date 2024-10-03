# Assignment - Data Structures and Algorithms

## Student Information
- **Name:** Navneet Sharma
- **Student ID:** C0905816

## Challenges Overview

### 1. Artifact Vault
- **Description:** This challenge involved creating a vault to store artifacts with the ability to add, remove, and search artifacts using linear and binary search techniques.
- **Approach:** I used an array to store the artifacts, with each artifact having a name and an age. The vault has methods to add artifacts, remove them, and search them using linear and binary search algorithms. The artifacts are stored in the vault until space is full.
- **Assumptions & Design Decisions:** I assumed that the vault has a fixed size and that the artifacts are represented by a name and age. For binary search, I sorted the artifacts based on age before searching. I also ensured the vault handles both full and empty conditions gracefully.

### 2. Clue Tree
- **Description:** This challenge required implementing a binary search tree (BST) to store clues with methods for inserting, searching, and performing tree traversals (in-order, pre-order, and post-order).
- **Approach:** I implemented the BST using nodes, where each node contains a clue and pointers to its left and right children. The tree supports inserting new clues and performing the three traversal techniques.
- **Assumptions & Design Decisions:** I assumed that each clue is a unique string. The binary search tree was designed to maintain a sorted order of clues for efficient insertion and searching. I utilized recursive methods for both insertions and traversals to keep the code clean and concise.

### 3. Scroll Stack
- **Description:** The scroll stack required implementing a stack data structure to manage a collection of scrolls. It should allow pushing, popping, and checking if the stack is empty.
- **Approach:** I used an array-based stack to store scrolls. The stack supports operations like pushing a scroll, popping a scroll, and checking if the stack is empty. The stack dynamically resizes when necessary, ensuring that we don't encounter overflow issues.
- **Assumptions & Design Decisions:** I assumed that the scrolls have unique identifiers (names) and that the stack has a fixed size. In a production environment, a more complex resizing mechanism could be implemented. I used the LIFO (Last-In, First-Out) principle to maintain the integrity of the stack operations.

### 4. Explorer Queue
- **Description:** The explorer queue was implemented as a queue data structure to manage a list of explorers. It supports enqueueing explorers, dequeueing them, and checking if the queue is empty.
- **Approach:** A simple circular queue was implemented using an array. I handled enqueue and dequeue operations efficiently by tracking the front and rear indices of the queue. I used modulo arithmetic to handle circular behavior when adding or removing explorers.
- **Assumptions & Design Decisions:** I assumed that the queue size was fixed, and the explorers have unique identifiers. A dynamic queue with resizing could improve efficiency in handling large datasets. The circular queue approach ensures that memory is utilized optimally.

### 5. Labyrinth Path
- **Description:** This challenge required finding a path through a labyrinth using a pathfinding algorithm. The goal was to implement a solution that can find the correct path from a starting point to a goal.
- **Approach:** I used a depth-first search (DFS) approach to explore the labyrinth and find the path from the start to the goal. The algorithm explores one path as far as possible before backtracking to explore alternative paths.
- **Assumptions & Design Decisions:** I assumed the labyrinth was represented as a 2D grid and that the start and goal points are clearly defined. I made the design decision to use DFS, which is a simple and effective method for exploring paths in a maze. For more complex mazes, I would consider using algorithms like BFS or A* for better performance.

## Running the Code

1. Ensure that you have Java installed on your machine.
2. Download the project folder.
3. Open a terminal/command prompt and navigate to the project folder.
4. Compile the Java code:
   ```bash
   javac Main.java
