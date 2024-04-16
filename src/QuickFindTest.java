import java.util.Scanner;

public class QuickFindTest {
    public static void main(String[] args) {
        System.out.println("Enter N and sequence of pairs of integers");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        // Create a QuickFind data structure with N elements
        QuickFind qf = new QuickFind(n);

        // Continue reading pairs of integers until there's no more input
        while (scan.hasNext()) {
            int p = scan.nextInt();
            int q = scan.nextInt();

            // Check if elements p and q are already in the same component
            if (qf.find(p) == qf.find(q)) {
                // If so, print the pair of integers and the current number of components
                System.out.println(p + " " + q);
                System.out.println(qf.count() + " components");
                printComponents(qf);
                continue; // Skip the union
            }

            // If elements p and q are not in the same component, perform a union operation
            qf.union(p, q);

            // Print the pair of integers and the current number of components after the union operation
            System.out.println(p + " " + q);
            System.out.println(qf.count() + " components");
            printComponents(qf);
        }

        scan.close();
    }
    
    // Method to print all components
    private static void printComponents(QuickFind qf) {
        System.out.println("Components:");
        for (int i = 0; i < qf.id.length; i++) {
            System.out.print(qf.id[i] + " ");
        }
        System.out.println();
    }
}
