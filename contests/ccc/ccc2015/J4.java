package ccc2015;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class J4 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int m = input.nextInt();
		input.nextLine();
		
		int [] record = new int[100];
		
		int timeCount = 0;
		
		for(int i = 0; i < m; i++){
			String entryLine = input.nextLine();
			char entry = entryLine.split(" ")[0].charAt(0);
			int number = Integer.parseInt(entryLine.split(" ")[1]);
			
			if(entry == 'W'){
				timeCount += number - 1;
			}
			else{
				timeCount++;
				
				if(entry == 'R'){
					record[number - 1] -= timeCount;
				}else{
					record[number - 1] += timeCount;
				}
			}
		}
		
		for(int i = 0; i < record.length; i++){
			if(record[i] > 0)
				System.out.println(i + 1 + " " + record[i]);
			else if(record[i] < 0)
				System.out.println(i + 1 + " " + "-1");
		}
		
	}
}
