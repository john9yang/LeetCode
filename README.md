tesla:
1.
Minimum Deletion Cost to Avoid Repeating Letters

You are given a string S. Deletion of the K-th letter of S costs C[K]. After deleting a letter, the costs of deleting other letters do not change. You want to delete some letters from S to obtain a string without two identical letters next to each other. What is the minimum total cost of deletions to achieve such a string?

Example 1:

Input: S = "abccbd", C = [0, 1, 2, 3, 4, 5]
Output: 2
Explanation:
Delete the first occurrence of 'c' to achieve "abcbd".
Example 2:

Input: S = "aabbcc", C = [1, 2, 1, 2, 1, 2]
Output: 3
Explanation:
By deleting all letters with a cost of 1, you can achieve string "abc".
Example 3:

Input: S = "aaaa", C = [3, 4, 5, 6]
Output: 12
Explanation:
Delete all but one letter 'a', and the lowest cost of deletions is 3+4+5=12.