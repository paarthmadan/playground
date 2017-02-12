package ccc2015;
import java.util.Scanner;

public class J1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int month = input.nextInt();
		int day = input.nextInt();
		
		if((month >= 2 && day > 18) || month >= 3){
			System.out.println("After");
		}else if((month == 2 && day < 18) || month < 2){
			System.out.println("Before");
		}else{
			System.out.println("Special");
		}
	}
}
