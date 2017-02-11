package ccc2013;
import java.util.Scanner;

public class J2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		String [] filter = {"I", "O", "S", "H", "Z", "X", "N"};
		
		String word = input.nextLine();
		
		for(int i = 0; i < filter.length; i++){
			word = word.replaceAll(filter[i], "");
		}
		
		if(word.length() > 0){
			System.out.println("NO");
		}else{
			System.out.println("YES");
		}
		
	}
}
