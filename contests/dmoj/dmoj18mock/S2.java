package dmoj18mock;

import java.util.Arrays;
import java.util.Scanner;

public class S2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [][] grid = new int[n][n];
		int [] medians = new int[n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				grid[i][j] = input.nextInt();
			}
			int [] currentMedianArray = grid[i];
			Arrays.sort(currentMedianArray);
			medians[i] = currentMedianArray[n/2];
		}
		Arrays.sort(medians);
		System.out.println(medians[n/2]);
	}
}
