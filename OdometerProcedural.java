import java.util.*;
public class OdometerProcedural {
	
	public static String initializeOdometer(Integer numOfDigits){
		String digitsinAscending = "0123456789";
		String initialState = digitsinAscending.substring(0, numOfDigits);
		return initialState;
		
	}
	
	public static String getHighestState(Integer numDigits){
		String descending = "0123456789";
		return descending.substring(10 - numDigits , 10);
		
	}
	
	public static String getNextState(String currentState, Integer numOfDigits){
		
		ArrayList<Integer> str2Digits = new ArrayList<Integer>();
		String nextState = currentState;
		Integer current = Integer.parseInt(currentState);
		int nextElement = current;
	
		while(nextElement >= current){
			if(nextElement== Integer.parseInt((getHighestState(numOfDigits)))){
				nextElement = Integer.parseInt(initializeOdometer(numOfDigits));
			}
			else{
				nextElement ++;
			}
			if(isAscending(Integer.toString(nextElement))){
				String next = Integer.toString(nextElement);
				if(next.length() == numOfDigits -1)
				{
					next = "0" + next;
				}
				return next;
			}
		}
		
		return "";
	}
	
	public static boolean isAscending(String nextElement){
		List<Integer> digits = new ArrayList<Integer>();
		
		for(int i = 0; i< nextElement.length(); i++){
			digits.add(Character.getNumericValue(nextElement.charAt(i)));
		}
		
		Collections.sort(digits);
		for(int i = 0; i<digits.size() -1; i++){
			if(digits.get(i) == digits.get(i+1)){
				return false;
			}
		}
		String sortedDigits = digits.toString();
		sortedDigits = sortedDigits.replaceAll("[,\\[\\]\\s]","");
		
		if(sortedDigits.equals(nextElement)){
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
	
		String currentState;
		String initialState; 
		Integer numOfDigits = 5;
		if(numOfDigits > 10){
			System.out.println("Invalid number of Digits provided");
			System.exit(0);
		}
		
		initialState = initializeOdometer( numOfDigits);
		currentState = initialState;
		currentState = getNextState(currentState, numOfDigits);
		System.out.println(currentState);
	}

}
