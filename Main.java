public class Main {

	public static void main(String[] args) {
		printHyeminInformation();
		startMenu();
	}

	public static void printHyeminInformation() {
		Student hyemin = new Student();
		
		hyemin.setName("YOON HYE MIN");
		hyemin.setId(1316081);
		hyemin.printStudentInformation();
	}
	
	public static void startMenu() {
		MainController mainController = new MainController();	
		mainController.startMenu();	
	}
}
