package ccc2013;
import java.util.Scanner;

public class J3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int startingYear = input.nextInt();
		
		startingYear++;
		
		while(isDistinct(startingYear) == false){
			startingYear++;
		}
		
		System.out.println(startingYear);
		
	}
	
	public static boolean isDistinct(int year){
		
		boolean isDistinct = true;
		
		int [] digits = new int[10];
		
		while(!(year == 0)){
			digits[year % 10]++;
			year /= 10;
		}
		
		for(int i = 0; i < digits.length; i++){
			if(digits[i] > 1){
				isDistinct = false;
				i = digits.length;
			}
		}
		
		return isDistinct;
	}
	
}
