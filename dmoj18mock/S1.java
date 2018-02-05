package dmoj18mock;

import java.util.Arrays;
import java.util.Scanner;

public class S1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		int [] alphabetCount = new int[26];
		for(char letter : line.toCharArray())
			alphabetCount[(int)(letter) - 97]++;
		Arrays.sort(alphabetCount);
		int total = 0;
		for(int i = 0; i < alphabetCount.length - 2; i++)
			total += alphabetCount[i];
		System.out.println(total);
	}
}
