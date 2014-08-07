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
		if(startState >= getLowest() && startState <= getHighest()  && checkSequence(startState)){
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
	
	public static boolean checkSequence(int read)
	{
		String read_string = Integer.toString(read);
		for(int i = 0 ; i < Integer.toString(read).length() - 1 ; i++)
		{
		   	if(read_string.charAt(i+1) - read_string.charAt(i) <= 0)
		   	{
		   		return false;
		   	}
		}
		return true;
	}
	
	public String getNext()
	{
		int read = reading;
		while(true)
		{
			read++;
			if(Integer.toString(read).length() > noOfDigits)
			{
				read = getLowest();
			}
			if(checkSequence(read))
			{
				reading = read;
				break;
			}
		}
		return getOdometerReading();
	}
	
	public String getNthIncrement(int n)
	{
		for(int i = 0;i < n;i++){
			getNext();
		}
		return getOdometerReading();
	}
	
}
