import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class DataControllerTest {	
	private static DataController numberController;
	private static DataController characterController;
	private static Object[] testNumber= { 3, 2, -1, 5, 8 };
	private static Object[] testCharacter= { 'D', 'a', 'c', 'b', 'B' };
	
	@BeforeClass
	public static void SetupBeforeClass() {
		numberController = new DataController(testNumber);
		characterController = new DataController(testCharacter);
	}

	@Test
	public void testNumberAscendingOrder() {
		Object[] ResultOfNumberAscendingOrder = { -1, 2, 3, 5, 8 };
		
		numberController.sortData(2, 'n');
		compareSortedDataAndTestData(numberController, ResultOfNumberAscendingOrder);
	}
	
	@Test
	public void testNumberDescendingOrder() {
		Object[] ResultOfNumberDescendingOrder = { 8, 5, 3, 2, -1 };
		
		numberController.sortData(3, 'n');
		compareSortedDataAndTestData(numberController, ResultOfNumberDescendingOrder);
	}
	
	@Test
	public void testCharacterAscendingOrder() {
		Object[] ResultOfCharacterrAscendingOrder = { 'B', 'D', 'a', 'b', 'c' };
		
		characterController.sortData(2, 'c');
		compareSortedDataAndTestData(characterController, ResultOfCharacterrAscendingOrder);
	}
	
	@Test
	public void testCharacterDescendingOrder() {
		Object[] ResultOfCharacterDescendingOrder = { 'c', 'b', 'a', 'D', 'B' };
		
		characterController.sortData(3, 'c');
		compareSortedDataAndTestData(characterController, ResultOfCharacterDescendingOrder);
		
	}
	
	public void compareSortedDataAndTestData(DataController dataController, Object[] testData) {
		boolean testFlag = true;
		
		for ( int i = 0; i < dataController.getLength(); i++ ) {
			if ( testData[i] != dataController.getData()[i] )
				testFlag = false;
		}
		
		assertTrue(testFlag);
	}
}
