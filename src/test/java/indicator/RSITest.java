package indicator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import indicator.RSI;
import stockdata.Data;
import stockdata.DataList;

public class RSITest {
	int id;
	DataList dl;
	double expected;
	double actual;
	
	
	public DataList buildDataList() {
		DataList datalist = new DataList();
		datalist.addData(new Data("0", 0, 0, 0, 44.34, 0));
		datalist.addData(new Data("0", 0, 0, 0, 44.09, 0));
		datalist.addData(new Data("0", 0, 0, 0, 44.15, 0));
		datalist.addData(new Data("0", 0, 0, 0, 43.61, 0));
		datalist.addData(new Data("0", 0, 0, 0, 44.33, 0));
		datalist.addData(new Data("0", 0, 0, 0, 44.83, 0));
		datalist.addData(new Data("0", 0, 0, 0, 45.10, 0));
		datalist.addData(new Data("0", 0, 0, 0, 45.42, 0));
		datalist.addData(new Data("0", 0, 0, 0, 45.84, 0));
		datalist.addData(new Data("0", 0, 0, 0, 46.08, 0));
		datalist.addData(new Data("0", 0, 0, 0, 45.89, 0));
		datalist.addData(new Data("0", 0, 0, 0, 46.03, 0));
		datalist.addData(new Data("0", 0, 0, 0, 45.61, 0));
		datalist.addData(new Data("0", 0, 0, 0, 46.28, 0));
		datalist.addData(new Data("0", 0, 0, 0, 46.28, 0));
		datalist.addData(new Data("0", 0, 0, 0, 46.00, 0));
		datalist.addData(new Data("0", 0, 0, 0, 46.03, 0));
		datalist.addData(new Data("0", 0, 0, 0, 46.41, 0));
		datalist.addData(new Data("0", 0, 0, 0, 46.22, 0));
		datalist.addData(new Data("0", 0, 0, 0, 45.64, 0));
		return datalist;
	}
	
	@Test
	public void test() {
		id = 14;
		dl = buildDataList();
		expected = 70.53;
		actual = RSI.calculateRSI(id, 14, dl);
		Assert.assertEquals(expected, actual, 0.1);
	}

}
