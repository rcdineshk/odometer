package odometer;

public class Odometer{
	
	private int reading;
	private int numOfDigits;
	private int minReading;
	private int maxReading;
	
	public Odometer(int numOfDigits){
		if(numOfDigits >10){
			this.numOfDigits = 10;
		}
		else{
			this.numOfDigits = numOfDigits;
		}
		this.minReading = Integer.parseInt("0123456789".substring(0, numOfDigits));
		this.maxReading = Integer.parseInt("0123456789".substring(10 - numOfDigits,10));
		this.reading = minReading;
	}
	public Odometer (int numOfDigits, int startState){
		if(numOfDigits > 10){
			this.numOfDigits = 10;
			this.minReading = Integer.parseInt("0123456789".substring(0, numOfDigits));
			this.maxReading = Integer.parseInt("0123456789".substring(10 - numOfDigits,10));
			this.reading = minReading;
		}
		else{
			this.numOfDigits = numOfDigits;
			this.minReading = Integer.parseInt("0123456789".substring(0, numOfDigits));
			this.maxReading = Integer.parseInt("0123456789".substring(10 - numOfDigits,10));
			if(startState >= minReading && startState <= maxReading  && checkSequence(startState)){
				this.reading = startState;
			}
			else{
				this.reading = minReading;
			}
		}
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
		   	if(read_string.charAt(i+1) <= read_string.charAt(i))
		   	{
		   		return false;
		   	}
		}
		return true;
	}
	public String increment(int n)
	{
		int read = reading;
		for(int i = 0; i < n; i++){
			while(true)
			{
				read++;
				if(Integer.toString(read).length() > numOfDigits)
				{
					read = minReading;
				}
				if(checkSequence(read))
				{
					break;
				}
			}
		}
		reading = read;
		return getOdometerReading();
	}
	public static void main(String[] args){
		Odometer obj = new Odometer(4,2468);
		System.out.println(obj.increment(2));
	}
}
