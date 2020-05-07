package ccc2011;
import java.util.Scanner;
public class J2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int h = input.nextInt();
		int max = input.nextInt();
		int t = 0;
		boolean isUnderZero = false;
		while(t < max){
			t++;
			if((-6*(Math.pow(t, 4)) + h*(Math.pow(t, 3)) + 2*(Math.pow(t, 2)) + t) < 0){
				System.out.println("The balloon first touches ground at hour:\n" + t);
				isUnderZero = true; 
				break;
			}
		}
		if(!isUnderZero){
			System.out.println("The balloon does not touch ground in the given time.");
		}
	}
}
