package ccc2015;
import java.util.Scanner;

public class J2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		
		int originalLength = text.length();
		
		int happyCount = (originalLength - text.replaceAll(":-\\)", "").length()) / 3;
		int sadCount = (originalLength - text.replaceAll(":-\\(", "").length()) / 3;
	
		if(happyCount == sadCount && happyCount == 0){
			System.out.println("none");
		}else if(happyCount > sadCount){
			System.out.println("happy");
		}else{
			System.out.println("sad");
		}
	}
}
