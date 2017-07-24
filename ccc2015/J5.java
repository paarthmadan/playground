package ccc2015;
import java.util.Scanner;

public class J5 {
	private static int [][][] saved;
	
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		
		saved = new int[n + 1][k + 1][n];
		
		System.out.println(distribute(n, k, 1));
	}
	
	public static int distribute(int n, int k, int min){
		if(saved[n][k][min] == 0){
			if(n == k || k == 1)
				saved[n][k][min] = 1;
			else
				for(int i = min; i <= (n / k); i++)
					saved[n][k][min] += distribute(n - i, k - 1, i);				
		}
		return saved[n][k][min];
	}
	
}
