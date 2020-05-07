package ccc2016;

import java.util.Scanner;

public class J1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int wCount = 0;
		
		for(int i = 0; i < 6; i++){
			
			String letter = input.nextLine();
			if(letter.equals("W")){
				wCount++;
			}
		}
		
		if(wCount >= 5){
			System.out.println(1);
		}else if(wCount >= 3){
			System.out.println(2);
		}else if(wCount >= 1){
			System.out.println(3);
		}else{
			System.out.println(-1);
		}
		
	}
}
