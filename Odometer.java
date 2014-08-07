package odometer;

public class Odometer{
	
	int reading;
	int noOfDigits;
	
	public Odometer(int noOfDigits){
		this.noOfDigits = noOfDigits;
		reading = getLowest();
	}
	public Odometer (int noOfDigits, int startState){
		this.noOfDigits = noOfDigits;
		if(isAscending(startState) && startState >= getLowest() && startState <= getHighest()){
			reading = startState;
		}
		else{
			reading = getLowest();
		}
	}
	
	public int getLowest(){
		String lowestNumSequence = "0123456789";
		return Integer.parseInt(lowestNumSequence.substring(0, noOfDigits));
	}
	
	public int getHighest(){
		String lowestNumSequence = "0123456789";
		return Integer.parseInt(lowestNumSequence.substring(10 - noOfDigits,10));
	}
	
	public String getOdometerReading(){
		String result = Integer.toString(reading);
		if(result.length() < noOfDigits){
			result = "0" + result;
		}
		return result;
	}
	
	public boolean isAscending(int reading){
		return true;
	}

}
