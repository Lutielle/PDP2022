package indicator;

import stockdata.DataList;

public class RSI {
	
	/*
     * id represents last id of set being analyzed
     * To calculate for given date, use Helper.dateToId(String date, DataList dl)
     * to convert date to id
     * 
     * Returns -1 as an error value.
     */
    public static double calculateRSI(int id, int length, DataList dl) {	
		//Check for improper inputs
		//For nonexistent ids:
		if (id > dl.getLastId()) return 0;
		//For improper lengths:
		if (length <= 0) return 0;
		//For length greater than number of data points:
		if (length > dl.size()) return 0;
		
		//For length greater than id
		//NOTE: Not used due to revisions in counting up.
		if (id < length) return 0;
		
		//declare variables
		double change;
		double gain = 0;
		double loss = 0;
		double avgGain = 0;
		double avgLoss = 0;
		double rs;
		double rsi;
		
		//int gaincount = 0;
		//int losscount = 0;
		
		int startId = id - length + 1;
		int endId = id;
		
		//calculations
		for (int i = startId; i <= endId; i++) {
			change = dl.getClose(i) - dl.getClose(i - 1); //(i-1) yields index -1, out of bounds
			//System.out.println(change);
			if (change > 0) {
				gain += change;
				//gaincount++;
			}
			else if (change < 0) {
				loss += -change;
				//losscount++;
			}
			else continue;
		}
		
		//System.out.println();
		
		//System.out.println(gain);
		//System.out.println(loss);
		//System.out.println();
		
		avgGain = gain / length;
		avgLoss = loss / length;
		
		//System.out.println(avgGain);
		//System.out.println(avgLoss);
		
		//System.out.println();
		
		rs = avgGain / avgLoss;
		rsi = 100 - (100 / (1 + rs));
		
		//System.out.println(gaincount);
		//System.out.println(losscount);
		
		return rsi;
    }
}