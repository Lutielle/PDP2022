package stockdata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import stockdata.DataList;
import stockdata.Parser;

public class ParserTest {
	private DataList dataList;
	private double[] closeArr;
	
	int id;
	double expected;
	double actual;
	
	/*
	@Before
	public void init() {
		dataList = Parser.buildDataList(Parser.readFile("C:\\Users\\Kai\\Documents\\Work\\ES5m.txt"));
		closeArr = dataList.getCloseArr();
	}
	
	
	@Test
	public void testSMA() {
		id = 6;
		expected = (4447.25 + 4446.75 + 4447.0 + 4446.75 + 4449.5) / 5.0;
		actual = Parser.calculateSMA(id, 5, dataList);
		Assert.assertEquals(expected, actual, 0.001);
		
		//This test yields a failure.
		//id = 6;
		//expected = (4447.25 + 4446.75 + 4447.0 + 4446.75 + 4449.5) / 4.0;
		//actual = Parser.calculateSMA(id, dataList);
		//Assert.assertEquals(expected, actual, 0.001);
		
		id = 2;
		expected = 0.0;
		actual = Parser.calculateSMA(id, 5, dataList);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		expected = (4447.25 + 4446.75 + 4447.0 + 4446.75) / 4.0;
		actual = Parser.calculateSMA(id, 4, dataList);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		expected = (4447.25 + 4446.75) / 2.0;
		actual = Parser.calculateSMA(id, 2, dataList);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		expected = -1;
		actual = Parser.calculateSMA(id, -2, dataList);
		Assert.assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void testStochastic() {
		id = 6;
		expected = -1;
		actual = Parser.calculateStochastic(id, -2, dataList);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		expected = ((4447.25 - 4445.25) / (4447.75 - 4445.25)) * 100;
		actual = Parser.calculateStochastic(id, 2, dataList);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		expected = ((4447.25 - 4444.0) / (4449.5 - 4444.0) ) * 100;
		actual = Parser.calculateStochastic(id, 4, dataList);
		Assert.assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void testMomentum() {
		//improper input
		id = 6;
		expected = -1;
		actual = Parser.calculateMomentum(id, -2, dataList);
		Assert.assertEquals(expected, actual, 0.001);
		
		//same day
		id = 6;
		expected = 4447.25 - 4447.25;
		actual = Parser.calculateMomentum(id, 0, dataList);
		Assert.assertEquals(expected, actual, 0.001);
		
		id = 6;
		expected = 4447.25 - 4449.5;
		actual = Parser.calculateMomentum(id, 4, dataList);
		Assert.assertEquals(expected, actual, 0.001);
	}
	*/
}
