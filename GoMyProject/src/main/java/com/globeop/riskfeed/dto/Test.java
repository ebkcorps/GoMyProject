package com.globeop.riskfeed.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.globeop.riskfeed.entity.BillTable;

public class Test {

	private List<String> columns= new ArrayList<String>();
	private List<TestDto> data= new ArrayList<TestDto>();
	
	//private List<Object> data=null;
	
	
	
	public Test() {

	}

	public Test(List<String> columns, List<TestDto> data) {
		this.columns = columns;
		this.data = data;
	}
	
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	public List<TestDto> getData() {
		return data;
	}
	public void setData(List<TestDto> data) {
		this.data = data;
	}
	

	/*
	 * public void addtoDataList(Object obj) { if(data==null) { data = new
	 * ArrayList<Object>(); } this.data.add(obj); }
	 */


	@Override
	public String toString() {
		return "Test [columns=" + columns + ", data=" + data + "]";
	}
	
	
}
