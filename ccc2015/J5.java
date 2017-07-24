package ccc2015;
import java.util.Scanner;

public class J5 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		
		System.out.println(distribute(n, k, 1));
	}
	
	public static int distribute(int n, int k, int min){
		int ways = 0;
		
		if(n == k || k == 1){
			ways = 1;
		}else{
//			System.out.println(n/k);
			for(int i = min; i <= (n / k); i++){
//				System.out.printf("d(%d, %d, %d)\n", (n-i), (k-1), i);
				ways += distribute(n - i, k - 1, i);				
			}
		}
		return ways;
	}
	
}
