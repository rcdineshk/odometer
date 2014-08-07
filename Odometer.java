package odometer;

public class Odometer{
	
	private int reading;
	private int numOfDigits;
	
	public Odometer(int numOfDigits){
		if(numOfDigits >10){
			this.numOfDigits = 10;
		}
		else{
			this.numOfDigits = numOfDigits;
		}
		this.reading = getLowest();
	}
	public Odometer (int numOfDigits, int startState){
		if(numOfDigits > 10){
			this.numOfDigits = 10;
			this.reading = getLowest();
		}
		else{
			this.numOfDigits = numOfDigits;
			if(startState >= getLowest() && startState <= getHighest()  && checkSequence(startState)){
				this.reading = startState;
			}
			else{
				this.reading = getLowest();
			}
		}
	}
	
	public int getLowest(){
		String lowestNumSequence = "0123456789";
		return Integer.parseInt(lowestNumSequence.substring(0, numOfDigits));
	}
	
	public int getHighest(){
		String lowestNumSequence = "0123456789";
		return Integer.parseInt(lowestNumSequence.substring(10 - numOfDigits,10));
	}
	
	public String getOdometerReading(){
		String result = Integer.toString(reading);
		if(result.length() < numOfDigits){
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
			if(Integer.toString(read).length() > numOfDigits)
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
	
	public static void main(String[] args){
		Odometer obj = new Odometer(4,4567);
		System.out.println(obj.getNext());
		System.out.println(obj.getNthIncrement(5));
	}

}
