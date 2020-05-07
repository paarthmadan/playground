package ccc2017;
import java.util.Scanner;

public class J2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int baseNumber = input.nextInt();
		int numberOfRounds = input.nextInt();
		
		int total = baseNumber;
		
		for(int i = 1; i <= numberOfRounds; i++){
			int tempNumber = (int) (baseNumber * Math.pow(10, i));
			total += tempNumber;
		}
		
		System.out.println(total);
		
	}
}
