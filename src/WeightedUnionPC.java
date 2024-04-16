/*
 * Author: Elliot Seo
 * 		   Recycles code from WeightedUnion.java
 * CSC 345
 * Project
 * 
 * Purpose: Implements Weighted Quick Union with Path Compression
 * 			on the find() method
 */

import java.util.Arrays;

public class WeightedUnionPC {
	// an array of trees/sets
	private int[] parents;
	// the num of elements in each tree
	private int[] size;
	// the num of trees/sets
	private int numTrees;
	
	/*
	 * constructor creates a new quick union w/ PC structure of size 11
	 */
	public WeightedUnionPC() {
		this(11);
	}
	
	/*
	 * constructor creates a new quick union w/ PC structure of size count
	 */
	public WeightedUnionPC(int count) {
		parents = new int[count];
		size = new int[count];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
			size[i] = 1;
		}
		this.numTrees = count;
	}
	
	/*
	 * finds the root of an element x. utilizes path compression by 
	 * recursively making each element point to the parent node. This
	 * will not change the semantics of the tree.
	 */
	public int find(int x) {
	    if (x < 0 || x >= parents.length) {
	        System.out.println("value returned: " + Integer.MIN_VALUE + 
	                " (Not accepted, has to be from " + 
	                "0 to " + (parents.length - 1));
	        return Integer.MIN_VALUE;
	    }
	    // recursively reassign pointer to point to root of tree
	    if (x != parents[x]) {
	        parents[x] = find(parents[x]);  
	    }
	    return parents[x];
	}
	
	/*
	 * Mergest the two trees containing elements x and y. Considers weights
	 * so the tree containing less is connected to the root of the larger tree.
	 */
	public void union(int x, int y) {
	    int x_root = find(x);
	    int y_root = find(y);

	    // trees have same root
	    if (x_root == y_root) return;

	    // smaller tree under the root of the larger tree
	    if (size[x_root] < size[y_root]) {
	        parents[x_root] = y_root; 
	        size[y_root] += size[x_root]; 
	    } else {
	        parents[y_root] = x_root; 
	        size[x_root] += size[y_root]; 
	    }

	    numTrees--;
	}
	
	public int numTrees() {
		return numTrees;
	}
	
	public int size(int x) {
		return size[x];
	}
	
	public int[] getWeights() {
		return size;
	}
	
	public int length() {
		return parents.length;
	}
	
	public String toString() {
		return Arrays.toString(parents);
	}
}