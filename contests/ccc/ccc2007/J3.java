package ccc2007;

import java.util.Scanner;

public class J3 {
	public static void main(String [] args){
		int [] amounts = {100, 500, 1000, 5000, 10000, 25000, 50000, 100000, 500000, 1000000}; 
		int size = amounts.length - 1;
		
		Scanner input = new Scanner(System.in);
		int numberOfSelectedCases = input.nextInt();
		
		for(int i = 0; i < numberOfSelectedCases; i++)
			amounts[input.nextInt() - 1] = 0; size--;
		
		int total = 0;
		
		for(int i : amounts)
			total += i;
		
		if((total / size) > input.nextInt())
			System.out.println("no deal");
		else
			System.out.println("deal");
	}
}
