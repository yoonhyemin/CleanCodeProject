package temp;
import java.util.Scanner;

public class sortingNumber {
	private static int numberOfInputNumber;
	private static int[] inputNumbers = new int[20];
	private static int menuNumber;
	private static int i, j;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {			
		printStudentInfo();
		chooseMenu();
	}
		
	private static void printStudentInfo() {
		System.out.println("[ ID : 1316081 ]");
		System.out.println("[ Name : Yoon HYEMIN ] ");	
	}

	private static void chooseMenu() {	
	
		while ( true ) {		
			printMenu();
			menuNumber = scan.nextInt();
			
			if ( isQuitMenu() )
				break;
		
			switch ( menuNumber ) {
			
				case 1 :
					receiveNumberOfInputNumber();
					receiveNumbers();					
					break;
					
				case 2 :
					printAscendingOrder();
					break;
					
				case 3 :
					printDescendingOrder();
					break;
				
				default :
					return;		
			}	
		}	
	}

	private static void printMenu() {
		System.out.println("\n1. Input numbers");
		System.out.println("2. Print numbers in increasing order");
		System.out.println("3. Print numbers in decreasing order");
		System.out.println("4. Quit \n");
	}

	private static boolean isQuitMenu() {
		return menuNumber == 4;	
	}

	private static void receiveNumberOfInputNumber() {
		System.out.print("the number of numbers: ");
		numberOfInputNumber = scan.nextInt();		
	}
	
	private static void receiveNumbers() {
		System.out.print("numbers: ");
		
		for (int i = 0; i < numberOfInputNumber; i++) {
			inputNumbers[i] = scan.nextInt();
		}	
	}
	
	private static void printAscendingOrder() {			
		sortNumbers();
		printResultOfOrdering();
	}
	
	private static void printDescendingOrder() {	
		sortNumbers();
		printResultOfOrdering();	
	}

	private static void sortNumbers() {
		
		for ( i = 0; i < numberOfInputNumber - 1; i++ ) {
			for ( j = 0; j < numberOfInputNumber - 1 - i; j++ ) {				
				proceedSortOrder();
			}
		}
	}
	
	private static void proceedSortOrder() {
		
		if ( chooseSortOrder() ) {
			swap();
		}		
	}

	private static boolean chooseSortOrder() {
		
		if ( isAscendingOrder() )
			return inputNumbers[j] > inputNumbers[j + 1];
			
		else if ( isDescendingOrder() )
			return inputNumbers[j] < inputNumbers[j + 1];
		
		return false;
	}
	
	private static boolean isAscendingOrder() {
		return menuNumber == 2;	
	}
	
	private static boolean isDescendingOrder() {
		return menuNumber == 3;
	}

	private static void swap() {
		int TEMP = inputNumbers[j];
		inputNumbers[j] = inputNumbers[j + 1];
		inputNumbers[j + 1] = TEMP;	
	}
	
	private static void printResultOfOrdering() {
		
		for ( int i = 0; i < numberOfInputNumber; i++ ) {
			System.out.print(inputNumbers[i] + " ");
		}
		
		System.out.print("\n");			
	}
}