package com.ds.string;


/* 
*					******** IMPORTANT ********
*
* THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
* USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
*
*/

import java.io.*;
import java.util.*;

public class ReverseString {
  public static String reverseStr( String str ){
    if( str.length() == 0 )
      return str;

    int strLength = str.length();
    StringBuilder sb = new StringBuilder( strLength );

    for( int i = strLength -1; i >= 0; i-- ) {
        sb.append(str.charAt(i));
    };

    return sb.toString();
  };


  public static void main(String[] args){
  String testString;
    String solution;
    boolean result = true;

    result = result && reverseStr("abcd").equals("dcba");
  
  if(result){
    System.out.println("All tests pass");
  }
  else{
    System.out.println("There are test failures");
  }

   }
}
