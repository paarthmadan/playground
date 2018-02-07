package ccc2016;

import java.util.Scanner;
public class S1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		String word = input.nextLine();
		String anagram = input.nextLine();
		int [] wordCount = new int[26];
		int [] anagramCount = new int[26];
		for(char letter : word.toCharArray()) 
			wordCount[(int)(letter) -  97]++;	
		int asteriksCount = 0;
		for(char letter : anagram.toCharArray()) 
			if(letter != '*')
				anagramCount[(int)(letter) - 97]++;
			else
				asteriksCount++;
		
		boolean isNegative = false;
		int total = 0;
		
		for(int i = 0; i < wordCount.length; i++){
			if(wordCount[i] - anagramCount[i] < 0)
				isNegative = false;
			else
				total += wordCount[i] - anagramCount[i];;
		}		
		
		if(total == asteriksCount && !isNegative)
			System.out.println("A");
		else
			System.out.println("N");
	}
}
