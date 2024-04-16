# csc345-project
union find

QUICK-UNION: The major difference between quick-find and quick-union is the efficiency of the union()
and find() operations. The efficiency of the find() operations drops significantly from constant(O(1))
to a runtime relative to the height of the tree. In the worst case, the tree can be extremely lopsided
leading to O(N) runtime, significantly worse than quick-find. The speed of union attempts to make up
for this by not needing to iterate through the entire array for each union, but at max the height of 
each tree of the elements being joined. In the worst case, this is again O(N). So the expected runtime
of union() improves, but not the worst case. This also comes at a significant cost to find() efficiency,
dropping it to O(N) in the worst case.

INSTRUCTIONS FOR QuickUnion.java TESTING CODE: 

1. Run QuickUnionTest.java
2. Enter the size of the array (number of starting sets) when prompted, press enter.
3. Enter the first element to be unioned.
4. Enter the second element to be unioned.

5. Output will print the root of both elements, and union results.
6. Repeat steps 3 and 4 to perform as many unions as desired.
7. Enter a sentinel value of (-1) to indicate you're done performing unions.
8. Enter the first element to test connectivity.
9. Enter the second element to test connectivity.
10. Output will print the root of both elements, and connectivity results.