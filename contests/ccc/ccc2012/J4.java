package ccc2012;
import java.util.Scanner;
public class J4 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		input.nextLine();
		String encoded = input.nextLine();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i < encoded.length(); i++){
			char letter = encoded.charAt(i);
			int shiftValue = (3 * (i + 1)) + k;
			int currentLetterPosition = alphabet.indexOf(letter);
			int newLetterPosition = currentLetterPosition - shiftValue;
			if(newLetterPosition < 0)
				newLetterPosition += 26;
			System.out.print(alphabet.charAt(newLetterPosition));
		}
	}
}
