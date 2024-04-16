import java.util.Scanner;
//Parker Hines
//CSc 345
//Project

// test file for QuickUnion data structure
public class QuickUnionTest {
	// takes input from user for size of n, then prompts user for two elements to
	// union together. will output the current roots of p and q, and the resulting
	// roots after merge.
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Number of elements: ");
		int n = scanner.nextInt();
		QuickUnion QU = new QuickUnion(n);
		System.out.println("Enter two elements to union (0-" + (n-1) + "): ");
		while (scanner.hasNext()) {
			int p = scanner.nextInt();
			if (p == -1) { // sentinel to check connectivity
				break;
			}
			int q = scanner.nextInt();
			if (q == -1) {
				break;
			}
			// check if already connected
			if (QU.connected(p, q)) {
				System.out.println("Elements already unioned.");
				continue;
			}
			// check the current roots of both inputs
			System.out.print("The root of " + p + " is " + QU.find(p));
			System.out.println(". The root of " + q + " is " + QU.find(q) + ".");
			QU.union(p, q); // perform union
			// check the new root of p, and check p and q are in the same set
			System.out.print("The root of " + p + " updated to " + QU.find(p) + ". ");
			// check if elements are now connected
			if (QU.connected(p, q)) {
				System.out.println("Elements now exist in the same set.");
			} else {
				System.out.println("HOWEVER, elements DO NOT exist in the same set?");
			}
			System.out.println(QU.toString());
			//System.out.println(QU.count() + " updated set count.");
		}
		// after done performing unions, check any two elements are connected
		System.out.println(QU.count() + " total sets exist in the structure.");
		System.out.println("Enter two elements to test connectivity (0-" + (n-1) + "): ");
		while (scanner.hasNext()) {
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			// check/print roots
			System.out.print("The root of " + p + " is " + QU.find(p));
			System.out.println(". The root of " + q + " is " + QU.find(q) + ".");
			if (QU.connected(p, q)) { // check connectivity
				System.out.println("Elements are in the same set -> [CONNECTED]");
			} else {
				System.out.println("Elements are NOT in the same set -> [NOT CONNECTED]");
			}
		}
		scanner.close();
	}

}
