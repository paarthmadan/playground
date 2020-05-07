package ccc2013;

import java.util.Scanner;

public class S1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int startingYear = input.nextInt();
		int nextYear = startingYear + 1;
		boolean isDistinct = false;
		
		while(!isDistinct){
			int[] digitTally = new int[10];
			for(char digit : String.valueOf(nextYear).toCharArray()){
				digitTally[Integer.valueOf(String.valueOf(digit))]++;
			}
			int max = -1;
			for(int i : digitTally)
				if(i > max)
					max = i;
			if(max <= 1)
				isDistinct = true;
			else
				nextYear++;
		}
		
		System.out.println(nextYear);
	}
}
