import java.util.Scanner;

public class MainController {
	private DataController dataController;
	private char typeOfData;
	Scanner scan = new Scanner(System.in);
	
	public MainController() {
		this.dataController = new DataController();
	}
	
	public void startMenu() {
		while(true) {
			printMenu();
			chooseMenu();
		}
	}
	
	public void chooseMenu() {
		char typeOfData = 0;
		int menuNumber;
		menuNumber = scan.nextInt();
		
		switch ( menuNumber ) {	
			case 1 :
				typeOfData = this.dataController.setTypeOfData();  
				this.typeOfData = typeOfData;
				this.dataController.setData(typeOfData); 
				break;
				
			case 2 :
				this.dataController.sortAndPrintData(menuNumber, this.typeOfData);  
				break;
				
			case 3 :
				this.dataController.sortAndPrintData(menuNumber, this.typeOfData); 
				break;
			
			default :
				return;			
		}
		
	}
	
	public void printMenu() {
		System.out.println("\n1. Input data");
		System.out.println("2. Print data in increasing order");
		System.out.println("3. Print data in decreasing order");
		System.out.println("4. Quit \n");
	}
	
}
