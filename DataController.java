import java.util.Scanner;

public class DataController { 
	private Object[] data;
	Scanner scan = new Scanner(System.in);
	
	public DataController() {
		this.data = null;   
	}
	
	public DataController(Object[] data) {
		this.data = data;
	}
	
	public char setTypeOfData() { 	
		char typeOfData;
		System.out.print("the type of data (n or c): ");	
		typeOfData = this.scan.next().charAt(0);
		
		return typeOfData;
	}

	public void setData(char typeOfData) {
		int sizeOfData = setSizeOfData();
		
		createData(sizeOfData);
		
		if ( typeOfData == 'c' ) {
			setCharacters(sizeOfData);
		}
		
		else if ( typeOfData == 'n' ) {
			setNumbers(sizeOfData);
		}
	}
	
	public int setSizeOfData() {
		int sizeOfData = 0;
		
		System.out.print("the number of data: ");
		sizeOfData = scan.nextInt();	
		
		return sizeOfData;
	}
	
	public void createData(int sizeOfData) {
		this.data = new Object[sizeOfData]; 
	}
	
	public void setCharacters(int sizeOfData) {
		System.out.print("data: ");
		
		for ( int i = 0; i < sizeOfData; i++ ) {
			data[i] = scan.next().charAt(0);
		}
	}
	
	public void setNumbers(int sizeOfData) {
		System.out.print("data: ");
		
		for ( int i = 0; i < sizeOfData; i++ ) {
			data[i] = scan.nextInt();	
		}
	}
	
	public void sortAndPrintData(int menuNumber, char typeOfData) {	
		sortData(menuNumber, typeOfData);
		printResultOfOrdering(typeOfData);    
	}

	public void sortData(int menuNumber, char typeOfData) {
		boolean swapFlag = false;
		int length = getLength();
		
		for ( int i = 0; i < length - 1; i++ ) {  
			for ( int j = 0; j < length - 1 - i; j++ ) {
				swapFlag = decideBetweenAscendingOrderAndDescendingOrder(menuNumber, typeOfData, j);
				
				if ( swapFlag ) {
					swap(typeOfData, j);
				}
			}
		}	
	}

	public boolean decideBetweenAscendingOrderAndDescendingOrder(int menuNumber, char typeOfData, int index) {	
		if ( menuNumber == 2 ) {  
			return compareData(typeOfData, data[index], data[index+1]);			
		}
		
		else if ( menuNumber == 3 ) {   
			return compareData(typeOfData, data[index+1], data[index]);
		}
		
		return false;
	}
	
	public int getLength() {
		return data.length;
	}
	
	public boolean compareData(char typeOfData, Object data1, Object data2) {
		if ( typeOfData == 'c' ) {
			if ( (char)data1 > (char)data2 ) 
				return true;
		}
		
		else if ( typeOfData == 'n' ){
			if ( (int)data1 > (int)data2 ) 
				return true;
		}
		
		return false;
	}	
	
	public void swap(char typeOfData, int index) {
		Object temp = null;
		
		if ( typeOfData == 'c' ) {
			temp = (char)data[index];
		}
		
		else if ( typeOfData == 'n' ){
			temp = (int)data[index];
		}
	
		data[index] = data[index + 1];
		data[index + 1] = temp;
	}
		
	public void printResultOfOrdering(char typeOfData) {
		for ( int i = 0; i<data.length; i++ ) {
			System.out.print(data[i] + " ");
		}
		System.out.print("\n");			
	}

	public Object[] getData() {
		return data;
	}

	public void setData(Object[] data) {
		this.data = data;
	}	
}
