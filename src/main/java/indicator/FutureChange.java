package indicator;

import stockdata.DataList;

public class FutureChange {
	
	/*
     * id represents last id of set being analyzed
     * To calculate for given date, use Helper.dateToId(String date, DataList dl)
     * to convert date to id
     * 
     * Throws exception for invalid arguments.
     * Returns 0 when id is too low to accommodate selected period (insufficient data points)
     */
	public static double calculateFutureChange(int id, int length, DataList dl) {
    	//Check for improper inputs
    	//For nonexistent ids:
    	if (id > dl.getLastId()) throw new IllegalArgumentException("id cannot be > last id in DataList.");
    	//For improper lengths:
    	if (length <= 0) throw new IllegalArgumentException("Length cannot be <= 0.");
    	//For length greater than number of data points:
    	if (length > dl.size()) throw new IllegalArgumentException("Length cannot be > DataList size.");
    	
    	//For id + length out of bounds (endId out of bounds)
    	if ((id + length) > dl.getLastId()) return 0;
    	
    	//declare variables
    	double curClose;
    	double futureClose;
    	
    	//calculations
    	curClose = dl.getClose(id); //startId
    	futureClose = dl.getClose(id + length); //endId
    	
    	return (((futureClose - curClose) / curClose) * 100);
	}
	
	public static int changeDirection(int id, int length, DataList dl) {
		double fc = calculateFutureChange(id, length, dl);
		
		if (fc > 0) return 1;
		else if (fc < 0) return 0;
		
		return (int)fc;
	}
}
