package indicator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import indicator.Stochastic;
import stockdata.Data;
import stockdata.DataList;
import stockdata.Parser;

public class StochasticTest {
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
	public void testStochastic() {
		id = 6;
		dl = buildDataList();
		expected = -1;
		actual = Stochastic.calculateStochastic(id, -2, dl);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		dl = buildDataList();
		expected = ((4447.25 - 4445.25) / (4447.75 - 4445.25)) * 100;
		actual = Stochastic.calculateStochastic(id, 2, dl);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		dl = buildDataList();
		expected = ((4447.25 - 4444.0) / (4449.5 - 4444.0) ) * 100;
		actual = Stochastic.calculateStochastic(id, 4, dl);
		Assert.assertEquals(expected, actual, 0.001);
	}

}
