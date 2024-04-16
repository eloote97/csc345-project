// Christopher Le
// CSc 345
// Project

public class QuickFind {
	int[] id;   //id[i] = component identifier of i
	private int count;  // number of components
	
	// Constructor: Initializes QuickFind with N elements.
	// where each element is initially in its own component.
	public QuickFind(int N) {
		count = N;
		id = new int[N];
		
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	// This method returns true if p and q are in the same
	// component. Else, returns false
	public boolean connected(int p, int q) {
		if (!isValid(p) && !isValid(q)) {
			throw new IllegalArgumentException("index p or q is not valid");
		}
		return id[p] == id[q];
	}
	
	// Connects two elements p and q by merging their respective components.
	// If p and q are already in the same component, nothing happens.
	public void union(int p, int q) {
		// Check if p and q are valid
		if (!isValid(p) && !isValid(q)) {
			throw new IllegalArgumentException("index p or q is not valid");
		}
		int pId = id[p];
		int qId = id[q];
		
		// p and q are already in the same component
		if(pId == qId) {
			return;
		}
		// Loop through all elements in the 'id' array and check
		// if the current element has the same id as pId
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId) {
				id[i] = qId;  // Update the component identifier
			}
		}
		count--;
	}
	
	// Returns true if p is a valid index, returns false if p is an invalid index
	public boolean isValid(int p) {
		int n = id.length;
		if (p < 0 || p >= n) {
			return false;
		}
		return true;
	}
	
	// Returns the element of the set containing element p
	public int find(int p) {
		if (!isValid(p)) {
			throw new IllegalArgumentException("index " + p + " is not a valid index");
		}
		return id[p];
	}
	
	// Returns the number of sets
	public int count() {
		return count;
	}
}
