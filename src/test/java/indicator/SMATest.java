package indicator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import indicator.SMA;
import stockdata.Data;
import stockdata.DataList;
import stockdata.Parser;

public class SMATest {
	int id;
	DataList dl;
	double expected;
	double actual;
	
	
	public DataList buildDataList() {
		String inputFile = "C:\\Users\\Kai\\Documents\\Work\\ES5m.txt";
		List<String> lineList = Parser.readFile(inputFile);
		DataList dataList = DataList.buildDataList(lineList);
		
		return dataList;
	}
	
	@Test
	public void testSMA() {
		id = 6;
		dl = buildDataList();
		expected = (4447.25 + 4446.75 + 4447.0 + 4446.75 + 4449.5) / 5.0;
		actual = SMA.calculateSMA(id, 5, dl);
		Assert.assertEquals(expected, actual, 0.001);
		
		/* This test yields a failure.
		id = 6;
		expected = (4447.25 + 4446.75 + 4447.0 + 4446.75 + 4449.5) / 4.0;
		actual = SMA.calculateSMA(id, dataList);
		Assert.assertEquals(expected, actual, 0.001);
		*/
		
		id = 2;
		dl = buildDataList();
		expected = 0.0;
		actual = SMA.calculateSMA(id, 5, dl);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		dl = buildDataList();
		expected = (4447.25 + 4446.75 + 4447.0 + 4446.75) / 4.0;
		actual = SMA.calculateSMA(id, 4, dl);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		dl = buildDataList();
		expected = (4447.25 + 4446.75) / 2.0;
		actual = SMA.calculateSMA(id, 2, dl);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		dl = buildDataList();
		expected = -1;
		try {
			actual = SMA.calculateSMA(id, -2, dl);
		}
		catch (IllegalArgumentException e) {
			//System.out.println(e.getMessage());
			Assert.assertEquals("Length cannot be <= 0.", e.getMessage());
		}
		//Assert.assertEquals(expected, actual, 0.001);
	}

}
