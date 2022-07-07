package indicator;

import stockdata.DataList;

public class Stochastic {
	
	/*
     * id represents last id of set being analyzed
     * To calculate for given date, use Helper.dateToId(String date, DataList dl)
     * to convert date to id
     * 
     * Throws exception for invalid arguments.
     * Returns 0 when id is too low to accommodate selected period (insufficient data points)
     */
	public static double calculateStochastic(int id, int length, DataList dl) {
    	//Check for improper inputs
    	//For nonexistent ids:
    	if (id > dl.getLastId()) throw new IllegalArgumentException("id cannot be > last id in DataList.");
    	//For improper lengths:
    	if (length <= 0) throw new IllegalArgumentException("Length cannot be <= 0.");
    	//For length greater than number of data points:
    	if (length > dl.size()) throw new IllegalArgumentException("Length cannot be > DataList size.");
    	
    	//For length greater than id (insufficient data points)
    	if (id < (length - 1)) return 0; //length - 1 due to indexing beginning at 0
    	
    	//declare variables
    	double lastClose = dl.getClose(id);
    	double[] highArr = dl.getHighArr();
    	double[] lowArr = dl.getLowArr();
    	double high = dl.getHigh(id);
    	double low = dl.getLow(id);
    	double stochastic;

    	//calculations
    	for (int i = id; i > (id - length); i--) {
    		if (highArr[i] > high) {
    			high = highArr[i];
    		}
    		if (lowArr[i] < low) {
    			low = lowArr[i];
    		}
    	}
    	
    	stochastic = ((lastClose - low) / (high - low)) * 100;
    	
    	return stochastic;
    }
}
