# csc345-project
union find

QUICK-FIND: The QuickFind datastructure is a simple implementation of the Union-Find data structure. It
represents a collection of sets, where each element belongs to exactly one set. The key operations are 
find() and union(). Union has a worst case runtime of O(N) because it needs to update every object in a
component. The expected case is also O(N) since the worst-case scenerio often occurs. The find() method
returns the component identifier of the given element and has a time complexity of O(1).

INSTRUCTIONS FOR QuickFindTest.java:

1. Run QuickFindTest.java
2. Enter size of the array
3. Press Enter
4. Enter 2 integers separated by a space to represent a pair of objects you want to union together (union(p,q)).
5. Output will print the total number of components after the union call and the current state of the QuickFind
   data structure.

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

WEIGHTED QUICK-UNION: This aims to optimize Quick-Union by first checking the relative height, or "weight" of the
trees being unioned. Then the smaller of the two trees is merged to the root of the larger, effectively maintaining
a more balanced tree, which will result in more effecient runtimes for both union() and find(), bringing the worst
case of both methods down from O(N) to O(logn).

INSTRUCTIONS FOR WeightedUnionTest.java:

1. Tests the WeightedUnion logic.
2. Works exactly the same as the test for QuickUnion.
3. The difference is after test, it will print an array of sizes of each tree/subtree after the number of sets/trees.
4. To interpret the sizes, compare the newly printed array side by side with the array of trees
5. Example: Final array of trees: [0, 2, 8, 3, 4, 2, 8, 8, 8, 8] ,    Array of sizes printed: [1, 1, 3, 1, 1, 1, 1, 1, 7, 1].
    Example of how to analyze:
   - At index 1 and 5, they are nodes with number 1 and number 2, whose common parent is a node with number 2. Both of the nodes are subtrees of size/weight 1 (they have no children).
   - At index 2, number 2 is connected to a parent with nummber 8 and is of size 3 (number 2 has two children, 1 and 5)
   - At index 8, number 8 has a parent that is itself and the tree at that position is of size 7 (having 7 children total, including the other tree of size 3). Thus, 8 is also the root of the big tree.


WEIGHTED QUICK UNION W/ PATH COMPRESSION: Ths data structure operates just like weighted quick union
but with the implementation of PATH COMPRESSION. Path compression involves determining if elements are
of the same sets during the find function. This is performed by recursiveley making each element point
to its root note if find() is called on this element. This makes future find() operations faster because
the paths are shorter. Overall, the trees are flattened without changing the semantics of the sets.
Regarding time complexity, find() and union() are significanty improved from O(n) time to O(α(n) time.
α represents the inverse Ackermann function which essentially means that the time grows very very slowly
even as n increases because the trees continue to remain very flat due to path compression. 
      

INSTRUCTIONS FOR WeightedUnionPC.java TESTING CODE: 

1. Run WeightedUnionPCTest.java
2. Tests will run automatically
3. Observe results and read the Notes
         
