package ccc2017;
import java.util.Scanner;


public class J3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int startX = input.nextInt();
		int startY = input.nextInt();
		int endX = input.nextInt();
		int endY = input.nextInt();
		int battery = input.nextInt();
	
		int verticalComponent = Math.abs(endY - startY);
		int horizontalComponent = Math.abs(endX - startX);
		
		int totalDistance = (verticalComponent + horizontalComponent);
		
		if(totalDistance % 2 == 0 && battery % 2 == 1){
			System.out.println("N");
		}else{
			System.out.println("Y");
		}
		
		
	}
}
