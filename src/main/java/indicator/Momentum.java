package indicator;

import stockdata.DataList;

public class Momentum {
	
	/*
     * id represents last id of set being analyzed
     * To calculate for given date, use Helper.dateToId(String date, DataList dl)
     * to convert date to id
     * 
     * Throws exception for invalid arguments.
     * Returns 0 when id is too low to accommodate selected period (insufficient data points)
     */
	public static double calculateMomentum(int id, int length, DataList dl) {
    	//Check for improper inputs
    	//For nonexistent ids:
    	if (id > dl.getLastId()) throw new IllegalArgumentException("id cannot be > last id in DataList.");
    	//For improper lengths:
    	//NOTE: Momentum specifically allows for lengths of 0 (compares same day)
    	if (length < 0) throw new IllegalArgumentException("Length cannot be < 0.");
    	//For length greater than number of data points:
    	if (length > dl.size()) throw new IllegalArgumentException("Length cannot be > DataList size.");
    	
    	//For length greater than id
    	//NOTE: Momentum requires id >= length
    	//if (id < (length - 1)) return 0; //length - 1 due to indexing beginning at 0
    	if (id < length) return 0;
    	
    	//declare variables
    	double curClose;
    	double targetClose;
    	
    	//calculations
    	curClose = dl.getClose(id);
    	targetClose = dl.getClose(id - length);
    	
    	return (curClose - targetClose);
    }
}
