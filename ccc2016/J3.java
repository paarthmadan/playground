package ccc2016;
import java.util.Scanner;
public class J3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
	
		String word = input.nextLine();
		String longestWord = "";
		
		for(int i = 0; i <= word.length(); i++){
			for(int j = i; j <= word.length(); j++){
				String tempString = word.substring(i, j);
				
				if(isPalindrome(tempString)){		
					if(longestWord.length() < tempString.length()){
						longestWord = tempString;
					}
				}
			}
		}
		System.out.println(longestWord.length());
	}
	
	public static boolean isPalindrome(String temp){
		String reverseString = "";
		
		for(int i = temp.length() - 1; i >= 0; i--){
			reverseString += temp.charAt(i);
		}
		return temp.equals(reverseString);
	}
}
