Algorithms and data structures collected over time.

### Python Examples

#### Stack (LIFO data structure)

- insert (push): \*O(1) amortized
- peek: O(1)
- pop: O(1)

```python
stack = [] # list used as a stack
stack.append(1) # push to end
stack[-1] # peek
stack.pop() # prop from end
```

- Queue (FIFO data structure)

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
```

---

### Java Docs

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

### Algorithms

- [MST of a Graph - Prims Algorithm](https://www.geeksforgeeks.org/dsa/prims-minimum-spanning-tree-mst-greedy-algo-5/)

### Java APIs

| Task                            | API                                                    | Example                                                                 | Notes                                                                                           |
| ------------------------------- | ------------------------------------------------------ | ----------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| Sort an array (ascending)       | `Arrays.sort(...)`                                     | `int[] a = {3,1,2}; Arrays.sort(a);`                                    | Primitives sort ascending. For objects, you can pass a `Comparator`.                            |
| Binary search in a sorted array | `Arrays.binarySearch(...)`                             | `int i = Arrays.binarySearch(a, target);`                               | Array must be sorted. Returns index if found, otherwise `-(insertionPoint) - 1`.                |
| Sort a string (lexicographic)   | `toCharArray()`, `Arrays.sort(...)`, `new String(...)` | `char[] c = s.toCharArray(); Arrays.sort(c); String t = new String(c);` | Sorts by Unicode code point. Use `s.toLowerCase()` first if you want case-insensitive behavior. |
| Integer min/max value           | `Integer.MIN_VALUE`, `Integer.MAX_VALUE`               | `int lo = Integer.MIN_VALUE, hi = Integer.MAX_VALUE;`                   | Useful as sentinels and bounds in algorithms.                                                   |
| Double infinity                 | `Double.POSITIVE_INFINITY`, `Double.NEGATIVE_INFINITY` | `double inf = Double.POSITIVE_INFINITY;`                                | Also: `Double.isInfinite(x)` to check.                                                          |

### Running the solutions

There is a helper file `run.sh` that will compile and run the java solution.

Example: `./run.sh ./trees/BFS.java`

Known working versions: (`java --version`)

- `java 17.0.7 2023-04-18 LTS`
