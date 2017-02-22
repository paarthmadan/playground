package ccc2017;
import java.util.Scanner;

public class J4 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int hour = 12;
		int minute = 0;
		
		int count = 0;
		
		int d = input.nextInt();
		
		for(int i = 0; i < d; i++){
			minute++;
			
			if(minute >= 60){
				minute = 0;
				hour++;
				hour = hour % 12;
			}
			
			String minuteZero = "";
			
			if(minute < 10){
				minuteZero = "0";
			}
			
			String time = hour + ":" + minuteZero + minute;
			
			if(isSequence(time)){
				count++;
			}
			
		}	
		System.out.println(count);
	}
	
	public static boolean isSequence(String time){
		
		
		time = time.replaceAll(":", "");
		
		int[] digits = new int[time.length()];
		
		for(int i = 0; i < time.length(); i++){
			digits[i] = Integer.parseInt(String.valueOf(time.charAt(i)));
		}
		
		int firstDifference = digits[1] - digits[0];
		
		boolean isDifferent = false;
		
		for(int i = 1; i < digits.length - 1; i++){
			int newDifference = digits[i + 1] - digits[i];
			
			if(newDifference != firstDifference){
				isDifferent = true;
				i = digits.length - 1;
			}
			
			firstDifference = newDifference;
			
		}
		
		return !isDifferent;
	}
	
}
