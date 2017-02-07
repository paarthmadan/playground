package ccc2014;
import java.util.Scanner;

public class J4 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int numberOfGuests = input.nextInt();
		int roundsOfRemoval = input.nextInt();
		
		int[] guests = new int[numberOfGuests];
		
		for(int i = 0; i < guests.length; i++){
			guests[i] = i + 1;
		}
		
		for(int i = 0; i < roundsOfRemoval; i++){
			int removalFactor = input.nextInt();
			int counter = 0; 
			for(int j = 0; j < guests.length; j++){
				if(guests[j] != -1){
					counter++;
				}
				
				if(counter % removalFactor == 0){
					guests[j] = -1;
				}
				
			}
		}
		
		for(int i = 0; i < guests.length; i++){
			if(guests[i] != -1){
				System.out.println(guests[i]);
			}
		}
		
	}
}
