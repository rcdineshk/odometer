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
		this.maxReading = Integer.parseInt("0123456789".substring(10 - numOfDigits));
		this.reading = minReading;
	}
	public Odometer (int numOfDigits, int startState){
		if(numOfDigits > 10){
			this.numOfDigits = 10;
		}
		else{
			this.numOfDigits = numOfDigits;
			
		}
		this.minReading = Integer.parseInt("0123456789".substring(0, numOfDigits));
		this.maxReading = Integer.parseInt("0123456789".substring(10 - numOfDigits));
		if(startState >= minReading && startState <= maxReading  && checkSequence(startState)){
				this.reading = startState;
			}
		else{
			this.reading = minReading;
		}
	}
	public String getOdometerReading(){
		String result = Integer.toString(reading);
		if(result.length() < numOfDigits){
			result = "0" + result;
		}
		return result;
	}
	public boolean checkSequence(int read)
	{
		String read_string = Integer.toString(read);
		for(int i = 0 ; i < Integer.toString(read).length() - 1 ; i++){
		   	if(read_string.charAt(i+1) <= read_string.charAt(i))
		   	{
		   		return false;
		   	}
		}
		return true;
	}
	public void increment(int n)
	{
		int read = reading;
		for(int i = 0; i < n; i++){
			while(true){
				read++;
				if(Integer.toString(read).length() > numOfDigits){
					read = minReading;
				}
				if(checkSequence(read)){
					break;
				}
			}
		}
		reading = read;
	}
	public static void main(String[] args){
		Odometer obj = new Odometer(4,1234);
		obj.increment(4);
		System.out.println(obj.getOdometerReading());
	}
}
