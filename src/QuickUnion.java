// Parker Hines
// CSc 345
// Project

// data structure for the Quick-Union implementation for Union-Find.
// performs union on two elements by joining existing subtrees
// starting at size 1 (element itself)
public class QuickUnion {
	private int count; // number of distinct sets
	private int originalSize;
	private int[] parents; // index value is the index of its parent

	// constructor creates new quick union structure of size n
	public QuickUnion(int n) {
		this.parents = new int[n];
		this.count = n;
		this.originalSize = n;
		// each element starts as it's own parent, forming
		// n distinct sets (count = n)
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	// find the root of the element p
	public int find(int p) {
		checkInput(p); // check that given input is indexable
		// repeatedly check the parent of p to see if it is
		// it's own root
		// int original = p;
		while (p != parents[p])
			p = parents[p];
		// System.out.println("The root of " + original + " is" + p);
		return p;
	}

	// perform a union on the two sets containing the values
	// p and q by connecting the trees containing both elements
	public void union(int p, int q) {
		// search for the root of both elements
		int pRoot = find(p);
		int qRoot = find(q);

		// if roots are equal, no union needed
		if (pRoot == qRoot) {
			return;
		}

		// major difference from quickfind is here. instead of updating all
		// the elements in the union (which is O(N) time), i can instead form a tree
		// and update the root, allowing me to check if two elements are in a union
		// in a worst case complexity relative to the height of the tree (size of
		// union).
		parents[pRoot] = qRoot; // update to a single root, merging sets
		//System.out.println("The root of " + p + " is now " + qRoot + ". Elements joined.");
		count--; // 2 sets became 1, so decrement count of existing sets
	}
	
	// check if two elements are connected (exist in the same set)
	public boolean connected(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		
		// if roots are the same, elements exist in the same tree/set -> connected
		if (pRoot == qRoot) {
			return true;
		} else {
			return false;
		}
	}

	// check that p is a valid index
	private void checkInput(int p) {
		// between 0 and n-1
		if (p >= originalSize || p < 0) {
			System.out.println("Index must be between 0 and " + originalSize + ".");
			System.exit(1);
		}
	}

	// return number of sets currently in structure, starts at original size, decrements
	// on each successful union
	public int count() {
		return this.count;
	}
	
	public String toString() {
		String output = "[ ";
		for (int i = 0; i < originalSize; i++) {
			output += Integer.toString(parents[i]);
			if (i < originalSize - 1) {
				output += ", ";
			}
		}
		output += " ]";
		return output;
	}

}