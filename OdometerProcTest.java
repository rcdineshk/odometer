import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class OdometerProcTest {
	int size;
	int lowest;
	int highest;
	int current;
	Odometer odometer = new Odometer();
	
	@Before
	public void setUp() throws IOException {

		String line;
		int count=0;
		BufferedReader reader = new BufferedReader(new FileReader("testInputFive"));
		while((line = reader.readLine()) !=null)
		{
			if(count==0)
			{
				size = Integer.parseInt(line);
			}
			else if(count==1)
			{
				lowest = Integer.parseInt(line);
			}
			else if(count==2)
			{
				highest = Integer.parseInt(line);
			}         
			else
			{
				current = Integer.parseInt(line);
			}
			count++;
		}
	}

	@Test
	public void testHighest() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("testCasesGetHighest.txt"));
		String line;
		int size;
		String result;
		String desiredResult;
		while((line = reader.readLine())!=null)
		{
			size = Integer.parseInt(line.split(" ")[0]);
			result = odometer.getHighestState(size);
			desiredResult = line.split(" ")[1];
			
			assertEquals("getHighest"+size,desiredResult.trim(),result.trim());
		}
	}

	@Test
	public void testNextNum() throws IOException{
		String line;
		int count=0;
		int num;
		int size=0;
		String firstNum;
		String desiredResult;
		String result;
		
		BufferedReader reader = new BufferedReader(new FileReader("testCasesGetNextState_9.txt"));
		while((line = reader.readLine())!=null)
		{
			if(count==0)
			{
				size = Integer.parseInt(line.trim());
			}
			else
			{
				firstNum = line.split(" ")[0].trim();
				desiredResult = line.split(" ")[1].trim();
				
				result = odometer.getNextState(firstNum, size);
				assertEquals("getNextState"+size,desiredResult.trim(),result.trim());
			}	
			count++;
			
		}
		
	}

	
	@Test
	public void testisAscending() throws IOException{
		String line;
		int count=0;
		int num;
		String desiredResult;
		
		BufferedReader reader = new BufferedReader(new FileReader("testCasesIsAscending_4.txt"));
		while((line = reader.readLine())!=null)
		{
			if (count==0)
			{
				Integer.valueOf(line.trim());
			}
			else
			{
				num = Integer.parseInt(line.split(" ")[0]);
				desiredResult = line.split(" ")[1];
				boolean result = odometer.isAscending(num);
				
				assertEquals("isAscending "+line.split(" ")[0],desiredResult.trim(),String.valueOf(result).trim());
			}
			count++;
		}
	
		
	}
	
	
}
