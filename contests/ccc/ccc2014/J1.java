package ccc2014;
import java.util.Scanner;

public class J1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int firstAngle = input.nextInt();
		int secondAngle = input.nextInt();
		int thirdAngle = input.nextInt();
		
		if((firstAngle + secondAngle + thirdAngle) != 180){
			System.out.println("Error");
		}else if(firstAngle == secondAngle && secondAngle == thirdAngle){
			System.out.println("Equilateral");
		}else if(firstAngle == secondAngle || secondAngle == thirdAngle || firstAngle == thirdAngle){
			System.out.println("Isosceles");
		}else{
			System.out.println("Scalene");
		}
		
	}
}
