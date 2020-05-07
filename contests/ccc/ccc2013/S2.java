package ccc2013;
import java.util.Scanner;

public class S2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int maximumWeight = input.nextInt();
		int numberOfCars = input.nextInt();
		
		int [] cars = new int[numberOfCars];
		
		for(int i = 0; i < cars.length; i++){
			cars[i] = input.nextInt();
		}
		
		int maxCar = cars.length;
		int runningTotal = 0;
		int count = 0;
		
		for(int i = 0; i < cars.length; i++){
			runningTotal += cars[i];
			if(runningTotal > maximumWeight){
				maxCar = i;
				i = cars.length;
			}
			count++;
			if(count % 4 == 0){
				runningTotal -= cars[i - 3];
				count--;
			}						
		}
		System.out.println(maxCar);
	}
}
