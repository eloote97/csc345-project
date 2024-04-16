import java.util.Arrays;

public class WeightedUnion {
	/**
	 * Authors:
	 * 		find(int x): 	Parker Hines.
	 * 		The rest: 		Hengsocheat Pok.
	 */
	
	// an array of trees/sets
	private int[] parents;
	// the num of elements in each tree
	private int[] size;
	// the num of trees/sets
	private int count;
	
	public WeightedUnion() {
		parents = new int[11];
		size = new int[11];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
			size[i] = 1;
		}
		count = 11;
	}
	
	public WeightedUnion(int count) {
		parents = new int[count];
		size = new int[count];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
			size[i] = 1;
		}
		this.count = count;
	}
	
	// find the root of the element p
	public int find(int x) {
		// check that given input is indexable
		if (x < 0 || x >= parents.length) {
			System.out.println("value returned: " + Integer.MIN_VALUE + 
					" (Not accepted, has to be from " + 
					"0 to " + (parents.length - 1));
			return Integer.MIN_VALUE;}
		// repeatedly check the parent of p to see if it is
		// it's own root
		// int original = p;
		while (x != parents[x])
			x = parents[x];
		
		return x;
	}
	
	public void union(int x, int y) {
		/**
		 * Merge the sets containing elements x and y
		 * by attaching the smaller tree to the root of the larger tree.
		 */
		int x_root = find(x);
		int y_root = find(y);
		
		// if x and y already belong to the same set
		// return
		if (x_root == y_root)
			return;
		// if element x's set has a size less than that of the set of y
		if (size[x_root] < size[y_root]) {
			// select y's root as the root of the newly combined set
			parents[x_root] = y_root;
			// y's set's size += the x's set's size
			size[y_root] += size[x_root];
		} 
		// if both elements' sets have the same size
		// or element x's set is smaller than that of y
		// do the opposite
		else {
			// select y's root as the root of the newly combined set
			parents[y_root] = x_root;
			// y's set's size += the x's set's size
			size[x_root] += size[y_root];
		}
		count--;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getSize(int x) {
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
