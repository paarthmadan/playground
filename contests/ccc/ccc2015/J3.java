package ccc2015;
import java.util.Scanner;

public class J3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		String text = input.nextLine();
		char [] chars = text.toCharArray();
		char [] alphabet = "bcdfghjklmnpqrstvwxyz".toCharArray();
		String newText = null;
		
		for(int i = 0; i < chars.length; i++){
			
			if(chars[i] != 'a' || chars[i] != 'e' || chars[i] != 'i'|| chars[i] != 'o'|| chars[i] != 'u' ){
				char nearestVowel = nearestVowel(chars[i]);
				
				char cons = 0;
				boolean isLetterFound = false;
				int counter = 0;
				
				while(isLetterFound == false){
					System.out.println(chars[i]);
					System.out.println(counter);
					
					if(chars[i] == alphabet[counter]){
						isLetterFound = true;
						cons = alphabet[counter + 1];
					}else{
						counter++;
					}	
				}
				newText = newText + chars[i] + nearestVowel + cons; 
			}else{
				newText = newText + chars[i];
			}
		}	
		System.out.println(newText);
		
	}
	public static char nearestVowel(char a){
		if(a == 'b' || a == 'c'){
			return 'a';
		}else if(a == 'd' || a == 'f'|| a == 'g'){
			return 'e';
		}else if(a == 'h'|| a == 'j'|| a == 'k'|| a == 'l'){
			return  'i';
		}else if(a == 'm'|| a == 'n'|| a == 'p' || a == 'q'|| a == 'r'){
			return 'o';
		}else if(a == 's'|| a == 't'|| a == 'v'|| a == 'w'|| a == 'x'|| a == 'y'|| a == 'z'){
			return 'u';
		}else{
			return 'E';
		}
	}
}
