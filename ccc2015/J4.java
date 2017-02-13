package ccc2015;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class J4 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int numberOfEntries = input.nextInt();
		//BUFFER for RETURN KEY
		input.nextLine();
		
		//PARALLEL ARRAYS
		char [] entryType = new char[numberOfEntries];
		int [] entryFriend = new int[numberOfEntries];
		
		for(int i = 0; i < numberOfEntries; i++){
			String entry = input.nextLine();
			entryType[i] = entry.charAt(0);
			entryFriend[i] = Integer.parseInt(entry.split(" ")[1]);
		}
		
		ArrayList<Integer> friendNumbers = new ArrayList<Integer>();
		
		for(int i : entryFriend){
			if(!friendNumbers.contains(i)){
				friendNumbers.add(i);
			}
		}
		
		friendNumbers.sort(null);
	
		for(int friend : friendNumbers){
			
			int startingPosition = -1;
			
			for(int i = 0; i < entryFriend.length; i++){
				if(entryFriend[i] == friend){
					startingPosition = i;
					i = entryFriend.length;
				}
			}
			
			System.out.println("Friend: " + friend + " Original Position: " + startingPosition);
			
		}
		
	}
}
