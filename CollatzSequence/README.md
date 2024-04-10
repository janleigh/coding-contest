## Collatz Sequence [MEDIUM]

The Collatz Sequence ($3n + 1$ Sequence) is a sequence of numbers that starts with any positive integer, $N$,  by following these rules:

- If $N$ is even, divide it by $2$.
- If $N$ is odd, multiply it by $3$ and add $1$.
- Repeat the above steps until it becomes $1$.

For example, the collatz sequence of $5$ is: `5, 16, 8, 4, 2, 1`.

Write a function that takes a **big** positive integer as an input, $n$, and returns the length of the Collatz Sequence.

Input:
```java
<CollatzSequence>.collatzSequenceLength(13); // Output: 10
```
