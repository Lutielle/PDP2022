package stockdata;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Helper {
	public int dateToId(String date, DataList dl) {
		String[] dateArr = dl.getDateArr();
		int id = 0;
		
		for (int i = 0; i < dateArr.length; i++) {
			if (dateArr[i].equals(date)) {
				id = i;
				break;
			}
		}
		
		return id;
	}
	
	public static double roundToTwo(double input) {
		BigDecimal bd = new BigDecimal(Double.toString(input));
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public static double roundToFour(double input) {
		BigDecimal bd = new BigDecimal(Double.toString(input));
	    bd = bd.setScale(4, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	//Testing github upload!
}