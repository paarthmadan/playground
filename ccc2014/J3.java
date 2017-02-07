package ccc2014;
import java.util.Scanner;

public class J3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int numberOfRounds = input.nextInt();
		
		int aScore = 100;
		int dScore = 100;
		
		for(int i = 0; i < numberOfRounds; i++){
			
			int aRollValue = input.nextInt();
			int dRollValue = input.nextInt();
			
			if(aRollValue > dRollValue){
				dScore -= aRollValue;
			}else if(dRollValue > aRollValue){
				aScore -= dRollValue;
			}
			
		}
		
		System.out.println(aScore);
		System.out.println(dScore);
		
	}
}
