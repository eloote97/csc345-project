public class WeightedUnionPCTest {

    public static void main(String[] args) {
    	// TEST 1: Shows that Path Compression does not change semantics of trees
    	System.out.println("***** TEST 1 *****");
    	
        // create instance of WeightedUnionPC 
    	System.out.println("\n...creating instance of size 10 WITH path compression...");
        WeightedUnionPC wu = new WeightedUnionPC(10);
        System.out.println();
        
        System.out.println("Each element shown is the root of its own set.");
        System.out.println("Current state: " + wu.toString());
        
        System.out.println("\n...performing following union operations...");
        System.out.println("    1 and 2");
        System.out.println("    3 and 4");
        System.out.println("    3 and 5");
        System.out.println("    1 and 3");
        System.out.println("    0 and 2\n");
        wu.union(1, 2);
        wu.union(3, 4);
        wu.union(3, 5);
        wu.union(1, 3);
        wu.union(0, 2);

        // check 2 elements in same set
        System.out.println("1 and 3 are connected (should be true): " + (wu.find(1) == wu.find(3)));
        System.out.println("4 and 7 are connected (should be false): " + (wu.find(4) == wu.find(7)));
        
        System.out.println("Current state: " + wu.toString());
        
        System.out.println("Number of trees: " + wu.numTrees());
        
        // create an instance of WeightedUnion
        WeightedUnion wu1 = new WeightedUnion(10);
        System.out.println();
        System.out.println("...creating instance of size 10 WITHOUT path compression...");
        System.out.println("...performing same exact union operations as previous instance...");
        System.out.println("\nCurrent state: " + wu1.toString());
        
        // Perform some union operations
        wu1.union(1, 2);
        wu1.union(3, 4);
        wu1.union(3, 5);
        wu1.union(1, 3);
        wu1.union(0, 2);

        // check 2 elements in same set
        System.out.println("1 and 3 are connected (should be true): " + (wu1.find(1) == wu1.find(3)));
        System.out.println("4 and 7 are connected (should be false): " + (wu1.find(4) == wu1.find(7)));
        
        System.out.println("Current state: " + wu1.toString());
        System.out.println("Number of trees: " + wu1.getCount());
        
        // compare num trees of both instances
        System.out.println("\nBoth instances have same # of trees (should be true): "
        		+ (wu.numTrees() == wu1.getCount()));

        System.out.println("\n  **NOTE**\nBoth instances have the same number of trees "
        		+ "because path\ncompression does not change semantics of trees");
        
        
        // TEST 2: shows that path compression works
        System.out.println("\n\n***** TEST 2 *****");
    	
        // create instance of WeightedUnionPC 
    	System.out.println("\n...creating instance of size 12 WITH path compression...");
        WeightedUnionPC wu2 = new WeightedUnionPC(12);
        System.out.println();
        
        System.out.println("Each element shown is the root of its own set.");
        System.out.println("Current state: " + wu2.toString());
        
        System.out.println("\n...performing following union operations...");
        System.out.println("    2 and 3");
        System.out.println("    4 and 5");
        System.out.println("    5 and 6");
        System.out.println("    2 and 4\n");
        wu2.union(2, 3);
        wu2.union(4, 5);
        wu2.union(5, 6);
        wu2.union(2, 4);
        
        System.out.println("Current state: " + wu2.toString());
        
        System.out.println("\n...performing following union operations...");
        System.out.println("    1 and 3\n");
        wu2.union(1, 3);
        System.out.println("Current state: " + wu2.toString());

        System.out.println("\n  **NOTE**\nObserve that element 3 now points to its root"
        		+ " (element 4)\ninstead of its direct parent like it did before. This\n"
        		+ "is because calling union on elements 1 and 3 applied\npath compression"
        		+ " causing element 3's pointer to be\nredirected to its root. This makes future"
        		+ " operations of\nfind to be more efficient.");
    }
}

