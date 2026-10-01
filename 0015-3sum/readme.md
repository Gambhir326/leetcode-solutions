# 16. 3Sum Closest

- **Difficulty:** Medium
- **Topic:** Two Pointers / Sorting

### Key Insight
- Sorting first allows directional pointer movement.
- Fix pointer `i`, then treat the remainder as a standard 2-pointer squeeze.
- If `currentSum < target`, increment `left` to increase the sum; otherwise decrement `right`.

### Complexity
- **Time:** O(n^2)
- **Space:** O(1)