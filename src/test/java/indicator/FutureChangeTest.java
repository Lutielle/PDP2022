package indicator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import indicator.FutureChange;
import stockdata.Data;
import stockdata.DataList;
import stockdata.Parser;

public class FutureChangeTest {
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
	public void testFutureChange() {
		//improper input
		id = 6;
		dl = buildDataList();
		expected = -1;
		actual = FutureChange.calculateFutureChange(id, -2, dl);
		Assert.assertEquals(expected, actual, 0.001);
		
		//same day
		id = 6;
		dl = buildDataList();
		expected = -1;
		actual = FutureChange.calculateFutureChange(id, 0, dl);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		dl = buildDataList();
		expected = ((4449.0 - 4447.25) / 4447.25) * 100;
		actual = FutureChange.calculateFutureChange(id, 4, dl);
		Assert.assertEquals(expected, actual, 0.001);
	}
}
