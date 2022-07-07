package indicator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import indicator.Momentum;
import stockdata.Data;
import stockdata.DataList;
import stockdata.Parser;

public class MomentumTest {
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
	public void testMomentum() {
		//improper input
		id = 6;
		dl = buildDataList();
		expected = -1;
		actual = Momentum.calculateMomentum(id, -2, dl);
		Assert.assertEquals(expected, actual, 0.001);
		
		//same day
		id = 6;
		dl = buildDataList();
		expected = 4447.25 - 4447.25;
		actual = Momentum.calculateMomentum(id, 0, dl);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		dl = buildDataList();
		expected = 4447.25 - 4449.5;
		actual = Momentum.calculateMomentum(id, 4, dl);
		Assert.assertEquals(expected, actual, 0.001);
	}
}
