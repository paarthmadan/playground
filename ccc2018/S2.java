package ccc2018;

import java.util.Scanner;

public class S2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [][] data = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				data[i][j] = input.nextInt();
			}
		}
	}
}
