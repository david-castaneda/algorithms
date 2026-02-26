Algorithms and data structures collected over time.

## Algorithms

- [MST of a Graph - Prims Algorithm](https://www.geeksforgeeks.org/dsa/prims-minimum-spanning-tree-mst-greedy-algo-5/)
- [Shortest Path - Dijkstra's](https://www.geeksforgeeks.org/dsa/dijkstras-shortest-path-algorithm-greedy-algo-7/)
- [Manhattan Distance](https://www.geeksforgeeks.org/data-science/manhattan-distance/)

### Must Read

- https://www.techinterviewhandbook.org
-

## Python Examples

#### Stack (LIFO data structure)

- insert (push): \*O(1) amortized
- peek: O(1)
- pop: O(1)

```python
stack = [] # list used as a stack
stack.append(1) # push to end
stack[-1] # peek
stack.pop() # prop from end

# Check if stack is empty
if stack:
    print("Not empty")
```

#### Queue (FIFO data structure)

Best practice: Use `collections.deque`

- insert (enqueue): O(1)
- peek: O(1)
- pop: O(1)

```python
from collections import deque

q = deque()
q.append(1) # enqueue right
q[0] # peek front (left)
q.popleft() # dequeue left

# Check if queue is empty
if q:
    print("Not empty")
```

---

## Java Examples

- [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)
- [Character](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html)
- [ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [Collections](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html)
- [HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
- [HashSet](https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html)
- [PriorityQueue](https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html)
- [Deque](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)
- [Iterator](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html)
- [TreeMap](https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html)

### Java APIs

| Task                            | API                                                    | Example                                                                 | Notes                                                                                           |
| ------------------------------- | ------------------------------------------------------ | ----------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| Sort an array (ascending)       | `Arrays.sort(...)`                                     | `int[] a = {3,1,2}; Arrays.sort(a);`                                    | Primitives sort ascending. For objects, you can pass a `Comparator`.                            |
| Binary search in a sorted array | `Arrays.binarySearch(...)`                             | `int i = Arrays.binarySearch(a, target);`                               | Array must be sorted. Returns index if found, otherwise `-(insertionPoint) - 1`.                |
| Sort a string (lexicographic)   | `toCharArray()`, `Arrays.sort(...)`, `new String(...)` | `char[] c = s.toCharArray(); Arrays.sort(c); String t = new String(c);` | Sorts by Unicode code point. Use `s.toLowerCase()` first if you want case-insensitive behavior. |
| Integer min/max value           | `Integer.MIN_VALUE`, `Integer.MAX_VALUE`               | `int lo = Integer.MIN_VALUE, hi = Integer.MAX_VALUE;`                   | Useful as sentinels and bounds in algorithms.                                                   |
| Double infinity                 | `Double.POSITIVE_INFINITY`, `Double.NEGATIVE_INFINITY` | `double inf = Double.POSITIVE_INFINITY;`                                | Also: `Double.isInfinite(x)` to check.                                                          |
