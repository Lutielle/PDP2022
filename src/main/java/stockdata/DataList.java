package stockdata;

import java.util.*;

public class DataList {
	private String[] dateArr; 
	private double[] openArr;
	private double[] highArr;
	private double[] lowArr;
	private double[] closeArr;
	private int[] volumeArr;
	
	private List<Data> dataList = new ArrayList<Data>();
	
	//constructor?
	public DataList() {
	}
	
	
    public static DataList buildDataList(List<String> lineList) {
    	DataList dataList = new DataList();
    	String line;
    	
    	for (int i = 1; i < lineList.size(); i++) {
    		line = lineList.get(i);
    		String[] parts = line.split(",");
    		//Data data = buildData(parts);
    		Data data = Data.buildData(parts);
    		dataList.addData(data);
    	}
    	
    	return dataList;
    }
	
	
	//standard functions
	public int size() {
		return dataList.size();
	}
	public boolean isEmpty() {
		return dataList.isEmpty();
	}
	public int getLastId() {
		return (size() - 1);
	}
	
	//get functions - single object
	public Data getData(int id) {
		return dataList.get(id);
	}
	public String getDate(int id) {
		return getData(id).getDate();
	}
	public double getOpen(int id) {
		return getData(id).getOpen();
	}
	public double getHigh(int id) {
		return getData(id).getHigh();
	}
	public double getLow(int id) {
		return getData(id).getLow();
	}
	public double getClose(int id) {
		return getData(id).getClose();
	}
	public int getVolume(int id) {
		return getData(id).getVolume();
	}
	
	//get functions - arrays and lists
	public List<Data> getDataList() {
		return dataList;
	}
	//NTS: in reference Data.java these all if check for null
	public String[] getDateArr() {
		return dateArr;
	}
	public double[] getOpenArr() {
		return openArr;
	}
	public double[] getHighArr() {
		highArr = new double[size()];
		for (int i = 0; i < size(); i++) {
			highArr[i] = getHigh(i);
		}
		return highArr;
	}
	public double[] getLowArr() {
		lowArr = new double[size()];
		for (int i = 0; i < size(); i++) {
			lowArr[i] = getLow(i);
		}
		return lowArr;
	}
	public double[] getCloseArr() {
		//return closeArr;
		closeArr = new double[size()];
		for (int i = 0; i < size(); i++) {
			closeArr[i] = getClose(i);
		}
		return closeArr;
	}
	public int[] getVolumeArr() {
		return volumeArr;
	}
	
	//add function
	public void addData(Data newData) {
		int id = dataList.size();
		newData.setId(id);
		dataList.add(newData);
		
		//TODO: update subdata array?
	}
	
	/*
	public void printData(int id) {
		System.out.println(dataList.get(id).toString());
	}
	*/
	
	public void printDataList() {
		for (int i = 0; i < size(); i++) {
			System.out.println(dataList.get(i).toString());
		}
	}
	
	
} 