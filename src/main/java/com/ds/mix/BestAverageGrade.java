package com.ds.mix;

import java.io.*;
import java.util.*;

//  Find the best average grade.
//  Given a list of student test scores
//  Each student may have more than one test score in the list.

class Score {
	int score;
	int count;
	Score(int score, int count) {
		this.count = count;
		this.score = score;
	}
}
class BestAverageGrade
{
	
	public static Integer bestAvgGrade(String[][] scores) {
		Map<String, Score> gradeMap = new HashMap<String, Score>();
			
		for(int i = 0; i < scores.length; i++) {
			if(gradeMap.containsKey(scores[i][0])) {
				Score s = gradeMap.get(scores[i][0]);
				s.count++;
				s.score = s.score + Integer.parseInt(scores[i][1]);
				gradeMap.put(scores[i][0],   s);
			} else {
				gradeMap.put(scores[i][0], new Score(Integer.parseInt(scores[i][1]), 1));
			}
		}
		
		int max = 0;
		for(int i = 0; i < scores.length; i++) {
			Score s = gradeMap.get(scores[i][0]);
			int avg = s.score / s.count;
			if(max < avg)
				max = avg;
		}
			
		return max;
	}

	public static boolean pass()
	{
		String[][] s1 = { { "Rohan", "84" },
				{ "Sachin", "102" },
				{ "Ishan", "55" },
				{ "Sachin", "18" } };

		return bestAvgGrade(s1) == 84;
	}

	public static void main(String[] args)
	{
		if(pass())
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Some Fail");
		}
	}
}
