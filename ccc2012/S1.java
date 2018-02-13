package ccc2012;
import java.util.Scanner;

public class S1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt() - 1;
		System.out.println(((n) * (n - 1) * (n - 2))/6);
	}
}
