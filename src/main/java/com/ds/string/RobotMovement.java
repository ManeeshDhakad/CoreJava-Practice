package com.ds.string;

import java.io.*;
import java.util.*;


//Implement the 'walk' method.
//Assume robot inital position is (0,0).
//walk method take path where each character corresponds to a movement of the robot.
// The robot moves up, down, left, and right represented by the characters 'U', 'D', 'L', and 'R'
// Ignore other characters.


public class RobotMovement{

	// your code
	public static Integer[] walk( String move ) {
		int l = move.length(); 
        int countUp = 0, countDown = 0; 
        int countLeft = 0, countRight = 0; 
  
        // traverse the instruction string  
        // 'move' 
        for (int i = 0; i < l; i++) { 
  
            // for each movement increment  
            // its respective counter 
            if (move.charAt(i) == 'U') 
                countUp++; 
                  
            else if (move.charAt(i) == 'D') 
                countDown++; 
                  
            else if (move.charAt(i) == 'L') 
                countLeft++; 
                  
            else if (move.charAt(i) == 'R') 
                countRight++; 
        } 
  
 
		return new Integer[] {countRight - countLeft, countUp - countDown};
	}

	public static boolean isEqual(Integer[] a, Integer[] b) {
		return Arrays.equals(a, b);
	}

	public static boolean pass() {
		boolean res = true;

		{
			String test = "UUU";
			Integer[] result = walk(test);
			res &= isEqual(result, new Integer[]{0, 3});
		}

		{
			String test = "ULDR";
			Integer[] result = walk(test);
			res &= isEqual(result, new Integer[]{0, 0});
		}

		{
			String test = "ULLLDUDUURLRLR";
			Integer[] result = walk(test);
			res &= isEqual(result, new Integer[]{-2, 2});
		}

		{
			String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
			Integer[] result = walk(test);
			res &= isEqual(result, new Integer[]{1, 1});
		}

		return res;
	}

	public static void main(String[] args) {
		if(pass()){
			System.out.println("Pass");
		} else {
			System.out.println("Test failures");
		}
	}
}