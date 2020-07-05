package com.ds.mix;

/*
 **  Below formation is called Pascals Triangle.
 **
 **  Example:
 **               1
 **              1 1
 **             1 2 1
 **            1 3 3 1
 **           1 4 6 4 1
 **         1 5 10 10 5 1
 **        1 6 15 20 15 6 1
 **
 **  Complete the 'pascal' function below so that given a
 **  col and a row it will return the value in that positon.
 **
 **  Example, pascal(1,2) should return 2
 **
 */

import java.util.HashMap;
import java.util.Map;

public class PascalTriangle {

//	public static Map<Integer, Map<Integer, Integer>> pascalHash 
//	= new HashMap<Integer,Map<Integer,Integer>>();
//
//	public static  int pascal(int col, int row){
//		if(col == 0 || col == row) {
//			return 1;
//		}
//		int pascalValue = 0;
//		if(pascalHash.containsKey(col)){
//			if(pascalHash.get(col).containsKey(row)){
//				return pascalHash.get(col).get(row);
//			}
//			else{
//				pascalValue = pascal(col, row - 1) + pascal(col - 1, row - 1);
//				pascalHash.get(col).put(row,pascalValue);
//			}
//		}
//		else{
//			pascalValue = pascal(col, row - 1) + pascal(col - 1, row - 1);
//			Map<Integer, Integer> rowHashMap = new HashMap<Integer, Integer>();
//			rowHashMap.put(row,pascalValue);
//			pascalHash.put(col,rowHashMap);
//		}
//		return pascalValue;
//	}

	public static void printPascal(int row) { 
		
		for(int line = 1; line <= row; line++) {
			int C = 1;// used to represent C(line, i) 
			for(int i = 1; i <= line; i++) {  
				// The first value in a line is always 1 
				System.out.print(C+" "); 
				if(line == row)
				C = C * (line - i) / i;  
			} 
			System.out.println(); 
		} 
		
	}
	
	public static int getNumberFromPascalRow(int col, int row) {
		//Since col and row start with 0
		col++;row++;
		int C = 1;
		for(int i = 1; i <= row; i++) { 
			if(i == col)
				break;
			
			C = C * (row - i) / i; 
			
		}
	
		return C;
	}

	public static void main(String[] args) {
		printPascal(5);
		if(PascalTriangle.getNumberFromPascalRow(0,0) ==  1 &&
				PascalTriangle.getNumberFromPascalRow(1,2) ==  2 &&
				PascalTriangle.getNumberFromPascalRow(5,6) ==  6 &&
				PascalTriangle.getNumberFromPascalRow(4,8) ==  70 &&
				PascalTriangle.getNumberFromPascalRow(6,6) ==  1) {
			System.out.println("Pass");		  
		}else {
			System.out.println("Failed");
		}
	}
}
