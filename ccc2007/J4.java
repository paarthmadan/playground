package ccc2007;
import java.util.Scanner;

public class J4 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first phrase> ");
		String firstPhrase = input.nextLine().replaceAll(" ", "");
		System.out.print("Enter second phrase> ");
		String secondPhrase = input.nextLine().replaceAll(" ", "");
		
		String mainPhrase = (firstPhrase.length() >= secondPhrase.length()) ? firstPhrase : secondPhrase;
		String bufferPhrase = (firstPhrase.length() < secondPhrase.length()) ? firstPhrase : secondPhrase;
		
		char [] letterCheck = bufferPhrase.toCharArray(); 
		
		for(char a : letterCheck)
			mainPhrase = mainPhrase.replace(String.valueOf(a), "");
		
		if(mainPhrase.equals("") || mainPhrase.equals(null))
			System.out.println("Is an anagram.");
		else
			System.out.println("Is not an anagram.");
	}
}
