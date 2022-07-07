package stockdata;

public class Data {
	private int id;
	private String date; //Date object is deprecated; for now, I'll encode as a String and adjust later as needed
	//open high low close
	private double open;
	private double high;
	private double low;
	private double close;
	private int volume;
	
	//empty constructor
	public Data() {
	}
	
	public Data(String d, double o, double h, double l, double c, int v) {
		//id should be set under the add function
		date = d;
		open = o;
		high = h;
		low = l;
		close = c;
		volume = v;
	}

	
	public static Data buildData(String[] input) {
    	String date = input[0];
    	double open = Double.parseDouble(input[1]); 
    	double high = Double.parseDouble(input[2]);
    	double low = Double.parseDouble(input[3]);
    	double close = Double.parseDouble(input[4]);
    	int volume = Integer.parseInt(input[5]);
    	
    	return new Data(date, open, high, low, close, volume);
    }
    
	
	//get functions
	public int getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public double getOpen() {
		return open;
	}
	public double getHigh() {
		return high;
	}
	public double getLow() {
		return low;
	}
	public double getClose() {
		return close;
	}
	public int getVolume() {
		return volume;
	}
	
	
	//set functions
	public void setId(int _id) {
		id = _id;
	}
	public void setDate(String d) {
		date = d;
	}
	public void setOpen(double o) {
		open = o;
	}
	public void setHigh(double h) {
		high = h;
	}
	public void setLow(double l) {
		low = l;
	}
	public void setClose(double c) {
		close = c;
	}
	public void setVolume(int v) {
		volume = v;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getDate() + ",");
		sb.append(getOpen() + ",");
		sb.append(getHigh() + ",");
		sb.append(getLow() + ",");
		sb.append(getClose() + ",");
		sb.append(getVolume());
		
		/*
		sb.append(getId() + ", " + getDate() + ": ");
		sb.append("open = " + getOpen() + ", ");
		sb.append("high = " + getHigh() + ", ");
		sb.append("low = " + getLow() + ", ");
		sb.append("close = " + getClose());
		*/

		return sb.toString();
	}
	
	public void printData() {
		System.out.println(toString());
	}
}