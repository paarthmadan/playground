package ccc2013;
import java.util.Scanner;
import java.util.Arrays;

public class J4 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int totalMinutes = input.nextInt();
		int numberOfChores = input.nextInt();
		
		int [] chores = new int[numberOfChores];
		
		for(int i = 0; i < numberOfChores; i++){
			chores[i] = input.nextInt();
		}
		
		Arrays.sort(chores);
		
		int numberOfCompletedChores = 0;
		
		for(int i = 0; i < chores.length; i++){
			int amountOfTime = chores[i];
			
			if(amountOfTime <= totalMinutes){
				numberOfCompletedChores++;
				totalMinutes -= amountOfTime;
			}else{
				i = chores.length;
			}
		}
		
		System.out.println(numberOfCompletedChores);
	}
}
