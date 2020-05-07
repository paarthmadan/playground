package ccc2011;
import java.util.Scanner;
public class J3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.println(sumac(input.nextInt(), input.nextInt()));
	}
	public static int sumac(int n, int m){
		if(n - m > m)
			return 3;
		else
			return 1 + sumac(m, n-m);
	}
}
