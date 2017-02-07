package ccc2014;
import java.util.Scanner;

public class J2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int aCount = 0;
		int bCount = 0;
		
		int number = input.nextInt();
		
		//BUFFER 
		input.nextLine();
		
		String voteString = input.nextLine();
		
		for(int i = 0; i < voteString.length(); i++){
			if(voteString.charAt(i) == 'A'){
				aCount++;
			}else{
				bCount++;
			}
		}
		
		if(aCount > bCount){
			System.out.println('A');
		}else if(bCount > aCount){
			System.out.println('B');
		}else{
			System.out.println("Tie");
		}
		
	}
}
