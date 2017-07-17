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
		
		int distance = verticalComponent + horizontalComponent;
		
		if(distance <= battery && (battery - distance) % 2 == 0)
			System.out.println("Y");
		else
			System.out.println("N");
	}
}
