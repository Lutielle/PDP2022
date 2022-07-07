package stockdata;

import java.io.*;
import java.util.*;
import java.lang.Math;

import indicator.*;

public class Parser {
    public static void main(String[] args)
    {
    	String inputFile = "C:\\Users\\Kai\\Documents\\Work\\ES5m.txt";
    	String outputFile = "C:\\Users\\Kai\\Documents\\Work\\ES5m-sma.txt";
    	
    	//Currently unused; can be adjusted for use with readSubset();
    	String readStart = "2022-03-22T23:50";
    	String readEnd = "2022-03-23T03:00";
    	
    	List<String> lineList = readFile(inputFile);
    	
    	DataList dataList = DataList.buildDataList(lineList);
    	
    	StringBuilder builder = new StringBuilder();
    	builder.append("date,open,high,low,close,volume,sma200,sma180,stoch100,rsi60,momentum20,futurechange48,direction");
    	builder.append("\n");
    	for (int i = 0; i < dataList.size(); i++) {
    		builder.append(dataList.getData(i));
    		builder.append(",");
    		builder.append(SMA.calculateSMA(i, 200, dataList));
    		builder.append(",");
    		builder.append(SMA.calculateSMA(i, 180, dataList));
    		//System.out.println(i);
    		builder.append(",");
    		builder.append(Helper.roundToTwo(Stochastic.calculateStochastic(i, 100, dataList)));
    		builder.append(",");
    		builder.append(Helper.roundToTwo(RSI.calculateRSI(i, 60, dataList)));
    		builder.append(",");
    		builder.append(Momentum.calculateMomentum(i, 20, dataList));
    		builder.append(",");
    		builder.append(Helper.roundToFour(FutureChange.calculateFutureChange(i, 48, dataList)));
    		builder.append(",");
    		builder.append(FutureChange.changeDirection(i, 48, dataList));
    		builder.append("\n");
    	}
    	
    	saveToFile(outputFile, builder.toString(), false);
    }
    
    public static List<String> readFile(String rFilename) {
    	String line;
		List<String> rTextList = new ArrayList<String>();
		
		try {
			FileReader rFileReader = new FileReader(rFilename);
			BufferedReader rBuffer = new BufferedReader(rFileReader);
			while ((line = rBuffer.readLine()) != null) {
				rTextList.add(line);
			}
			
			rBuffer.close();
			rFileReader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			//throw new TRLException("The system cannot find the file specified: " + rFilename);
		}
		return rTextList;
	}
    
    public static List<String> readSubset(String rFilename, String startTime, String endTime) {
    	int readFlag = 0;
    	String line;
		List<String> rTextList = new ArrayList<String>();
		
		try {
			FileReader rFileReader = new FileReader(rFilename);
			BufferedReader rBuffer = new BufferedReader(rFileReader);
			
			//For the header
			line = rBuffer.readLine();
			rTextList.add(line);
			
			while ((line = rBuffer.readLine()) != null) {
				//Parse each line on comma into a string array
				String[] parts = line.split(",");
				//System.out.println(parts[0]);
				
				//Check for startTime; once found, set flag
				if (parts[0].equals(startTime)) {
				  readFlag = 1;
				}
				//Check for endTime; once found, set flag
				if (parts[0].equals(endTime)) {
				  readFlag = 0;
				}
				//Add line if flagged
				if (readFlag == 1) {
				  rTextList.add(line);
				}
			}
			rBuffer.close();
			rFileReader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			//throw new TRLException("The system cannot find the file specified: " + rFilename);
		}
		
		return rTextList;
    }
    
    public static void saveToFile(String sFilename, String sText, boolean sAppend) {
		try {
			FileWriter f = new FileWriter(sFilename, sAppend);
			BufferedWriter sBuffer = new BufferedWriter(f);
			sBuffer.write(sText);
			sBuffer.close();
			f.close();
			System.out.println("Saved to file " + sFilename);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
