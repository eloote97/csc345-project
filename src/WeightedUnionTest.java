import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WeightedUnionTest {

	public static void main(String[] args) {

		int size = -1;
		
		Scanner scanner = new Scanner(System.in);
		boolean validSize = false;
		
		// try reading from the console
		// until an integer greater than 0 is detected
		while (!validSize || size < 0) {
			System.out.println("Enter your intial number of elements:");
			String input;
			// if a null line is entered, continue with the default size
			try {
				input = scanner.nextLine();
			} catch (NoSuchElementException e) {
				break;
			}
			// prevent inputs that are not ints or are ints less than 0
			try {
				size = Integer.parseInt(input);
				if (size >= 0)
					validSize = true;
				else
					System.out.println("Invalid input. Please enter an integer that is greater than 0.");
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter an integer that is greater than 0.");
			}
		}
		
        WeightedUnion WU;
        
        // if the the user entered a null line
        // proceed with the default size
        if (!validSize) {
        	System.out.println("Default size chosen (11)");
        	System.out.printf("Your elements:\n");
        	WU = new WeightedUnion();
        	System.out.println(WU);
        	System.out.println("(each element shown is the root of its own set)");
        } 
        // if the user entered a valid size
        // proceed with the size entered
        else {
        	System.out.printf("Your elements:\n");
        	WU = new WeightedUnion(size);
        	System.out.println(WU);
        	System.out.println("(each element shown is the root of its own set)");

        }
        
        boolean validIndices = false;
        int index1, index2;
        // get the elements to merge
        while (!validIndices) {
			System.out.printf("\nEnter 2 elements(integers 0 - %d) from 2 sets that you wish to merge:\n", (WU.length() - 1));
			String input1, input2;
			// prevent null lines
			try {
				input1 = scanner.nextLine();
				input2 = scanner.nextLine();
			} catch (NoSuchElementException e) {
				break;
				// prevent out-of-bound indices
			} try {
				index1 = Integer.parseInt(input1);
				index2 = Integer.parseInt(input2);
				if ((0 <= index1 && index1 < WU.length() - 1) || (0 <= index2 && index2 < WU.length() - 1)) {
					WU.union(index1, index2);
					System.out.println("Your sets now: " + WU + "\n(each element shown is the root of its own set)");
				} else {
					System.out.println("Invalid! Please enter integers within the range 0 - " + (WU.length() - 1));
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid! Please enter integers within the range 0 - " + (WU.length() - 1));
			}
        	
        }
        System.out.println("Total number of sets: " + WU.getCount());
        System.out.println("Weights: " + Arrays.toString(WU.getWeights()));
        	
        // Close the scanner
        scanner.close();
	}

}
