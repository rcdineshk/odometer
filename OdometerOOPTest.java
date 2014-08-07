import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class OdometerOOPTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	Odometer odometer = new Odometer(4);
	@Test
	public void getLowestTest() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("testCasegetLowest.txt"));
		String line = null;
		int[] inputforgetLowest = new int[10];
		int[] expectedOutputgetLowest = new int[10];
		String[] valuesFromFile;
		int counter = 0;
		
		while((line = reader.readLine()) != null) {
			valuesFromFile = line.split(" ");
			inputforgetLowest[counter] = Integer.parseInt(valuesFromFile[0]);
			expectedOutputgetLowest[counter] = Integer.parseInt(valuesFromFile[1]);
			counter ++;
		}
		
		reader.close();
		int outputFromgetLowest = 0;
		
		for(int i = 0; i < counter; i ++) {
			odometer.numOfDigits = inputforgetLowest[i];
			outputFromgetLowest = odometer.getLowest();
			assertEquals("The function getLowest fails for the input "+ inputforgetLowest[i], expectedOutputgetLowest[i], outputFromgetLowest);
		}
	}
	
	
	@Test
	public void getHighestTest() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("testCasegetHighesttxt"));
		String line = null;
		int[] inputforgetH = new int[10];
		int[] expectedOutputgetH = new int[10];
		String[] valuesFromFile;
		int counter = 0;
		
		while((line = reader.readLine()) != null) {
			valuesFromFile = line.split(" ");
			inputforgetH[counter] = Integer.parseInt(valuesFromFile[0]);
			expectedOutputgetH[counter] = Integer.parseInt(valuesFromFile[1]);
			counter ++;
		}
		
		reader.close();
		int outputFromgetH = 0;
		
		for(int i = 0; i < counter; i ++) {
			odometer.numOfDigits = inputforgetH[i];
			outputFromgetH = odometer.getHighest();
			assertEquals("The function get Highest fails for the input "+ inputforgetH[i], expectedOutputgetH[i], outputFromgetH);
		}
	}
	@Test
	public void checkSequenceTest() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("testCasecheckSequence"));
		String line = null;
		int[] inputforcheckSequence = new int[10];
		boolean[] expectedOutputcheckSequence = new boolean[10];
		String[] valuesFromFile;
		int counter = 0;
		
		/*String line1 = reader.readLine();
		int numDigits = Integer.parseInt(line1);*/
		
		while((line = reader.readLine()) != null) {
			valuesFromFile = line.split(" ");
			inputforcheckSequence[counter] = Integer.parseInt(valuesFromFile[0]);
			expectedOutputcheckSequence[counter] = Boolean.parseBoolean(valuesFromFile[1]);
			counter ++;
		}
		
		reader.close();
		boolean outputFromcheckSequence;
		
		for(int i = 0; i < counter; i ++) {
			//call the function getNext using the object
			outputFromcheckSequence = odometer.checkSequence(inputforcheckSequence[i]);
			assertEquals("The function checkSequence fails for the input "+ inputforcheckSequence[i], expectedOutputcheckSequence[i], outputFromcheckSequence);
		}
	}
	
	@Test
	public void getNextTest() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("testCasegetNext.txt"));
		String line = null;
		int[] inputforgetNext = new int[10];
		int[] expectedOutputgetNext = new int[10];
		String[] valuesFromFile;
		int counter = 0;
		
		while((line = reader.readLine()) != null) {
			valuesFromFile = line.split(" ");
			inputforgetNext[counter] = Integer.parseInt(valuesFromFile[0]);
			expectedOutputgetNext[counter] = Integer.parseInt(valuesFromFile[1]);
			counter ++;
		}
		
		reader.close();
		int outputFromgetNext = 0;
		
		for(int i = 0; i < counter; i ++) {
			odometer.reading = inputforgetNext[i];
			outputFromgetNext = Integer.parseInt(odometer.getNext());
			assertEquals("The function getNext fails for the input "+ inputforgetNext[i], expectedOutputgetNext[i], outputFromgetNext);
		}
	}
	
	
	@Test
	public void getnthIncrementTest() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("testCasegetnthIncrement.txt"));
		String line = null;
		int[] inputfornthInc = new int[10];
		String[] expectedOutputnthInc = new String[10];
		String[] valuesFromFile;
		int counter = 0;
		
		/*String line1 = reader.readLine();
		int numDigits = Integer.parseInt(line1);*/
		
		while((line = reader.readLine()) != null) {
			valuesFromFile = line.split(" ");
			inputfornthInc[counter] = Integer.parseInt(valuesFromFile[0]);
			expectedOutputnthInc[counter] = valuesFromFile[1];
			counter ++;
		}
		
		reader.close();
		String outputFromnthInc;
		
		for(int i = 0; i < counter; i ++) {
			Odometer o = new Odometer(4);
			outputFromnthInc = o.getNthIncrement(inputfornthInc[i]);
			assertEquals("The function nth increment fails for the input "+ inputfornthInc[i], expectedOutputnthInc[i], outputFromnthInc.toString());
		}
	}
	

}
